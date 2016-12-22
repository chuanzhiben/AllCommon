package cn.chuan.allcommon.activitys.androiduntils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.ProcessUtils;

import java.util.Iterator;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/13
 *     desc  : Process工具类Demo
 * </pre>
 */
public class ProcessActivity extends Activity {

    @Bind(R.id.btn_kill_all_background_processes)
    Button btnKillAllBackgroundProcesses;
    @Bind(R.id.tv_about_process)
    TextView tvAboutProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        ButterKnife.bind(this);
        Set<String> set = ProcessUtils.getAllBackgroundProcesses(this);
        tvAboutProcess.setText("getForegroundProcessName: " + ProcessUtils.getForegroundProcessName(this)
                + "\n\ngetAllBackgroundProcesses: " + getSetItems(set)
                + "\nsize: " + set.size());
    }

    private String getSetItems(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("\n");
        }
        return sb.toString();
    }

    @OnClick(R.id.btn_kill_all_background_processes)
    public void onClick() {
        Set<String> set = ProcessUtils.getAllBackgroundProcesses(this);
        Set<String> set1 = ProcessUtils.killAllBackgroundProcesses(this);
        tvAboutProcess.setText("getForegroundProcessName: " + ProcessUtils.getForegroundProcessName(this)
                + "\n\ngetAllBackgroundProcesses: " + getSetItems(set)
                + "\nsize: " + set.size()
                + "\n\nkillAllBackgroundProcesses: " + getSetItems(set1)
                + "\nsize: " + set1.size());
    }
}
