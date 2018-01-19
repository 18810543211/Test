package doctorsay.izx.com.test.mvp.presenter;

/**
 * Created by sujie on 2018/1/17.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void getCode(String password);

    void onDestroy();
}
