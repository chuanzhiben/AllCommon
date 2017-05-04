package cn.chuan.allcommon.activitys.dialog;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import net.lemonsoft.lemonbubble.LemonBubble;
import net.lemonsoft.lemonbubble.LemonBubbleGlobal;
import net.lemonsoft.lemonbubble.enums.LemonBubbleLayoutStyle;
import net.lemonsoft.lemonbubble.enums.LemonBubbleLocationStyle;
import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloGlobal;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.adapter.LemonHelloEventDelegateAdapter;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.common.ConStants;

public class LemonActivity extends Activity {
    Activity context;
    @Bind(R.id.tv_tile)
    TextView tvTile;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemon);
        ButterKnife.bind(this);
        context = LemonActivity.this;
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(ConStants.b1);
        tvTile.setText(name);
        LemonHelloGlobal.statusBarColor = Color.parseColor("#3399FF");
        LemonBubbleGlobal.statusBarColor = Color.parseColor("#3399FF");
        LemonHelloGlobal.contentColor = Color.parseColor("#c6c4c3");
//        sButton = (Button) findViewById(R.id.sButton);
//        sButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LemonHello.getSuccessHello("要删除\"LemonKit\"吗?", "您选择删除后会同时删除应用内的所有数据，确认删除吗？")
//                        .setIconWidth(80)
//                        .addAction(new LemonHelloAction("取消", Color.argb(255, 0, 120, 215), new LemonHelloActionDelegate() {
//                            @Override
//                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
//                                helloView.hide();
//                            }
//                        }))
//                        .addAction(new LemonHelloAction("删除", Color.RED, new LemonHelloActionDelegate() {
//                            @Override
//                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
//                                helloView.hide();
//                            }
//                        }))
//                        .show(context);
//            }
//        });
    }

    @OnClick({R.id.l_back, R.id.l_success, R.id.l_error, R.id.l_warning, R.id.l_information, R.id.l_bookmark, R.id.l_multiMessages})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.l_back:
                finish();
                break;
            case R.id.l_success:
                LemonHello.getSuccessHello("提交成功", "恭喜您，您所填写的数据已经全部提交成功，我们的客服人员将在24小时内进行审核，请耐心等待.")
                        .setContentFontSize(14)
                        .addAction(new LemonHelloAction("我知道啦", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .setEventDelegate(new LemonHelloEventDelegateAdapter() {
                            @Override
                            public void onMaskTouch(LemonHelloView helloView, LemonHelloInfo helloInfo) {
                                super.onMaskTouch(helloView, helloInfo);
                                helloView.hide();
                            }
                        })
                        .show(context);
                break;
            case R.id.l_error:
                LemonHello.getErrorHello("发生错误", "对不起，您没有权限删除此数据，请联系系统管理员进行操作，谢谢。")
                        .addAction(new LemonHelloAction("关闭", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .show(context);
                break;
            case R.id.l_warning:
                LemonHello.getWarningHello("您确认删除这条数据吗？", "删除这条数据后会同时删除其关联的数据，并且无法撤销！")
                        .addAction(new LemonHelloAction("取消", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("确定删除", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();

                                // 提示框使用了LemonBubble，请您参考：https://github.com/1em0nsOft/LemonBubble4Android
                                LemonBubble.showRoundProgress(context, "正在删除中...");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        LemonBubble.showRight(context, "删除成功", 1000);
                                    }
                                }, 2000);
                            }
                        }))
                        .show(context);
                break;
            case R.id.l_information:
                LemonHello.getInformationHello("您确定要注销吗？", "注销登录后您将无法接收到当前用户的所有推送消息。")
                        .addAction(new LemonHelloAction("取消", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("我要注销", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                                // 提示框使用了LemonBubble，请您参考：https://github.com/1em0nsOft/LemonBubble4Android
                                LemonBubble.getRoundProgressBubbleInfo()
                                        .setLocationStyle(LemonBubbleLocationStyle.BOTTOM)
                                        .setLayoutStyle(LemonBubbleLayoutStyle.ICON_LEFT_TITLE_RIGHT)
                                        .setBubbleSize(200, 50)
                                        .setProportionOfDeviation(0.1f)
                                        .setTitle("正在请求服务器...")
                                        .show(context);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        LemonBubble.showRight(context, "注销成功，欢迎您下次登录", 2000);
                                    }
                                }, 1500);
                            }
                        }))
                        .show(context);
                break;
            case R.id.l_bookmark:
                LemonHelloInfo bookMarkInfo = new LemonHelloInfo()
                        .setTitle("添加书签")
                        .setContent("确认将《LemonKit》添加到您的书签当中吗？")
                        .setContentColor(Color.parseColor("#3399FF"))
                        .setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_bookmark))
                        .addAction(new LemonHelloAction("取消", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("我再想想", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("添加", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                                LemonBubble.showRight(context, "添加成功", 1500);
                            }
                        }));
                bookMarkInfo.show(context);
                break;
            case R.id.l_multiMessages:
                LemonHelloInfo info1 = new LemonHelloInfo()
                        .setTitle("LemonKit想要获取您的位置")
                        .setContent("LemonKit获取到您的位置之后将会动态记录您的地理信息。")
                        .addAction(new LemonHelloAction("允许", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("拒绝", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }));
                LemonHelloInfo info2 = new LemonHelloInfo()
                        .setTitle("LemonKit想要访问数据")
                        .setContent("LemonKit希望使用蜂窝网络或者WLAN进行远程数据获取。")
                        .addAction(new LemonHelloAction("允许", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("拒绝", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }));
                LemonHelloInfo info3 = new LemonHelloInfo()
                        .setTitle("LemonKit想要推送通知")
                        .setContent("LemonKit将要获取通知权限，在适当的时候会向您推送一些通知。")
                        .addAction(new LemonHelloAction("允许", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("拒绝", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }));
                info1.show(context);
                info2.show(context);
                info3.show(context);
                break;
        }
    }
}
