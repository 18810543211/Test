package doctorsay.izx.com.test.ui.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import doctorsay.izx.com.test.App;
import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.utils.MyARouterUtils;

public class MainActivity extends AppCompatActivity {

    private TextView tv_main_text;
    private TextView tvText;
    private Button toLogin;
    private Button aliWebview;
    private Button startNestedScroll;
    private Button startScollview;
    private Button startWaterfallDemo;
    private Bundle bundle;

    public static String USERNAME = "username";
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_main_text = findViewById(R.id.tv_main_text);
        tvText = findViewById(R.id.tvText);
        toLogin = findViewById(R.id.toLogin);
        aliWebview = findViewById(R.id.aliWebview);
        startNestedScroll = findViewById(R.id.startNestedScroll);
        startScollview = findViewById(R.id.startScollview);
        startWaterfallDemo = findViewById(R.id.startWaterfallDemo);
        toLogin.setOnClickListener(view -> {
//            Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(intent1);
            ARouter.getInstance().build(MyARouterUtils.LoginActivity).withString("username", "sujie").withString("userpwd", "123").navigation();
        });
        aliWebview.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, AliWebviewActivity.class);
            startActivity(intent1);
        });
        startNestedScroll.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, TestNestedScrollActivity.class);
            startActivity(intent1);
        });
        startScollview.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, ScrollviewTestActivity.class);
            startActivity(intent1);
        });
        startWaterfallDemo.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this, WaterfallDemoActivity.class);
            startActivity(intent1);
        });
        bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString(USERNAME);
        }
        tv_main_text.setText("欢迎" + username);


        Spannable string = new SpannableString("¥2234.98");
//        string.length()
        string.setSpan(new AbsoluteSizeSpan(60), 1, string.length() - 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tvText.setText(string);
    }

    public void onClick(View view) {
        Toast.makeText(this, App.uid, Toast.LENGTH_SHORT).show();
    }

//    //activity销毁之前保存配置信息，防止静态变量数据丢失
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        //这里保存Parcelable(序列化)后的config对象
//        outState.putString("config", App.uid);
//    }
//
//    //activity恢复的时候恢复保存的数据
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        ////这里恢复config对象
//        App.uid = savedInstanceState.getString("config");
//    }
}
