package cn.chuan.androidutilcode.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.androidutilcode.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/29
 *     desc  : Toast工具类Demo
 * </pre>
 */
public class ToastActivity extends Activity
        implements View.OnClickListener {

    @Bind(R.id.btn_is_jump_when_more)
    Button btnIsJumpWhenMore;
    @Bind(R.id.btn_show_short_toast_safe)
    Button btnShowShortToastSafe;
    @Bind(R.id.btn_show_long_toast_safe)
    Button btnShowLongToastSafe;
    @Bind(R.id.btn_show_short_toast)
    Button btnShowShortToast;
    @Bind(R.id.btn_show_long_toast)
    Button btnShowLongToast;
    @Bind(R.id.btn_cancel_toast)
    Button btnCancelToast;
    @Bind(R.id.tv_about_toast)
    TextView tvAboutToast;
    private Context mContext;
    private boolean isJumpWhenMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        ButterKnife.bind(this);
        mContext = this;
        isJumpWhenMore = false;

        tvAboutToast.setText(String.format("Is Jump When More: %b", isJumpWhenMore));
    }

    @OnClick({R.id.btn_is_jump_when_more, R.id.btn_show_short_toast_safe, R.id.btn_show_long_toast_safe, R.id.btn_show_short_toast, R.id.btn_show_long_toast, R.id.btn_cancel_toast})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_is_jump_when_more:
                ToastUtils.init(isJumpWhenMore = !isJumpWhenMore);
                break;
            case R.id.btn_show_short_toast_safe:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showShortToastSafe(mContext, "show_short_toast_safe");
                    }
                }).start();
                break;
            case R.id.btn_show_long_toast_safe:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showLongToastSafe(mContext, "show_long_toast_safe");
                    }
                }).start();
                break;
            case R.id.btn_show_short_toast:
                ToastUtils.showShortToast(mContext, "show_short_toast");
                break;
            case R.id.btn_show_long_toast:
                ToastUtils.showShortToast(mContext, "show_long_toast");
                break;
            case R.id.btn_cancel_toast:
                ToastUtils.cancelToast();
                break;
        }
        tvAboutToast.setText(String.format("Is Jump When More: %b", isJumpWhenMore));
    }
}
