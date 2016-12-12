package cn.chuan.allcommon.activitys.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.common.ConStants;
import cn.chuan.allcommon.fragments.viewpagerf.Fragment1;
import cn.chuan.allcommon.fragments.viewpagerf.Fragment2;
import cn.chuan.allcommon.fragments.viewpagerf.Fragment3;
import cn.chuan.allcommon.fragments.viewpagerf.Fragment4;

public class VPagerfgActivity extends AppCompatActivity {
    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.vp)
    ViewPager vp;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpagerfg);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(ConStants.b1);
        tvTile.setText(name);
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        vp.setOffscreenPageLimit(0);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                vp.setCurrentItem(radioGroup.indexOfChild(radioGroup.findViewById(i)));
            }
        });
    }

    @OnClick({R.id.l_back, R.id.tv_tile, R.id.rg, R.id.vp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.l_back:
                finish();
                break;
            case R.id.tv_tile:
                break;
            case R.id.rg:
                break;
            case R.id.vp:
                break;
        }
    }
}
