package com.example.myapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

public class DownloadHelper {

    private Context context;
    public DownloadHelper(Context context) {
        this.context = context;
    }

    public void downloadMp3(String url, String fileName) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setTitle("Downloading MP3");
        request.setDescription("Downloading " + fileName);

        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC, fileName);

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setAllowedOverRoaming(false);

        downloadManager.enqueue(request);
    }
}
