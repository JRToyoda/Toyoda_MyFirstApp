package com.example.toyoda_myfirstapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    ImageView deedee;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button input
        deedee = findViewById(R.id.imageView1);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            kill();
            openMedia();
        });

        //button2 input
        button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            revive();
            openMedia2();
        });
    }

    //button output
    private void kill() {
        deedee.setImageResource(R.drawable.deead);
    }

    private void openMedia() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.kill);
        mediaPlayer.setOnCompletionListener(mediaPlayer -> stopPlayer());
        mediaPlayer.start();
    }

    //button2 output
    private void revive() {
        deedee.setImageResource(R.drawable.deedee);
    }

    private void openMedia2() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.revive);
        mediaPlayer.setOnCompletionListener(mediaPlayer -> stopPlayer());
        mediaPlayer.start();
    }

    //stop
    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}