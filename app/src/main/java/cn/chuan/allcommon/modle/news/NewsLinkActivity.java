package cn.chuan.allcommon.modle.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.R;

public class NewsLinkActivity extends AppCompatActivity {

    @Bind(R.id.webView) WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_link);
        ButterKnife.bind(this);

        String link = getIntent().getStringExtra("link");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(link);
    }
}
