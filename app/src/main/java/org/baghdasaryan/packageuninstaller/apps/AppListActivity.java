package org.baghdasaryan.packageuninstaller.apps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.baghdasaryan.packageuninstaller.R;
import org.baghdasaryan.packageuninstaller.data.ApplicationRepository;
import org.baghdasaryan.packageuninstaller.data.apps.App;
import org.baghdasaryan.packageuninstaller.data.apps.AppListService;
import org.baghdasaryan.packageuninstaller.uninstaller.PackageUninstallFragment;

import java.util.ArrayList;

public class AppListActivity extends AppCompatActivity implements AppListContract.View, AppListAdapter.OnAppItemClickListener {

    private AppListContract.Presenter presenter = null;
    private AppListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppListService service = new AppListService(new ApplicationRepository(this));
        presenter = new AppListPresenter(this, service);
        initializeContent();
    }

    private void initializeContent() {
        RecyclerView appListContainer = findViewById(R.id.apps_container);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        appListContainer.setLayoutManager(layoutManager);
        adapter = new AppListAdapter(this);
        appListContainer.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unSubscribe();
    }

    @Override
    public void setPresenter(AppListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onApplicationsAvailable(ArrayList<App> apps) {
        adapter.setData(apps);
    }

    @Override
    public void onClick(App app) {
        PackageUninstallFragment fragment = new PackageUninstallFragment();
        fragment.setApp(app);
        fragment.show(getFragmentManager(), "uninstall");
    }
}
