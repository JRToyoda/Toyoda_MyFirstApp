package com.example.toyoda_myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView deedee;
    MediaPlayer mediaPlayer;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deedee = findViewById(R.id.imageView4);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedia();
                kill();
            }
        });
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revive();
                stop();
            }
        });
    }
    private void kill() {
        deedee.setImageResource(R.drawable.deead);
    }
    private void revive() {
        deedee.setImageResource(R.drawable.deedee);
    }
    private void openMedia() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.oggy);

        mediaPlayer.start();
    }
    private void stop() {
        mediaPlayer.stop();
    }
}