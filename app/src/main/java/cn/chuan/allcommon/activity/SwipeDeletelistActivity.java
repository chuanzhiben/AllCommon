package cn.chuan.allcommon.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.adapter.NewsAdapter;
import cn.chuan.allcommon.bean.RecentChat;
import cn.chuan.allcommon.common.ConStants;
import cn.chuan.allcommon.until.view.swipedelete.SwipeMenu;
import cn.chuan.allcommon.until.view.swipedelete.SwipeMenuCreator;
import cn.chuan.allcommon.until.view.swipedelete.SwipeMenuItem;
import cn.chuan.allcommon.until.view.swipedelete.SwipeMenuListView;

public class SwipeDeletelistActivity extends Activity {

    @Bind(R.id.l_back)
    LinearLayout lBack;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    @Bind(R.id.title_btn_left)
    Button titleBtnLeft;
    @Bind(R.id.title_txt)
    TextView titleTxt;
    @Bind(R.id.title_btn_right)
    Button titleBtnRight;
    @Bind(R.id.constact_group)
    Button constactGroup;
    @Bind(R.id.constact_all)
    Button constactAll;
    @Bind(R.id.common_constact)
    LinearLayout commonConstact;
    @Bind(R.id.title_bar)
    RelativeLayout titleBar;
    @Bind(R.id.ll_constact_serach)
    LinearLayout llConstactSerach;
    @Bind(R.id.listView)
    SwipeMenuListView listView;
    NewsAdapter adapter;
    LinkedList<RecentChat> chats = new LinkedList<RecentChat>();
    Activity context;
    String tile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipdeletelist);
        ButterKnife.bind(this);
        context = SwipeDeletelistActivity.this;
        Bundle bundle = getIntent().getExtras();
        tile = bundle.getString(ConStants.b1);
        initView();
        tvTile.setText(tile);
        lBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        chats.add(new RecentChat("章泽天", "点击进入手势返回的界面", "16:30", ""));
        chats.add(new RecentChat("宋茜", "点击进入SwipeBackLayout返回的界面", "17:30", ""));
        chats.add(new RecentChat("韩孝珠", "好好学习天天向上", "昨天", ""));
        chats.add(new RecentChat("景甜", "好好学习天天向上", "星期一", ""));
        chats.add(new RecentChat("刘亦菲", "好好学习天天向上", "17:30", ""));
        chats.add(new RecentChat("邓紫棋", "好好学习天天向上", "星期一", ""));
        chats.add(new RecentChat("finddreams",
                "http://blog.csdn.net/finddreams", "星期一", ""));

        initSwipeMenu();
    }

    /**
     * 初始化滑动菜单
     */
    private void initSwipeMenu() {
        listView = (SwipeMenuListView) findViewById(R.id.listView);
        adapter = new NewsAdapter(this, chats, listView);
        listView.setAdapter(adapter);
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "up" item
                SwipeMenuItem upItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                upItem.setBackground(new ColorDrawable(Color.rgb(0xE5, 0xE8,
                        0xE9)));
                // set item width
                upItem.setWidth(dp2px(90));
                upItem.setIcon(R.drawable.up);
                menu.addMenuItem(upItem);
                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu,
                                           int index) {
                switch (index) {
                    case 0:
                        break;
                    case 1:
                        chats.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
