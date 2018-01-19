package doctorsay.izx.com.test.mvp.view;

import java.util.List;

import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;

/**
 * Created by sujie on 2018/1/19.
 */

public interface DoudianDetailView {
    void showProgressBar();

    void hideProgressBar();

    void loadSuccess(String results);

    void loadFail();
}
