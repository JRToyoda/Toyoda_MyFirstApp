package com.example.toyoda_myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView deedee;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button input
        deedee = findViewById(R.id.imageView1);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kill();
                openMedia();
            }
        });

        //button2 input
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revive();
                openMedia2();
            }
        });
    }

    //button output
    private void kill() {
        deedee.setImageResource(R.drawable.deead);
    }

    private void openMedia() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.Kill);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlayer();
            }
        });
        mediaPlayer.start();
    }

    private void stopPlayer() {
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
        }
    }

    //button2 output
    private void revive() {
        deedee.setImageResource(R.drawable.deedee);
    }

    private void openMedia2() {
        mediaPlayer2 = new MediaPlayer();
        mediaPlayer2 = MediaPlayer.create(this, R.raw.revive);
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlayer2();
            }
        });
        mediaPlayer2.start();
    }

    private void stopPlayer2() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}