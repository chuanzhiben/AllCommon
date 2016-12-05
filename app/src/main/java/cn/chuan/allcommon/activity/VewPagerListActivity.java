package cn.chuan.allcommon.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.activitys.viewpager.GradientTabStripActivity;
import cn.chuan.allcommon.activitys.viewpager.VPagerFActivity;
import cn.chuan.allcommon.activitys.viewpager.VPagerfgActivity;
import cn.chuan.allcommon.adapter.MainAdapter;
import cn.chuan.allcommon.common.ConStants;

public class VewPagerListActivity extends Activity {
    List<String> list;
    MainAdapter adapter;
    Activity context;
    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        context = VewPagerListActivity.this;
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(ConStants.b1);
        list = new ArrayList<>();
        list.add("滑动viewpager,嵌套fragment");
        list.add("滑动viewpager,嵌套fragment,简约模式");
        list.add("滑动viewpager,嵌套fragment,GradientTabStripActivity底部滑动动态模式");
        adapter = new MainAdapter(context, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gotos(i);
            }
        });
        tvTile.setText(name);
    }

    private void gotos(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent(context, VPagerFActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ConStants.b1, list.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(context, VPagerfgActivity.class);
                bundle = new Bundle();
                bundle.putString(ConStants.b1, list.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(context, GradientTabStripActivity.class);
                bundle = new Bundle();
                bundle.putString(ConStants.b1, list.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.l_back)
    public void onClick() {
        finish();
    }
}
