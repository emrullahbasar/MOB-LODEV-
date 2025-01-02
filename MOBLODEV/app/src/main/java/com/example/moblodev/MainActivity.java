package com.example.moblodev;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.room.Room;
import Entity.AppDatabase;
import Entity.Car;
import adapter.CarAdapter;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int ACTIVITY_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // wifi

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            if (!wifiManager.isWifiEnabled()) {
                Toast.makeText(this, "Wi-Fi AÇIK DEĞİL.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wi-Fi AÇIK .", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }, ACTIVITY_DURATION);
            }
        }


            ImageView back_g = findViewById(R.id.arkaplan);
            ImageView logo = findViewById(R.id.bmwlogo);
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.amination);
            logo.startAnimation(anim);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }