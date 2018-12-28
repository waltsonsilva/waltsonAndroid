package com.example.walts.projetowidgets;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);


        VideoView vv = (VideoView) findViewById(R.id.videoView2);

        Uri src = Uri.parse("http://www.agileapps.com.br/teste.mp4");
        vv.setVideoURI(src);

        vv.setMediaController(new MediaController(this));
    }
}
