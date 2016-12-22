package cn.chuan.allcommon.adapter.srecycle;

import android.content.Context;

import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;

import java.util.List;

import cn.chuan.allcommon.R;

/**
 * Created by super南仔 on 07/28/16.
 * blog: http://supercwn.github.io/
 * GitHub: https://github.com/supercwn
 */
public class HeaderFooterAdapter extends SuperBaseAdapter<String> {

    public HeaderFooterAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item, int position) {
        holder.setText(R.id.tv_info,item);
    }

    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.adapter_header_footer_layout;
    }
}
