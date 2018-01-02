package org.baghdasaryan.packageuninstaller.data;

import android.content.pm.ResolveInfo;

import org.baghdasaryan.packageuninstaller.data.apps.App;

import java.util.ArrayList;

public interface ApplicationRepositoryInterface {

    ArrayList<App> getInstalledApps();
}
