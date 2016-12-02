package cn.chuan.allcommon.adapter;

import android.os.Bundle;

public class DiscoveryFragment extends GradientTabStripFragment {

    public static DiscoveryFragment newInstance(String content) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NAME, content);
        fragment.setArguments(bundle);
        return fragment;
    }
}