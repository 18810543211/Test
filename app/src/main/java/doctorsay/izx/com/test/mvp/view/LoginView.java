package doctorsay.izx.com.test.mvp.view;

import doctorsay.izx.com.test.mvp.model.bean.LoginBean;

/**
 * Created by sujie on 2018/1/17.
 */

public interface LoginView {
    void showProgressBar();

    void hideProgressBar();

    void onGetCodeError();

    void onGetCodeSuccess();

    void onLgoinError();

    void onLgoinSuccess(LoginBean loginBean);
}
