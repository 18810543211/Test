package doctorsay.izx.com.test.mvp;

import doctorsay.izx.com.test.mvp.model.bean.LoginBean;

/**
 * Created by sujie on 2018/1/17.
 */

public interface OnLoginFinishedInterface {

    void onError();

    void onSuccess(LoginBean loginBean);

    void onGetCodeError();

    void onGetCodeSuccess();
}
