package cn.chuan.androidutilcode.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.HandlerUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.androidutilcode.R;

/**
 * <pre>
 *     author: Blankj
 *     blog : http://blankj.com
 *     time : 2016/9/27
 *     desc : Handler工具类Demo
 * </pre>
 */
public class HandlerActivity extends Activity implements HandlerUtils.OnReceiveMessageListener {

    @Bind(R.id.btn_send_msg_after_3s)
    Button btnSendMsgAfter3s;
    @Bind(R.id.tv_about_handler0)
    TextView tvAboutHandler0;
    @Bind(R.id.tv_about_handler1)
    TextView tvAboutHandler1;
    private HandlerUtils.HandlerHolder handlerHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
        handlerHolder = new HandlerUtils.HandlerHolder(this);
    }

    @Override
    public void handlerMessage(Message msg) {
        tvAboutHandler1.setText("get_msg_after_3s");
    }

    @OnClick(R.id.btn_send_msg_after_3s)
    public void onClick() {
        handlerHolder.sendEmptyMessageDelayed(0, 3000);
    }
}
