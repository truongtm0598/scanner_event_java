package com.example.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;

import java.sql.Array;

public class ShowADSActivity extends AppCompatActivity {
    private VideoView videoViewAD;
    private List<String> videoUrls;
    private int currentVideoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_ads);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        videoUrls = new ArrayList<>();
        videoUrls.add("https://firebasestorage.googleapis.com/v0/b/test-9f696.appspot.com/o/videoplayback.mp4?alt=media&token=a44d99eb-96d6-47bf-812c-e031e2d86985");
        videoUrls.add("https://firebasestorage.googleapis.com/v0/b/test-9f696.appspot.com/o/video2.mp4?alt=media&token=1ce840fb-5717-412e-a4d5-e30125a97646");
        videoUrls.add("https://firebasestorage.googleapis.com/v0/b/test-9f696.appspot.com/o/video3.mp4?alt=media&token=c7230ef6-3904-431c-bdfb-656a70b75755");

        playNextVideo();
    }

    private void playNextVideo(){
        if(currentVideoIndex < videoUrls.size()){
            //set video URI
            Uri uri = Uri.parse(videoUrls.get(currentVideoIndex));
            videoViewAD.setVideoURI(uri);

            //start video
            videoViewAD.start();

            //listen status
            videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    currentVideoIndex ++;
                    //play next video
                    playNextVideo();
                }
            });
        }else{
            finish();
        }
    }
}