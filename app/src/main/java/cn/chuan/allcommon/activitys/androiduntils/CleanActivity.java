package cn.chuan.allcommon.activitys.androiduntils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.utils.CleanUtils;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/29
 *     desc  : Clean工具类Demo
 * </pre>
 */
public class CleanActivity extends Activity
        implements View.OnClickListener {

    @Bind(R.id.btn_clean_internal_cache)
    Button btnCleanInternalCache;
    @Bind(R.id.btn_clean_internal_files)
    Button btnCleanInternalFiles;
    @Bind(R.id.btn_clean_internal_databases)
    Button btnCleanInternalDatabases;
    @Bind(R.id.btn_clean_internal_sp)
    Button btnCleanInternalSp;
    @Bind(R.id.btn_clean_external_cache)
    Button btnCleanExternalCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
        ButterKnife.bind(this);
        btnCleanInternalCache.setText(getCacheDir().getPath());
        btnCleanInternalFiles.setText(getFilesDir().getPath());
        btnCleanInternalDatabases.setText(getFilesDir().getParent() + File.separator + "databases");
        btnCleanInternalSp.setText(getFilesDir().getParent() + File.separator + "shared_prefs");
        btnCleanExternalCache.setText(getExternalCacheDir().getPath());
    }


    @OnClick({R.id.btn_clean_internal_cache, R.id.btn_clean_internal_files, R.id.btn_clean_internal_databases, R.id.btn_clean_internal_sp, R.id.btn_clean_external_cache})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_internal_cache:
                Log.d("cleanInternalCache", "" + CleanUtils.cleanInternalCache(this));
                break;
            case R.id.btn_clean_internal_files:
                Log.d("cleanInternalFiles", "" + CleanUtils.cleanInternalFiles(this));
                break;
            case R.id.btn_clean_internal_databases:
                Log.d("cleanInternalDbs", "" + CleanUtils.cleanInternalDbs(this));
                break;
            case R.id.btn_clean_internal_sp:
                Log.d("cleanInternalSP", "" + CleanUtils.cleanInternalSP(this));
                break;
            case R.id.btn_clean_external_cache:
                Log.d("cleanExternalCache", "" + CleanUtils.cleanExternalCache(this));
                break;
        }
    }
}
