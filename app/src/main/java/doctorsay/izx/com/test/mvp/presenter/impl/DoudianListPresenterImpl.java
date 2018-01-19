package doctorsay.izx.com.test.mvp.presenter.impl;

import java.util.List;

import doctorsay.izx.com.test.mvp.OnDoudianListFinishedInterface;
import doctorsay.izx.com.test.mvp.model.DoudianModel;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.mvp.model.impl.DoudianModelImpl;
import doctorsay.izx.com.test.mvp.presenter.DoudianListPresenter;
import doctorsay.izx.com.test.mvp.view.DoudianListView;
import doctorsay.izx.com.test.utils.Api;

/**
 * Created by sujie on 2018/1/19.
 */

public class DoudianListPresenterImpl implements DoudianListPresenter, OnDoudianListFinishedInterface {

    private DoudianListView doudianListView;
    private DoudianModel doudianListModel;

    public DoudianListPresenterImpl(DoudianListView doudianListView) {
        this.doudianListView = doudianListView;
        doudianListModel = new DoudianModelImpl();
    }

    @Override
    public void loadFinsh(String type, int page) {
        if (page == 0) {
            doudianListView.showProgressBar();
        }
        doudianListModel.loadList(Api.getDouDianProjectList, type, page, this);
    }

    @Override
    public void onSuccess(List<StrictSelectionBean.PageStarResult> results) {
        if (doudianListView != null) {
            doudianListView.hideProgressBar();
            doudianListView.loadSuccess(results);
        }
    }

    @Override
    public void onFailure() {
        if (doudianListView != null) {
            doudianListView.hideProgressBar();
            doudianListView.loadFail();
        }
    }
}
