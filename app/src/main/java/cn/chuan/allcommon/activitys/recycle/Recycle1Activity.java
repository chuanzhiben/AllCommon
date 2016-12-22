package cn.chuan.allcommon.activitys.recycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;

public class Recycle1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_linearLayout, R.id.btn_linearLayoutHor, R.id.btn_gridLayout, R.id.btn_gridLayoutHor, R.id.btn_staggeredGridLayout, R.id.btn_staggeredGridLayoutHor, R.id.btn_imitateListViewDemo, R.id.btn_imitateGridViewDemo, R.id.btn_imitateStaggeredGridViewDemo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_linearLayout:
                startActivity(new Intent(Recycle1Activity.this, LinearLayoutActivity.class));
                break;
            case R.id.btn_linearLayoutHor:
                Intent intent = new Intent(Recycle1Activity.this, LinearLayoutActivity.class);
                intent.putExtra("isVertical", false);
                startActivity(intent);
                break;
            case R.id.btn_gridLayout:
                startActivity(new Intent(Recycle1Activity.this, GridLayoutActivity.class));
                break;
            case R.id.btn_gridLayoutHor:
                intent = new Intent(Recycle1Activity.this, GridLayoutActivity.class);
                intent.putExtra("isVertical", false);
                startActivity(intent);
                break;
            case R.id.btn_staggeredGridLayout:
                startActivity(new Intent(Recycle1Activity.this, StaggeredGridActivity.class));
                break;
            case R.id.btn_staggeredGridLayoutHor:
                intent = new Intent(Recycle1Activity.this, StaggeredGridActivity.class);
                intent.putExtra("isVertical", false);
                startActivity(intent);
                break;
            case R.id.btn_imitateListViewDemo:
                startActivity(new Intent(Recycle1Activity.this, ImitateListViewDemoActivity.class));
                break;
            case R.id.btn_imitateGridViewDemo:
                startActivity(new Intent(Recycle1Activity.this, ImitateGridViewDemoActivity.class));
                break;
            case R.id.btn_imitateStaggeredGridViewDemo:
                startActivity(new Intent(Recycle1Activity.this, ImitateStaggeredGridViewDemoActivity.class));
                break;
        }
    }
}
