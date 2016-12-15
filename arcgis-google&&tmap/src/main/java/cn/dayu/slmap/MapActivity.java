package cn.dayu.slmap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.dayu.slmap.map.base.ArcgisMapFragment;

/**
 * Created by chuan on 16/12/13.
 */

public class MapActivity extends FragmentActivity {
    ArcgisMapFragment amf;
    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        setFragment();
    }

    private void setFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        amf = new ArcgisMapFragment();
        ft.replace(R.id.main_fragment, amf)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @OnClick(R.id.l_back)
    public void onClick() {
        finish();
    }
}