package com.example.playvediotest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    private Button play,pause,replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        replay = (Button) findViewById(R.id.replay);
        videoView = (VideoView) findViewById(R.id.viedo_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();
    }

    private void initVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory()
        ,"movie.3gp");
        videoView.setVideoPath(file.getPath());//指定视频文件的路径
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play:
                if (!videoView.isPlaying()){
                    videoView.start();//开始播放
                }
                break;
            case R.id.pause:
                if (videoView.isPlaying()){
                    videoView.pause();//暂停播放
                }
                break;
            case R.id.replay:
                if (videoView.isPlaying()){
                    videoView.resume();//重新播放
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null){
            videoView.suspend();//调用此方法将VideoView所占用的资源释放掉。
        }
    }
}
