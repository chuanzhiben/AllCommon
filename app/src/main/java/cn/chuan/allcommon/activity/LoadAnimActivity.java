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
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.adapter.MainAdapter;
import cn.chuan.allcommon.common.ConStants;

public class LoadAnimActivity extends Activity {
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
        context = LoadAnimActivity.this;
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(ConStants.b1);
        list = new ArrayList<>();
        list.add("仿58同城的加载动画,GestureBackActivity");
        adapter = new MainAdapter(context, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gotos(i);
            }
        });
        lBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvTile.setText(name);
    }

    private void gotos(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent(context, Loading58Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ConStants.b1, list.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(context, SwipeBackActivity.class);
                bundle = new Bundle();
                bundle.putString(ConStants.b1, list.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
