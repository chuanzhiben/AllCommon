package cn.dayu.slmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.esri.android.runtime.ArcGISRuntime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.dayu.slmap.bean.Person;
import cn.dayu.slmap.common.ConStant;

public class MainActivity extends Activity {
    Activity context;
    @Bind(R.id.btn_map)
    Button btnMap;
    @Bind(R.id.tv_msg)
    TextView tvMsg;
    String msg;
    List<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = MainActivity.this;
        ArcGISRuntime.setClientId("A0f303ix7WCRwq7i");
        Person p1 = new Person("2014-01-06", 2);
        Person p2 = new Person("2014-02-02", 25);
        Person p3 = new Person("2014-01-09", 23);
        Person p4 = new Person("2014-02-04", 26);
        Person p5 = new Person("2014-01-06", 16);
        Person p6 = new Person("2014-02-01", 8);
        Person p7 = new Person("2014-05-07", 29);
        Person p8 = new Person("2014-01-06", 15);
        Person p9 = new Person("2014-04-04", 13);

        list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        Log.e(ConStant.tag, "-----------初始化的数组-----------");
        msg="";
        for (Person item : list) {
            msg += "name = " + item.name + ", age = " + item.age + "\n";
        }
        Log.e(ConStant.tag, msg);
    }

    void gotoMap() {
        Intent intent = new Intent(context, MapActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_map)
    public void onClick() {
//        gotoMap();
        sortByComparable();
    }

    private void sortByComparable() {
        //排序
        Collections.sort(list);
        //输出
        Log.e(ConStant.tag, "-----------使用Comparable实现的排序-----------");
        msg="";
        for (Person item : list) {
            msg += "name = " + item.name + ", age = " + item.age + "\n";
        }
        Log.e(ConStant.tag, msg);
    }
}
