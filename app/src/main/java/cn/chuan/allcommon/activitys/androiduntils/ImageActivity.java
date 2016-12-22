package cn.chuan.allcommon.activitys.androiduntils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.utils.ImageUtils;
import com.blankj.utilcode.utils.SizeUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/26
 *     desc  : Image工具类Demo
 * </pre>
 */
public class ImageActivity extends Activity {

    @Bind(R.id.iv_src)
    ImageView ivSrc;
    @Bind(R.id.iv_view2Bitmap)
    ImageView ivView2Bitmap;
    @Bind(R.id.iv_round)
    ImageView ivRound;
    @Bind(R.id.iv_round_corner)
    ImageView ivRoundCorner;
    @Bind(R.id.iv_fast_blur)
    ImageView ivFastBlur;
    @Bind(R.id.iv_render_script_blur)
    ImageView ivRenderScriptBlur;
    @Bind(R.id.iv_stack_blur)
    ImageView ivStackBlur;
    @Bind(R.id.iv_add_frame)
    ImageView ivAddFrame;
    @Bind(R.id.iv_add_reflection)
    ImageView ivAddReflection;
    @Bind(R.id.iv_add_text_watermark)
    ImageView ivAddTextWatermark;
    @Bind(R.id.iv_add_image_watermark)
    ImageView ivAddImageWatermark;
    @Bind(R.id.iv_gray)
    ImageView ivGray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        Bitmap src = ImageUtils.getBitmap(getResources(), R.drawable.ic_launcher);
        Bitmap watermark = ImageUtils.getBitmap(getResources(), R.drawable.ic_launcher);
        SizeUtils.forceGetViewSize(ivSrc, new SizeUtils.onGetSizeListener() {
            @Override
            public void onGetSize(View view) {
                ivView2Bitmap.setImageBitmap(ImageUtils.view2Bitmap(ivSrc));
            }
        });
        ivRound.setImageBitmap(ImageUtils.toRound(src));
        ivRoundCorner.setImageBitmap(ImageUtils.toRoundCorner(src, 60));
        ivFastBlur.setImageBitmap(ImageUtils.fastBlur(this, src, 0.1f, 5));
        ivRenderScriptBlur.setImageBitmap(ImageUtils.renderScriptBlur(this, src, 10));
        src = ImageUtils.getBitmap(getResources(),R.drawable.ic_launcher);
        ivStackBlur.setImageBitmap(ImageUtils.stackBlur(src, 10, false));
        ivAddFrame.setImageBitmap(ImageUtils.addFrame(src, 16, Color.GREEN));
        ivAddReflection.setImageBitmap(ImageUtils.addReflection(src, 80));
        ivAddTextWatermark.setImageBitmap(ImageUtils.addTextWatermark(src, "blankj", 40, 0x8800ff00, 0, 0));
        ivAddImageWatermark.setImageBitmap(ImageUtils.addImageWatermark(src, watermark, 0, 0, 0x88));
        ivGray.setImageBitmap(ImageUtils.toGray(src));
    }
}