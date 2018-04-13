package doctorsay.izx.com.test.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import doctorsay.izx.com.test.App;
import doctorsay.izx.com.test.R;

public class MainActivity extends AppCompatActivity {

    private TextView tv_main_text;
    private Button toLogin;
    private Button aliWebview;
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
        toLogin = findViewById(R.id.toLogin);
        aliWebview = findViewById(R.id.aliWebview);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
            }
        });
        aliWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, AliWebviewActivity.class);
                startActivity(intent1);
            }
        });
        bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString(USERNAME);
        }
        tv_main_text.setText("欢迎" + username);

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
