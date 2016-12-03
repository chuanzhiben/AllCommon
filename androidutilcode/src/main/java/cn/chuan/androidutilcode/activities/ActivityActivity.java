package cn.chuan.androidutilcode.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.ActivityUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.androidutilcode.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/13
 *     desc  : Activity工具类Demo
 * </pre>
 */

public class ActivityActivity extends Activity{

    @Bind(R.id.btn_launch_image_activity)
    Button btnLaunchImageActivity;
    @Bind(R.id.tv_about_activity)
    TextView tvAboutActivity;
    private String packageName;
    private String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        ButterKnife.bind(this);
        packageName = this.getPackageName();
        className = packageName + ".activities.ImageActivity";
        tvAboutActivity.setText("判断是否存在Activity " + ActivityUtils.isActivityExists(this, packageName, className)
                + "\n获取入口activity: " + ActivityUtils.getLauncherActivity(this, packageName)
        );
    }

    @OnClick({R.id.btn_launch_image_activity, R.id.tv_about_activity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_launch_image_activity:
                ActivityUtils.launchActivity(this, packageName, className);
                break;
            case R.id.tv_about_activity:
                break;
        }
    }
}
