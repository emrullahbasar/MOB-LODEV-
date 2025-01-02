package com.example.moblodev;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import Entity.AppDatabase;
import Entity.Car;

public class MainActivity3 extends AppCompatActivity {

    public AppDatabase db;
    public VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        videoView = findViewById(R.id.videoView);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "CARDB").build();

        int carId = getIntent().getIntExtra("CAR_ID", -1);

        if (carId != -1) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Car car = db.carDao().findById(carId);
                    if (car != null && car.getvideoUrl() != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                videoView.setVideoURI(Uri.parse(car.getvideoUrl()));
                                videoView.setOnPreparedListener(mp -> mp.start());

                            }
                        });
                    }
                }
            }).start();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
