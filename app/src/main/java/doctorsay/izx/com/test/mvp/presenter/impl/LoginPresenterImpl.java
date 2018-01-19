package doctorsay.izx.com.test.mvp.presenter.impl;

import doctorsay.izx.com.test.mvp.model.bean.LoginBean;
import doctorsay.izx.com.test.mvp.OnLoginFinishedInterface;
import doctorsay.izx.com.test.mvp.model.LoginModel;
import doctorsay.izx.com.test.mvp.model.impl.LoginModelImpl;
import doctorsay.izx.com.test.mvp.presenter.LoginPresenter;
import doctorsay.izx.com.test.mvp.view.LoginView;

/**
 * Created by sujie on 2018/1/17.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedInterface {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        loginModel.onLogin(username, password, this);
    }

    @Override
    public void getCode(String password) {
        loginModel.onGetCode(password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onError() {
        if (loginView != null) {
            loginView.hideProgressBar();
            loginView.onLgoinError();
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginView != null) {
            loginView.showProgressBar();
            loginView.onLgoinSuccess(loginBean);
        }
    }

    @Override
    public void onGetCodeError() {
        if (loginView != null) {
            loginView.onGetCodeError();
        }
    }

    @Override
    public void onGetCodeSuccess() {
        if (loginView != null) {
            loginView.onGetCodeSuccess();
        }
    }
}
