package cn.chuan.allcommon.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mingle.widget.LoadingView;
import com.mingle.widget.ShapeLoadingDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.common.ConStants;

public class Loading58Activity extends cn.chuan.allcommon.base.SwipeBackActivity {
    ShapeLoadingDialog shapeLoadingDialog;
    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    @Bind(R.id.loadView)
    LoadingView loadView;
    @Bind(R.id.btn_show)
    Button btnShow;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading58);
        ButterKnife.bind(this);
        shapeLoadingDialog = new ShapeLoadingDialog(this);
        shapeLoadingDialog.setLoadingText("加载中...");
        Bundle b = getIntent().getExtras();
        name = b.getString(ConStants.b1);
        tvTile.setText(name);
    }

    @OnClick({R.id.l_back, R.id.btn_show})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.l_back:
                finish();
                break;
            case R.id.btn_show:
                shapeLoadingDialog.show();
                break;
        }
    }

}
