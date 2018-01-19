package doctorsay.izx.com.test.mvp.view;

import java.util.List;

import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;

/**
 * 斗店列表
 * Created by sujie on 2018/1/19.
 */

public interface DoudianListView {

    void showProgressBar();

    void hideProgressBar();

    void loadSuccess(List<StrictSelectionBean.PageStarResult> results);

    void loadFail();
}
