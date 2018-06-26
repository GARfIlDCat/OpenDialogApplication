package com.example.garfild.opendialogapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class OpenFileDialog extends AlertDialog.Builder {

    private String currentPath = Environment.getExternalStorageDirectory().getPath();
    private String TAG = "MyLog";

    public OpenFileDialog(Context context) {
        super(context);
        setPositiveButton(android.R.string.ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .setItems(getFiles(currentPath), null);
    }

    private String[] getFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        Log.d(TAG, "files.length - " + files.length);
        String[] result = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            result[i] = files[i].getName();
        }
        return result;
    }
}