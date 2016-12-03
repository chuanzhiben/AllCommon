package cn.chuan.androidutilcode.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.PhoneUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.androidutilcode.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/13
 *     desc  : Phone工具类Demo
 * </pre>
 */
public class PhoneActivity extends Activity implements
        View.OnClickListener {

    @Bind(R.id.btn_dial)
    Button btnDial;
    @Bind(R.id.btn_call)
    Button btnCall;
    @Bind(R.id.btn_send_sms)
    Button btnSendSms;
    @Bind(R.id.btn_send_sms_silent)
    Button btnSendSmsSilent;
    @Bind(R.id.tv_about_phone)
    TextView tvAboutPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        ButterKnife.bind(this);
        tvAboutPhone.setText("isPhone: " + PhoneUtils.isPhone(this)
                + "\ngetIMEI: " + PhoneUtils.getIMEI(this)
                + "\ngetIMSI: " + PhoneUtils.getIMSI(this)
                + "\ngetPhoneType: " + PhoneUtils.getPhoneType(this)
                + "\nisSimCardReady: " + PhoneUtils.isSimCardReady(this)
                + "\ngetSimOperatorName: " + PhoneUtils.getSimOperatorName(this)
                + "\ngetSimOperatorByMnc: " + PhoneUtils.getSimOperatorByMnc(this)
                + "\n获取手机状态信息: " + PhoneUtils.getPhoneStatus(this)
        );
    }

    @OnClick({R.id.btn_dial, R.id.btn_call, R.id.btn_send_sms, R.id.btn_send_sms_silent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dial:
                PhoneUtils.dial(this, "10000");
                break;
            case R.id.btn_call:
                PhoneUtils.call(this, "10000");
                break;
            case R.id.btn_send_sms:
                PhoneUtils.sendSms(this, "10000", "test");
                break;
            case R.id.btn_send_sms_silent:
                PhoneUtils.sendSmsSilent(this, "10000", "test");
                break;

        }
    }
}
