package org.baghdasaryan.packageuninstaller.apps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.baghdasaryan.packageuninstaller.R;
import org.baghdasaryan.packageuninstaller.data.apps.App;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private ArrayList<App> data = new ArrayList<>();
    private OnAppItemClickListener listener = null;

    AppListAdapter(OnAppItemClickListener l) {
        listener = checkNotNull(l, "Listner can not be null");
    }


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
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView appNameTextView = null;
        private App app = null;

        ViewHolder(View itemView) {
            super(itemView);
            appNameTextView = itemView.findViewById(R.id.app_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(app);
                }
            });
        }

        void bind(App app) {
            this.app = app;
            appNameTextView.setText(app.getName());
        }
    }

    interface OnAppItemClickListener {
        void onClick(App app);
    }
}
