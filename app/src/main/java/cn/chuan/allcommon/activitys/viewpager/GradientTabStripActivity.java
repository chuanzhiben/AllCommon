package cn.chuan.allcommon.activitys.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.widget.Toast;

import am.widget.basetabstrip.BaseTabStrip;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.adapter.GradientTabStripAdapter;
import cn.chuan.allcommon.base.BaseActivity;
import cn.chuan.allcommon.widget.GradientTabStrip;

public class GradientTabStripActivity extends BaseActivity implements
        ViewPager.OnPageChangeListener, BaseTabStrip.OnItemClickListener {

    private ViewPager vpFragments;
    private TextView tvTitle;
    private GradientTabStripAdapter adapter;

    @Override
    protected int getContentViewLayoutResources() {
        return R.layout.activity_gradienttabstrip;
    }

    @Override
    @SuppressWarnings("all")
    protected void initResource(Bundle savedInstanceState) {
        setSupportActionBar(R.id.gts_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        tvTitle = (TextView) findViewById(R.id.gts_tv_title);
        vpFragments = (ViewPager) findViewById(R.id.gts_vp_fragments);
        GradientTabStrip tabStrip = (GradientTabStrip) findViewById(R.id.gts_gts_tabs);
        adapter = new GradientTabStripAdapter(getSupportFragmentManager());
        vpFragments.setAdapter(adapter);
        tabStrip.setAdapter(adapter);
        vpFragments.addOnPageChangeListener(this);
        tabStrip.bindViewPager(vpFragments);
        tabStrip.setOnItemClickListener(this);
        setTitle(adapter.getPageTitle(vpFragments.getCurrentItem()));
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        tvTitle.setText(title);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTitle(adapter.getPageTitle(vpFragments.getCurrentItem()));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onSelectedClick(int position) {
        Toast.makeText(getApplicationContext(), "onSelectedClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDoubleClick(int position) {
        Toast.makeText(getApplicationContext(), "onDoubleClick", Toast.LENGTH_SHORT).show();
    }
}
