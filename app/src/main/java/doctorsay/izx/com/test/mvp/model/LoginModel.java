package doctorsay.izx.com.test.mvp.model;

import doctorsay.izx.com.test.mvp.OnLoginFinishedInterface;

/**
 * Created by sujie on 2018/1/17.
 */

public interface LoginModel {
    //登陆
    void onLogin(String username, String password, OnLoginFinishedInterface onLoginFinishedInterface);
    //获取验证码
    void onGetCode(String password, OnLoginFinishedInterface onLoginFinishedInterface);
}
