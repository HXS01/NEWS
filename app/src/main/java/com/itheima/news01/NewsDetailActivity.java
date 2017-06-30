package com.itheima.news01;

import android.webkit.WebView;

import com.itheima.news01.bean.NewsEntity;


public class NewsDetailActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initView() {
        initWebView();
    }

    private void initWebView() {
        webView = (WebView) findViewById(R.id.web_view);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

        NewsEntity.ResultBean newsBean = (NewsEntity.ResultBean)
                getIntent().getSerializableExtra("news");

        String newUrl = newsBean.getUrl();
        webView.loadUrl(newUrl);
    }
}
