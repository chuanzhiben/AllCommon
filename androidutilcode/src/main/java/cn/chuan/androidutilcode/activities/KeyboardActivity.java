package cn.chuan.androidutilcode.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.utils.KeyboardUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.androidutilcode.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/27
 *     desc  : Keyboard工具类Demo
 * </pre>
 */
public class KeyboardActivity extends Activity {

    @Bind(R.id.et)
    EditText et;
    @Bind(R.id.btn_hide_soft_input)
    Button btnHideSoftInput;
    @Bind(R.id.btn_show_soft_input)
    Button btnShowSoftInput;
    @Bind(R.id.btn_toggle_soft_input)
    Button btnToggleSoftInput;
    @Bind(R.id.tv_about_keyboard)
    TextView tvAboutKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        ButterKnife.bind(this);
        tvAboutKeyboard.setText("");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    @OnClick({R.id.btn_hide_soft_input, R.id.btn_show_soft_input, R.id.btn_toggle_soft_input})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hide_soft_input:
                KeyboardUtils.hideSoftInput(this);
                break;
            case R.id.btn_show_soft_input:
                KeyboardUtils.showSoftInput(this, (EditText) findViewById(R.id.et));
                break;
            case R.id.btn_toggle_soft_input:
                KeyboardUtils.toggleSoftInput(this);
                break;
        }
    }
}
