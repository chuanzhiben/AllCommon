package cn.chuan.androidutilcode.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.AppUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.androidutilcode.App;
import cn.chuan.androidutilcode.R;

/**
 * <pre>
 *     author: Blankj
 *     blog : http://blankj.com
 *     time : 2016/10/13
 *     desc : App工具类Demo
 * </pre>
 */

public class AppActivity extends Activity
        implements View.OnClickListener {

    @Bind(R.id.btn_install_app)
    Button btnInstallApp;
    @Bind(R.id.btn_install_app_silent)
    Button btnInstallAppSilent;
    @Bind(R.id.btn_uninstall_app)
    Button btnUninstallApp;
    @Bind(R.id.btn_uninstall_app_silent)
    Button btnUninstallAppSilent;
    @Bind(R.id.btn_launch_app)
    Button btnLaunchApp;
    @Bind(R.id.btn_get_app_details_settings)
    Button btnGetAppDetailsSettings;
    @Bind(R.id.tv_about_app)
    TextView tvAboutApp;
    private String appPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        ButterKnife.bind(this);
        appPath = AppUtils.getAppPath(this);
        tvAboutApp.setText(AppUtils.getAppInfo(this).toString()
                + "\nisInstallWeiXin: " + AppUtils.isInstallApp(this, "com.tencent.mm")
                + "\nisAppRoot: " + AppUtils.isAppRoot()
                + "\nisAppDebug: " + AppUtils.isAppDebug(this)
                + "\nisWeiXinAppDebug: " + AppUtils.isAppDebug(this, "com.tencent.mm")
                + "\nAppSignatureSHA1: " + AppUtils.getAppSignatureSHA1(this)
                + "\nisAppForeground: " + AppUtils.isAppForeground(this)
                + "\nisWeiXinForeground: " + AppUtils.isAppForeground(this, "com.tencent.mm")
        );
    }

    @OnClick({R.id.btn_install_app, R.id.btn_install_app_silent, R.id.btn_uninstall_app, R.id.btn_uninstall_app_silent, R.id.btn_launch_app, R.id.btn_get_app_details_settings})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_install_app:
                AppUtils.installApp(this, appPath);
                break;
            case R.id.btn_install_app_silent:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppUtils.installAppSilent(App.getInstance(), appPath);
                    }
                }).start();  break;
            case R.id.btn_uninstall_app:
                AppUtils.uninstallApp(this, this.getPackageName());
                break;
            case R.id.btn_uninstall_app_silent:
                AppUtils.uninstallAppSilent(this, this.getPackageName(), false);
                break;
            case R.id.btn_launch_app:
                AppUtils.launchApp(this, this.getPackageName());
                break;
            case R.id.btn_get_app_details_settings:
                AppUtils.getAppDetailsSettings(this);
                break;
        }
    }
}
