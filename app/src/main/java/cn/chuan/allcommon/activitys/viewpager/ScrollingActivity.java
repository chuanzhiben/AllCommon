package cn.chuan.allcommon.activitys.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.adapter.ToolbarAdapter;

public class ScrollingActivity extends AppCompatActivity {

    @Bind(R.id.img_zhangdan)
    ImageView imgZhangdan;
    @Bind(R.id.jiahao)
    ImageView jiahao;
    @Bind(R.id.tongxunlu)
    ImageView tongxunlu;
    @Bind(R.id.img_shaomiao)
    ImageView imgShaomiao;
    @Bind(R.id.img_fukuang)
    ImageView imgFukuang;
    @Bind(R.id.img_search)
    ImageView imgSearch;
    @Bind(R.id.img_zhaoxiang)
    ImageView imgZhaoxiang;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.myRecyclerView)
    RecyclerView myRecyclerView;
    @Bind(R.id.toolbar1)
    View mToolbar1;
    @Bind(R.id.toolbar2)
    View mToolbar2;
    @Bind(R.id.tv_zhangdan)
    TextView tvZhangdan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        toolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.blue));
        myRecyclerView.setAdapter(new ToolbarAdapter(this));
//        mToolbar1 = (View) findViewById(R.id.toolbar1);
//        mToolbar2 = (View) findViewById(R.id.toolbar2);


        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    //张开
                    mToolbar1.setVisibility(View.VISIBLE);
                    mToolbar2.setVisibility(View.GONE);
                    setToolbar1Alpha(255);
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    //收缩
                    mToolbar1.setVisibility(View.GONE);
                    mToolbar2.setVisibility(View.VISIBLE);
                    setToolbar2Alpha(255);
                } else {
                    int alpha = 255 - Math.abs(verticalOffset);
                    if (alpha < 0) {
                        Log.e("alpha", alpha + "");
                        //收缩toolbar
                        mToolbar1.setVisibility(View.GONE);
                        mToolbar2.setVisibility(View.VISIBLE);
                        setToolbar2Alpha(Math.abs(verticalOffset));
                    } else {
                        //张开toolbar
                        mToolbar1.setVisibility(View.VISIBLE);
                        mToolbar2.setVisibility(View.GONE);
                        setToolbar1Alpha(alpha);
                    }
                }
            }
        });
    }

    //设置展开时各控件的透明度
    public void setToolbar1Alpha(int alpha) {
        imgZhangdan.getDrawable().setAlpha(alpha);
        tvZhangdan.setTextColor(Color.argb(alpha, 255, 255, 255));
        tongxunlu.getDrawable().setAlpha(alpha);
        jiahao.getDrawable().setAlpha(alpha);
    }

    //设置闭合时各控件的透明度
    public void setToolbar2Alpha(int alpha) {
        imgShaomiao.getDrawable().setAlpha(alpha);
        imgFukuang.getDrawable().setAlpha(alpha);
        imgSearch.getDrawable().setAlpha(alpha);
        imgZhaoxiang.getDrawable().setAlpha(alpha);
    }

}
