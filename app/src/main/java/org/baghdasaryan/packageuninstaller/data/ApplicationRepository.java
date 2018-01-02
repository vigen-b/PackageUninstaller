package org.baghdasaryan.packageuninstaller.data;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import org.baghdasaryan.packageuninstaller.data.apps.App;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository implements ApplicationRepositoryInterface {

    private Context context = null;

    public ApplicationRepository(Context context) {
        this.context = context;
    }

    @Override
    public ArrayList<App> getInstalledApps() {
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> appInfos = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        ArrayList<App> apps = new ArrayList<>();
        for (ApplicationInfo appInfo : appInfos) {
            if (null != appInfo) {
                App app = new App(appInfo.loadLabel(pm).toString(), appInfo.packageName, appInfo.icon);
                apps.add(app);
            }
        }
        return apps;
    }
}
