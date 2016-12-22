package cn.chuan.allcommon.activitys.recycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.activitys.superrecycle.AnimationActivity;
import cn.chuan.allcommon.activitys.superrecycle.DragActivity;
import cn.chuan.allcommon.activitys.superrecycle.GradualChangeActivity;
import cn.chuan.allcommon.activitys.superrecycle.HeaderAndFooterActivity;
import cn.chuan.allcommon.activitys.superrecycle.ItemClickActivity;
import cn.chuan.allcommon.activitys.superrecycle.MultiItemActivity;
import cn.chuan.allcommon.activitys.superrecycle.RefreshAndLoadMoreActivity;
import cn.chuan.allcommon.activitys.superrecycle.SwipeMenuActivity;
import cn.chuan.allcommon.adapter.srecycle.MainAdapter;
import cn.chuan.allcommon.common.ConStants;

/**
 * Created by super南仔 on 07/28/16.
 * blog: http://supercwn.github.io/
 * GitHub: https://github.com/supercwn
 */
public class SuperRecycleActivity extends AppCompatActivity implements SuperBaseAdapter.OnItemClickListener {

    private static final String[] titles = {"AnimationActivity", "HeaderViewAndFooterView", "RefreshAndLoadMoreActivity", "Gradual change", "MultiItemActivity", "ItemClickActivity", "SwipeMenuActivity", "DragActivity"};
    private static final Class<?>[] ACTIVITY = {AnimationActivity.class, HeaderAndFooterActivity.class, RefreshAndLoadMoreActivity.class, GradualChangeActivity.class, MultiItemActivity.class, ItemClickActivity.class, SwipeMenuActivity.class, DragActivity.class};
    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    @Bind(R.id.super_recycle_view)
    SuperRecyclerView superRecyclerView;
    private List<String> dataList = new ArrayList<>();
    private MainAdapter mAdapter;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supercycle);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(ConStants.b1);
        tvTile.setText(name);
        initView();
        initDatas();
        initAdapter();
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setRefreshEnabled(false);
        superRecyclerView.setLoadMoreEnabled(false);
    }

    private void initAdapter() {
        mAdapter = new MainAdapter(this, dataList);
        mAdapter.setOnItemClickListener(this);
        superRecyclerView.setAdapter(mAdapter);
    }

    private void initDatas() {
        for (int i = 0; i < titles.length; i++) {
            dataList.add(titles[i]);
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        Intent intent = new Intent(this, ACTIVITY[position]);
        startActivity(intent);
    }

    @OnClick(R.id.l_back)
    public void onClick() {
        finish();
    }
}
