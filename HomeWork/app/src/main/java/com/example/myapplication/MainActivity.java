package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ComponentActivity {


    private DownloadHelper downloadHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button startServiceButton = findViewById(R.id.button1);
        startServiceButton.setOnClickListener(v -> startMyService());

        Button endServiceButton = findViewById(R.id.button2);
        endServiceButton.setOnClickListener(v -> stopService());


        downloadHelper = new DownloadHelper(this);
        Button dowloandButton = findViewById(R.id.button3);
        dowloandButton.setOnClickListener(v -> startDownload());
    }

    private void startMyService() {
        Intent serviceIntent = new Intent(this, MyForegroundService.class);
        serviceIntent.putExtra("Service Start", "Service is running...");
        startService(serviceIntent);
    }

    private void stopService() {
        Intent serviceIntent = new Intent(this, MyForegroundService.class);
        stopService(serviceIntent);
    }

    private void startDownload() {
        String url = "https://example.com/path/to/your/file.mp3"; // Замените на реальный URL
        String fileName = "example.mp3"; // Имя файла для сохранения
        downloadHelper.downloadMp3(url, fileName);
    }
}
