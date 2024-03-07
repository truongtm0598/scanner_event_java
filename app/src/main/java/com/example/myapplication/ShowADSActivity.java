package com.example.myapplication;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowADSActivity extends AppCompatActivity {
//    private VideoView videoViewADs;
//    private String[] listVideoUrl = {
//            "https://storage.googleapis.com/test-9f696.appspot.com/video2.mp4",
//            "https://storage.googleapis.com/test-9f696.appspot.com/video3.mp4",
//    };
//    private int currentVideoIndex = 0;

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

        //run only video
        String videoURL = "https://storage.googleapis.com/test-9f696.appspot.com/videoplayback.mp4";
        VideoView videoAD = findViewById(R.id.videoViewADs);
        Uri uri = Uri.parse(videoURL);
        videoAD.setVideoURI(uri);

        // Optionally, you can start playing the video immediately
        videoAD.start();

        //Run a list video
//        videoViewADs = findViewById(R.id.videoViewADs);
//        playVideo(currentVideoIndex);
    }

//    public void playVideo(int index) {
//        if (index >= 0 && index < listVideoUrl.length) {
//            videoViewADs.setVideoURI(Uri.parse(listVideoUrl[index]));
//            videoViewADs.setOnCompletionListener(mp -> {
//                currentVideoIndex++;
//                if (currentVideoIndex >= listVideoUrl.length) {
//                    currentVideoIndex = 0; // Reset index to loop through videos
//                }
//                playVideo(currentVideoIndex);
//
//            });
//            videoViewADs.start();
//        }
//    }
}