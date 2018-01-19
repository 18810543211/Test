package doctorsay.izx.com.test.mvp.model.impl;

import android.text.TextUtils;

import doctorsay.izx.com.test.mvp.model.bean.LoginBean;
import doctorsay.izx.com.test.mvp.OnLoginFinishedInterface;
import doctorsay.izx.com.test.mvp.model.LoginModel;

/**
 * Created by sujie on 2018/1/17.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void onLogin(String username, String password, OnLoginFinishedInterface onLoginFinishedInterface) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            onLoginFinishedInterface.onError();
        } else {
            LoginBean loginBean = new LoginBean();
            loginBean.setUser_name(username);
            loginBean.setUser_password(password);
            onLoginFinishedInterface.onSuccess(loginBean);
        }
    }

    @Override
    public void onGetCode(String password, OnLoginFinishedInterface onLoginFinishedInterface) {
        if (TextUtils.isEmpty(password)) {
            onLoginFinishedInterface.onGetCodeError();
        } else {
            onLoginFinishedInterface.onGetCodeSuccess();
        }
    }
}
