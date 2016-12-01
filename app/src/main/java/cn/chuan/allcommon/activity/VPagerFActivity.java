package cn.chuan.allcommon.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gxz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.adapter.ItemTitlePagerAdapter;
import cn.chuan.allcommon.fragment.GoodsCommentFragment;
import cn.chuan.allcommon.fragment.GoodsDetailFragment;
import cn.chuan.allcommon.fragment.GoodsInfoFragment;
import cn.chuan.allcommon.until.widget.NoScrollViewPager;

public class VPagerFActivity extends AppCompatActivity {
    @Bind(R.id.ll_back)
    public LinearLayout llBack;
    @Bind(R.id.psts_tabs)
    public PagerSlidingTabStrip pstsTabs;
    @Bind(R.id.vp_content)
    public NoScrollViewPager vpContent;
    @Bind(R.id.tv_title)
    public TextView tvTitle;

    private List<Fragment> fragmentList = new ArrayList<>();
    private GoodsInfoFragment goodsInfoFragment;
    private GoodsDetailFragment goodsDetailFragment;
    private GoodsCommentFragment goodsCommentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpagerf);
        ButterKnife.bind(this);
        fragmentList.add(goodsInfoFragment = new GoodsInfoFragment());
        fragmentList.add(goodsDetailFragment = new GoodsDetailFragment());
        fragmentList.add(goodsCommentFragment = new GoodsCommentFragment());
        vpContent.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                fragmentList, new String[]{"商品", "详情", "评价"}));
        vpContent.setOffscreenPageLimit(3);
        pstsTabs.setViewPager(vpContent);
    }

    @OnClick(R.id.ll_back)
    public void onClick() {
        finish();
    }
}
