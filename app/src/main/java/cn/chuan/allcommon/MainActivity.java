package cn.chuan.allcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.activity.ABackActivity;
import cn.chuan.allcommon.activity.AndroidUntilsActivity;
import cn.chuan.allcommon.activity.DeleteItemListActivity;
import cn.chuan.allcommon.activity.LoadAnimActivity;
import cn.chuan.allcommon.activity.NinePicActivity;
import cn.chuan.allcommon.activity.RecycleListActivity;
import cn.chuan.allcommon.activity.VewPagerListActivity;
import cn.chuan.allcommon.activitys.dialog.LemonActivity;
import cn.chuan.allcommon.adapter.MainAdapter;
import cn.chuan.allcommon.common.ConStants;

public class MainActivity extends AppCompatActivity {

    List<String> list;
    MainAdapter adapter;
    Activity context;
    @Bind(R.id.main_listview)
    ListView mainListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = MainActivity.this;
        ButterKnife.bind(this);
        list = new ArrayList<>();
        list.add("滑动删除控件集合");
        list.add("activity跳转返回效果");
        list.add("加载效果集合");
        list.add("滑动界面");
        list.add("Recycle样板模式");
        list.add("android基本工具类");
        list.add("九宫格图片展示样例");
        list.add("Dialog");
        adapter = new MainAdapter(context, list);
        mainListview.setAdapter(adapter);
        mainListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gotos(i);
            }
        });
    }

    private void gotos(int position) {
        Intent intent = new Intent(context, ConStants.ACTIVITY[position]);
        Bundle bundle = new Bundle();
        bundle.putString(ConStants.b1, list.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
