package com.example.myapplication;

import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.ui.PlayerView;

import java.util.List;

public class ShowADSActivity extends AppCompatActivity {
//    private VideoView videoViewADs;
//    private String[] listVideoUrl = {
//            "https://storage.googleapis.com/test-9f696.appspot.com/video2.mp4",
//            "https://storage.googleapis.com/test-9f696.appspot.com/video3.mp4",
//    };
//    private int currentVideoIndex = 0;

//    PlayerView playerView;
//    ExoPlayer exoPlayer;

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

        //----------------
//        playerView = findViewById(R.id.view_video_ads);
//        exoPlayer = new ExoPlayer.Builder(this).build();
//        playerView.setPlayer(exoPlayer);
//        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.test;
//        Uri videoUri = Uri.parse(videoPath);
//        MediaItem mediaItem = MediaItem.fromUri(videoUri);
//        exoPlayer.setMediaItem(mediaItem);
//        exoPlayer.prepare();
//        exoPlayer.play();
        //----------------

        //run only video
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.test;
        VideoView videoAD = findViewById(R.id.videoViewADs);
        Uri uri = Uri.parse(videoPath);
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