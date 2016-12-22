package cn.chuan.allcommon.activitys.androiduntils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.blankj.utilcode.utils.SDCardUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/27
 *     desc  : SDCard工具类Demo
 * </pre>
 */
public class SDCardActivity extends Activity {

    @Bind(R.id.tv_about_sdcard)
    TextView tvAboutSdcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        ButterKnife.bind(this);
        tvAboutSdcard.setText("isSDCardEnable: " + SDCardUtils.isSDCardEnable()
                + "\ngetDataPath: " + SDCardUtils.getDataPath()
                + "\ngetSDCardPath: " + SDCardUtils.getSDCardPath()
                + "\ngetFreeSpace: " + SDCardUtils.getFreeSpace()
                + "\ngetSDCardInfo: " + SDCardUtils.getSDCardInfo()
        );
    }
}
