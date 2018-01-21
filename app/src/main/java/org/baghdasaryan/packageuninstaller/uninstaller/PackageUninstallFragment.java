package org.baghdasaryan.packageuninstaller.uninstaller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import org.baghdasaryan.packageuninstaller.data.apps.App;

import static com.google.common.base.Preconditions.checkNotNull;

public class PackageUninstallFragment extends DialogFragment {

    private App app = null;

    public void setApp(App app) {
        this.app = app;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        app = checkNotNull(app, "app can not be null");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Uninstaller")
                .setMessage("Do you really want to uninstall this app")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String applicationPackageName = app.getPackageName();
                        if (applicationPackageName != null) {
                            try {
                                Intent intent = new Intent(Intent.ACTION_DELETE);
                                intent.setData(Uri.parse("package:" + applicationPackageName));
                                startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                dismiss();
                            }
                        } else {
                            dismiss();
                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });
        setCancelable(false);
        return builder.create();
    }
}
