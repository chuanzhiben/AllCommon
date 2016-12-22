package cn.chuan.allcommon.activitys.androiduntils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.NetworkUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.until.manager.App;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/13
 *     desc  : Network工具类Demo
 * </pre>
 */
public class NetworkActivity extends Activity {

    @Bind(R.id.btn_open_wireless_settings)
    Button btnOpenWirelessSettings;
    @Bind(R.id.btn_set_data_enabled)
    Button btnSetDataEnabled;
    @Bind(R.id.btn_set_wifi_enabled)
    Button btnSetWifiEnabled;
    @Bind(R.id.tv_about_network)
    TextView tvAboutNetwork;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);

        tvAboutNetwork = (TextView) findViewById(R.id.tv_about_network);
        mContext = App.getInstance();
        setAboutNetwork();
    }

    private void setAboutNetwork() {
        tvAboutNetwork.setText("isConnected: " + NetworkUtils.isConnected(mContext)
                + "\nisAvailableByPing: " + NetworkUtils.isAvailableByPing(mContext)
                + "\ngetDataEnabled: " + NetworkUtils.getDataEnabled(mContext)
                + "\nis4G: " + NetworkUtils.is4G(mContext)
                + "\ngetWifiEnabled: " + NetworkUtils.getWifiEnabled(mContext)
                + "\nisWifiConnected: " + NetworkUtils.isWifiConnected(mContext)
                + "\nisWifiAvailable: " + NetworkUtils.isWifiAvailable(mContext)
                + "\ngetNetworkOperatorName: " + NetworkUtils.getNetworkOperatorName(mContext)
                + "\ngetNetworkTypeName: " + NetworkUtils.getNetworkType(mContext)
                + "\ngetIPAddress: " + NetworkUtils.getIPAddress(true)
                + "\ngetDomainAddress: " + NetworkUtils.getDomainAddress("baidu.com")
        );
    }

    @OnClick({R.id.btn_open_wireless_settings, R.id.btn_set_data_enabled, R.id.btn_set_wifi_enabled})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_open_wireless_settings:
                NetworkUtils.openWirelessSettings(this);
                break;
            case R.id.btn_set_data_enabled:
                NetworkUtils.setDataEnabled(this, !NetworkUtils.getDataEnabled(this));
                break;
            case R.id.btn_set_wifi_enabled:
                NetworkUtils.setWifiEnabled(this, !NetworkUtils.getWifiEnabled(this));
                break;
        }
        setAboutNetwork();
    }
}
