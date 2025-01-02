package com.example.moblodev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import Entity.AppDatabase;
import Entity.Car;
import adapter.CarAdapter;

public class MainActivity2 extends AppCompatActivity {

    public AppDatabase db;
    private CarAdapter carAdapter;
    public ImageView bmwm5, pg106, subi, vti;
    public List<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "CARDB").allowMainThreadQueries().build();

        bmwm5 = findViewById(R.id.bmwm5);
        pg106 = findViewById(R.id.pg106);
        subi = findViewById(R.id.subi);
        vti = findViewById(R.id.vti);

        bmwm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoUrl = "https://youtu.be/naxryH4rc1M?si=ldApAf4a9NNqUsA5";
                openYouTubeVideo(videoUrl);
            }
        });

        pg106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoUrl = "https://youtu.be/dq-B-30M7f8";
                openYouTubeVideo(videoUrl);
            }
        });

        subi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoUrl = "https://www.youtube.com/watch?v=TsIEJYZVAfA";
                openYouTubeVideo(videoUrl);
            }
        });

        vti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoUrl = "https://youtu.be/13hI4n5Wh4E";
                openYouTubeVideo(videoUrl);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openYouTubeVideo(String videoUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(videoUrl));
        intent.setPackage("com.google.android.youtube");

        // YouTube uygulaması yüklü değilse tarayıcıda aç
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            intent.setPackage(null);
            startActivity(intent);
        }
    }
}