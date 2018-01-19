package doctorsay.izx.com.test.mvp.presenter.impl;

import doctorsay.izx.com.test.mvp.OnDoudianListDetailFinishedInterface;
import doctorsay.izx.com.test.mvp.model.DoudianModel;
import doctorsay.izx.com.test.mvp.model.impl.DoudianModelImpl;
import doctorsay.izx.com.test.mvp.presenter.DoudianDetailPresenter;
import doctorsay.izx.com.test.mvp.view.DoudianDetailView;
import doctorsay.izx.com.test.utils.Api;

/**
 * Created by sujie on 2018/1/19.
 */

public class DoudianDetailPresenterImpl implements DoudianDetailPresenter, OnDoudianListDetailFinishedInterface {

    private DoudianDetailView doudianDetailView;
    private DoudianModel doudianModel;

    public DoudianDetailPresenterImpl(DoudianDetailView doudianDetailView) {
        this.doudianDetailView = doudianDetailView;
        doudianModel = new DoudianModelImpl();
    }

    @Override
    public void loadFinsh(String projectId) {
        if (doudianDetailView != null) {
            doudianDetailView.showProgressBar();
        }
        doudianModel.loadListDetail(Api.getDouDianProjectInfo, projectId, this);
    }

    @Override
    public void onSuccess(String results) {
        if (doudianDetailView != null) {
            doudianDetailView.hideProgressBar();
            doudianDetailView.loadSuccess(results);
        }
    }

    @Override
    public void onFailure() {
        if (doudianDetailView != null) {
            doudianDetailView.hideProgressBar();
            doudianDetailView.loadFail();
        }
    }
}
