package org.baghdasaryan.packageuninstaller.data.apps;

import org.baghdasaryan.packageuninstaller.data.ApplicationRepositoryInterface;

import java.util.ArrayList;

public class AppListService {

    private ApplicationRepositoryInterface repository = null;

    public AppListService(ApplicationRepositoryInterface repository) {
        this.repository = repository;
    }

    public ArrayList<App> getInstalledApps() {
        return repository.getInstalledApps();
    }

}
