package cn.chuan.allcommon.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.activitys.androiduntils.ActivityActivity;
import cn.chuan.allcommon.activitys.androiduntils.AppActivity;
import cn.chuan.allcommon.activitys.androiduntils.CleanActivity;
import cn.chuan.allcommon.activitys.androiduntils.DeviceActivity;
import cn.chuan.allcommon.activitys.androiduntils.HandlerActivity;
import cn.chuan.allcommon.activitys.androiduntils.ImageActivity;
import cn.chuan.allcommon.activitys.androiduntils.KeyboardActivity;
import cn.chuan.allcommon.activitys.androiduntils.LocationActivity;
import cn.chuan.allcommon.activitys.androiduntils.NetworkActivity;
import cn.chuan.allcommon.activitys.androiduntils.PhoneActivity;
import cn.chuan.allcommon.activitys.androiduntils.ProcessActivity;
import cn.chuan.allcommon.activitys.androiduntils.SDCardActivity;
import cn.chuan.allcommon.activitys.androiduntils.SnackbarActivity;
import cn.chuan.allcommon.activitys.androiduntils.ToastActivity;
import cn.chuan.allcommon.common.ConStants;


/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/29
 *     desc  : MainActivity
 * </pre>
 */
public class AndroidUntilsActivity extends Activity {
    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androiduntils);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(ConStants.b1);
        tvTile.setText(name);}

    public void activityClick(View view) {
        startActivity(new Intent(this, ActivityActivity.class));
    }

    public void appClick(View view) {
        startActivity(new Intent(this, AppActivity.class));
    }

    public void cleanClick(View view) {
        startActivity(new Intent(this, CleanActivity.class));
    }

    public void crashClick(View view) {
        int err = 1 / 0;
    }

    public void deviceClick(View view) {
        startActivity(new Intent(this, DeviceActivity.class));
    }

    public void handlerClick(View view) {
        startActivity(new Intent(this, HandlerActivity.class));
    }

    public void imageClick(View view) {
        startActivity(new Intent(this, ImageActivity.class));
    }

    public void keyboardClick(View view) {
        startActivity(new Intent(this, KeyboardActivity.class));
    }

    public void locationClick(View view) {
        startActivity(new Intent(this, LocationActivity.class));
    }

    public void networkClick(View view) {
        startActivity(new Intent(this, NetworkActivity.class));
    }

    public void phoneClick(View view) {
        startActivity(new Intent(this, PhoneActivity.class));
    }

    public void processClick(View view) {
        startActivity(new Intent(this, ProcessActivity.class));
    }

    public void sdcardClick(View view) {
        startActivity(new Intent(this, SDCardActivity.class));
    }

    public void snackbarClick(View view) {
        startActivity(new Intent(this, SnackbarActivity.class));
    }

    public void toastClick(View view) {
        startActivity(new Intent(this, ToastActivity.class));
    }

    @OnClick(R.id.l_back)
    public void onClick() {
        finish();
    }
}
