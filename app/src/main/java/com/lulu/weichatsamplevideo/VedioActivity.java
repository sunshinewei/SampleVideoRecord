package com.lulu.weichatsamplevideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class VedioActivity extends AppCompatActivity {

    private Button mBtnMedia;
    private Button mBtnFrame;
    private ImageView mImgImgshow;

    private Bitmap mFrameImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        initView();
        initData();
    }

    private void initView(){
        mBtnMedia = (Button) findViewById(R.id.btn_media);
        mBtnFrame = (Button) findViewById(R.id.btn_frame);
        mImgImgshow = (ImageView) findViewById(R.id.img_imgshow);
    }

    private void initData(){
        mBtnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent=new Intent(VedioActivity.this,MainActivity.class);
                startActivityForResult(mIntent,1100);
            }
        });
        mBtnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFrameImg!=null){
                    mImgImgshow.setImageBitmap(mFrameImg);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1100){
            String path = data.getStringExtra("PATH");

            Toast.makeText(this, "路径" + path, Toast.LENGTH_SHORT).show();
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(path);
            mFrameImg= mmr.getFrameAtTime();
        }
    }
}
