package org.baghdasaryan.packageuninstaller.data.apps;


public class App {

    private final String name;
    private final String packageName;
    private final int icon;

    public App(String name, String packageName, int icon) {
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public int getIcon() {
        return icon;
    }
}
