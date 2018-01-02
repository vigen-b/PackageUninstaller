package org.baghdasaryan.packageuninstaller.apps;

import org.baghdasaryan.packageuninstaller.data.apps.App;
import org.baghdasaryan.packageuninstaller.data.apps.AppListService;

import java.util.ArrayList;


class AppListPresenter implements AppListContract.Presenter {

    private AppListContract.View view = null;
    private AppListService service = null;

    AppListPresenter(AppListContract.View view, AppListService service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        queryInstalledApps();
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void queryInstalledApps() {
        view.onApplicationsAvailable(service.getInstalledApps());
    }
}
