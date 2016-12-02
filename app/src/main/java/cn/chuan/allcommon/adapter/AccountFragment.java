package cn.chuan.allcommon.adapter;

import android.os.Bundle;

public class AccountFragment extends GradientTabStripFragment {

    public static AccountFragment newInstance(String content) {
        AccountFragment fragment = new AccountFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NAME, content);
        fragment.setArguments(bundle);
        return fragment;
    }
}