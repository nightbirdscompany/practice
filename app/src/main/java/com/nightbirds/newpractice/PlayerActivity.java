package com.nightbirds.newpractice;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class PlayerActivity extends AppCompatActivity {
    public static String video_url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8";


    StyledPlayerView player;
    ExoPlayer eplayer;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_player);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        player = findViewById(R.id.player);








    }

    public void intilizeplayer (){

        eplayer = new ExoPlayer.Builder(this).build();
        player.setPlayer(eplayer);

        player.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);

        MediaItem mediaItem = MediaItem.fromUri(video_url);



        eplayer.setMediaItem(mediaItem);
        eplayer.prepare();
        eplayer.play();




    }

    @Override
    public void onWindowFocusChanged(boolean arg0) {
        super.onWindowFocusChanged(arg0);

        if (arg0){
            View decorView = getWindow().getDecorView();

            decorView.setSystemUiVisibility(

                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            );

        }
    }




    @Override
    protected void onStart() {
        super.onStart();

        intilizeplayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (eplayer == null){

            intilizeplayer();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (eplayer.isPlaying()){

            eplayer.stop();

        }
    }

    @Override

    public void onDestroy(){


        eplayer.release();
        super.onDestroy();
    }






}