package com.itheima.news01;

import android.animation.Animator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class GuideActivity extends BaseActivity {

    private ImageView iv01;


    private int index = 0;


    private boolean mExitActivity = false;


    private int[] mImagesRes = new int[] {
            R.drawable.ad_new_version1_img1,
            R.drawable.ad_new_version1_img2,
            R.drawable.ad_new_version1_img3,
            R.drawable.ad_new_version1_img4,
            R.drawable.ad_new_version1_img5,
            R.drawable.ad_new_version1_img6,
            R.drawable.ad_new_version1_img7,
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_guide;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mExitActivity = true;

        stopMusic();
    }

    private Button btnEnter;

    @Override
    public void initView() {
        btnEnter = (Button) findViewById(R.id.btn_01);
        iv01 = (ImageView) findViewById(R.id.iv_01);


        startViewAnimation();

        playMusic();
    }


    private void startViewAnimation() {

        int imageId = mImagesRes[index % mImagesRes.length];
        iv01.setBackgroundResource(imageId);
        index ++;


        iv01.setScaleX(1f);
        iv01.setScaleY(1f);




        iv01.animate()

                .scaleX(1.2f)
                .scaleY(1.2f)


                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        if (!mExitActivity) {
                            startViewAnimation();
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                })
                .start();
    }

    @Override
    public void initListener() {
        btnEnter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                stopMusic();

                enterHomeActivity();
            }
        });
    }


    private void enterHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void initData() {
    }


    private MediaPlayer mMediaPlayer;


    private void playMusic() {
        try {
            mMediaPlayer = MediaPlayer.create(this, R.raw.new_version);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.setVolume(1f, 1f);
            mMediaPlayer.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private void stopMusic() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();

            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }


}
