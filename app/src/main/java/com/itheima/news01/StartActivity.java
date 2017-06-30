package com.itheima.news01;

import android.content.Intent;
import android.os.SystemClock;


public class StartActivity extends BaseActivity {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_start;
    }

    @Override
    public void initView() {

        new Thread() {
            public void run() {
                SystemClock.sleep(1500);

                enterGuideActivity();
            }
        }.start();
    }


    private void enterGuideActivity() {
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
