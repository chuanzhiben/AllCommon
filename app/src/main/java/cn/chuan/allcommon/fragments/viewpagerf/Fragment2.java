package cn.chuan.allcommon.fragments.viewpagerf;

import android.util.Log;

import cn.chuan.allcommon.R;
import cn.chuan.allcommon.base.LazyLoadFragment;

/**
 * Created by yuandl on 2016-11-17.
 */

public class Fragment2 extends LazyLoadFragment {
    @Override
    public int setContentView() {
        return R.layout.fm_layout2;
    }

    @Override
    protected void lazyLoad() {
        String message = "Fragment2" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }
    @Override
    protected void stopLoad() {
        Log.d(TAG, "Fragment2" + "已经对用户不可见，可以停止加载数据");
    }
}
