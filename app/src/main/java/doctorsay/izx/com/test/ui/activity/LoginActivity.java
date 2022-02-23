package doctorsay.izx.com.test.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.model.bean.LoginBean;
import doctorsay.izx.com.test.mvp.presenter.LoginPresenter;
import doctorsay.izx.com.test.mvp.presenter.impl.LoginPresenterImpl;
import doctorsay.izx.com.test.mvp.view.LoginView;
import doctorsay.izx.com.test.utils.MyARouterUtils;

/**
 * 登陆页面
 * Created by sujie on 2018/1/17.
 */
@Route(path = MyARouterUtils.LoginActivity)
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_getcode;
    private Button btn_go_list;
    private Button btn_go_main;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_getcode = findViewById(R.id.btn_getcode);
        btn_go_list = findViewById(R.id.btn_go_list);
        btn_go_main = findViewById(R.id.btn_go_main);
        progressBar = findViewById(R.id.progressBar);
        btn_login.setOnClickListener(this);
        btn_getcode.setOnClickListener(this);
        btn_go_list.setOnClickListener(this);
        btn_go_main.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
        getLifecycle().addObserver(loginPresenter);
        String username = getIntent().getStringExtra("username");
        String userpwd = getIntent().getStringExtra("userpwd");
        et_username.setText(username);
        et_password.setText(userpwd);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onGetCodeError() {
        Toast.makeText(LoginActivity.this, "验证码获取失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetCodeSuccess() {
        Toast.makeText(LoginActivity.this, "验证码获取成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLgoinError() {
        Toast.makeText(LoginActivity.this, "login error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLgoinSuccess(LoginBean loginBean) {
        Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
        toMainAct(loginBean.getUser_name());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 200);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                loginPresenter.validateCredentials(et_username.getText().toString(), et_password.getText().toString());
                break;
            case R.id.btn_getcode:
                loginPresenter.getCode(et_password.getText().toString());
                break;
            case R.id.btn_go_list:
                Intent intent = new Intent(LoginActivity.this, DoudianListAct.class);
                startActivity(intent);
                break;
            case R.id.btn_go_main:
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }

    private void toMainAct(String username) {
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.USERNAME, username);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
