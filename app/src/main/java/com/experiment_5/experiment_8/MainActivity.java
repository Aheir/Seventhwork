package com.experiment_5.experiment_8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import android.graphics.PixelFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    /**Calledwhentheactivityisfirstcreated.*/

    VideoView videoView;
    private String fielname;
    MediaController mediaController;
    EditText editText;
    Button openBtn;
    Button quitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*publicWindowgetWindow()返回当前activity的window
          voidandroid.view.Window.setFormat(intformat)
          publicvoidsetFormat(intformat)设置窗口的像素格式
          PixelFormat.TRANSLUCENT透明格式*/
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.video);
        editText = findViewById(R.id.editttext);
        openBtn = findViewById(R.id.starttoplay);
        openBtn.setOnClickListener(new startlistener());
        quitBtn = findViewById(R.id.Quit);
        quitBtn.setOnClickListener(new qiutlistener());
        mediaController = new MediaController(this);
    }

    class startlistener implements OnClickListener{
        @Override
        public void onClick(View v)
        {
            //TODO Auto-generated methodstub
            fielname=editText.getText().toString();
            System.out.println(fielname);
            //Filevideo = new File("/sdcard/re.mp4");
            File video = new File(fielname);
            //若文件被找到
            if(video.exists()){
                //文件绝对路径
                videoView.setVideoPath(video.getAbsolutePath());
                //设置videoView与mediaControler的关联
                videoView.setMediaController(mediaController);
                mediaController.setMediaPlayer(videoView);
                videoView.requestFocus();
            }
            else{
                Toast.makeText(MainActivity.this,"键入的文件不存在，请重新输入",Toast.LENGTH_LONG).show();
            }

        }
    }

    class qiutlistener implements OnClickListener{
        @Override
        public
        void onClick(View v){
            //TODOAuto-generated method stub
             finish();
        }
    }
}
