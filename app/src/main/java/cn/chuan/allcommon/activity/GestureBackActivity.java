package cn.chuan.allcommon.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.common.ConStants;

public class GestureBackActivity extends cn.chuan.allcommon.base.GestureBackActivity {
    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    @Bind(R.id.tv)
    TextView tv;
    String name;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestureback);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(ConStants.b1);
        tvTile.setText(name);
    }

    @OnClick(R.id.l_back)
    public void onClick() {
        finish();
    }
}
