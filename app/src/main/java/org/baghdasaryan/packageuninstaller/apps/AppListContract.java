package org.baghdasaryan.packageuninstaller.apps;


import org.baghdasaryan.packageuninstaller.BaseView;
import org.baghdasaryan.packageuninstaller.BasePresenter;
import org.baghdasaryan.packageuninstaller.data.apps.App;

import java.util.ArrayList;

interface AppListContract {

    interface View extends BaseView<Presenter> {
        void onApplicationsAvailable(ArrayList<App> apps);
    }

    interface Presenter extends BasePresenter {
        void queryInstalledApps();
    }
}
