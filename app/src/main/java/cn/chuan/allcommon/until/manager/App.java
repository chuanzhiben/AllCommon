package cn.chuan.allcommon.until.manager;

import android.app.Application;
import android.widget.ImageView;

import com.blankj.utilcode.utils.CrashUtils;
import com.blankj.utilcode.utils.LogUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lzy.okhttputils.OkHttpUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.leakcanary.LeakCanary;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import cn.chuan.allcommon.R;


public class App extends Application {
    private static App ourInstance;

    public static DisplayImageOptions imageLoaderOptions = new DisplayImageOptions.Builder()//
            .showImageOnLoading(R.drawable.ic_default_color)    //设置图片在下载期间显示的图片
            .showImageForEmptyUri(R.drawable.ic_default_color)  //设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.ic_default_color)       //设置图片加载/解码过程中错误时候显示的图片
            .cacheInMemory(true)                                //设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                                  //设置下载的图片是否缓存在SD卡中
            .build();                                           //构建完成

    public static ImageOptions xUtilsOptions = new ImageOptions.Builder()//
            .setIgnoreGif(false)                                //是否忽略GIF格式的图片
            .setImageScaleType(ImageView.ScaleType.FIT_CENTER)  //缩放模式
            .setLoadingDrawableId(R.drawable.ic_default_color)  //下载中显示的图片
            .setFailureDrawableId(R.drawable.ic_default_color)  //下载失败显示的图片
            .build();                                           //得到ImageOptions对象

    public static App getInstance() {
        return ourInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        // 内存泄露检查工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        ourInstance = this;
        CrashUtils.getInstance().init(this);
        LogUtils.getBuilder(this).setTag("MyTag").setLog2FileSwitch(true).create();
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(this);

        OkHttpUtils.init(this);                     //OkHttpUtils初始化
        ImageLoader.getInstance().init(config);     //UniversalImageLoader初始化
        Fresco.initialize(this);                    //Fresco初始化
        x.Ext.init(this);}
}
