package hello;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.osgi.container.ModuleRevision;
import org.eclipse.osgi.internal.framework.EquinoxBundle;
import org.eclipse.osgi.storage.BundleInfo;
import org.eclipse.osgi.storage.BundleInfo.Generation;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.util.tracker.ServiceTracker;

@Component(immediate = true)
public class Reloader {

	ServiceTracker<PackageAdmin, PackageAdmin> packageAdminTracker;

	private boolean run = true;
	private int counter;

	Map<Long, FileTime> lastMod = new HashMap<>();

	void activate(BundleContext ctx) {
		packageAdminTracker = new ServiceTracker<>(ctx, PackageAdmin.class,
				null);
		packageAdminTracker.open();
		new Thread(() -> refresh(ctx)).start();
	}

	void deactivate() {
		run = false;
		packageAdminTracker.close();
	}

	private void refresh(BundleContext ctx) {
		while (run) {
			for (Bundle bundle : ctx.getBundles()) {
				checkBundle(bundle);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	private void checkBundle(Bundle bundle) {
		EquinoxBundle eb = (EquinoxBundle) bundle;
		ModuleRevision rev = eb.getModule().getCurrentRevision();
		Generation gen = (BundleInfo.Generation) rev.getRevisionInfo();
		File f = gen.getContent();
		Path p = Paths.get(f.getAbsolutePath(), "target", "classes");
		if (Files.isDirectory(p)) {
			Optional<Path> lastModifiedPath;
			try {
				lastModifiedPath = Files.walk(p).max(
						(f1, f2) -> getLM(f1).compareTo(getLM(f2)));
				if (lastModifiedPath.isPresent()) {
					Path lmp = lastModifiedPath.get();
					if (lmp.endsWith("Reloader.class")) {
						return;
					}
					FileTime lm = Files.getLastModifiedTime(lmp);
					FileTime prevTime = lastMod.get(bundle.getBundleId());
					if (prevTime == null || prevTime.compareTo(lm) < 0) {
						lastMod.put(bundle.getBundleId(), lm);
						System.out.println("Detected change in "
								+ lmp);
						refreshBundle(bundle);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private FileTime getLM(Path f1) {
		try {
			return Files.getLastModifiedTime(f1);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void refreshBundle(Bundle bundle) {
		PackageAdmin pa = packageAdminTracker.getService();
		if (pa != null) {
			pa.refreshPackages(new Bundle[] { bundle });
		}
	}

}