package cn.chuan.allcommon.activitys.androiduntils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.DeviceUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.until.manager.App;

/**
 * <pre>
 *     author: Blankj
 *     blog : http://blankj.com
 *     time : 2016/9/27
 *     desc : Device工具类Demo
 * </pre>
 */
public class DeviceActivity extends Activity {

    @Bind(R.id.btn_shutdown)
    Button btnShutdown;
    @Bind(R.id.btn_reboot)
    Button btnReboot;
    @Bind(R.id.btn_reboot_to_recovery)
    Button btnRebootToRecovery;
    @Bind(R.id.btn_reboot_to_bootloader)
    Button btnRebootToBootloader;
    @Bind(R.id.tv_about_device)
    TextView tvAboutDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        ButterKnife.bind(this);
        tvAboutDevice.setText("isRoot: " + DeviceUtils.isDeviceRoot()
                + "\ngetSDKVersion: " + DeviceUtils.getSDKVersion()
                + "\ngetAndroidID: " + DeviceUtils.getAndroidID(App.getInstance())
                + "\ngetMacAddress: " + DeviceUtils.getMacAddress(App.getInstance())
                + "\ngetManufacturer: " + DeviceUtils.getManufacturer()
                + "\ngetModel: " + DeviceUtils.getModel()
        );
    }

    @OnClick({R.id.btn_shutdown, R.id.btn_reboot, R.id.btn_reboot_to_recovery, R.id.btn_reboot_to_bootloader})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_shutdown:
                DeviceUtils.shutdown();
                break;
            case R.id.btn_reboot:
                DeviceUtils.reboot();
            case R.id.btn_reboot_to_recovery:
                DeviceUtils.reboot2Recovery();
            case R.id.btn_reboot_to_bootloader:
                DeviceUtils.reboot2Bootloader();
                break;
        }
    }
}