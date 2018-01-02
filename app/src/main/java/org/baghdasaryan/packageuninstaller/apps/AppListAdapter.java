package org.baghdasaryan.packageuninstaller.apps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.baghdasaryan.packageuninstaller.R;
import org.baghdasaryan.packageuninstaller.data.apps.App;

import java.util.ArrayList;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private ArrayList<App> data = new ArrayList<>();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_row_item, parent, false);
        return new ViewHolder(v);
    }

    public void setData(ArrayList<App> apps) {
        data = apps;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = data.get(position).getName();
        holder.getAppNameTextView().setText(name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView appNameTextView = null;

        ViewHolder(View itemView) {
            super(itemView);
            appNameTextView = itemView.findViewById(R.id.app_name);
        }

        TextView getAppNameTextView() {
            return appNameTextView;
        }
    }
}
