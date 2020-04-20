package doctorsay.izx.com.test.ui.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import doctorsay.izx.com.test.App;
import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.mvp.presenter.DoudianListPresenter;
import doctorsay.izx.com.test.mvp.presenter.impl.DoudianListPresenterImpl;
import doctorsay.izx.com.test.mvp.view.DoudianListView;
import doctorsay.izx.com.test.ui.adapter.DoudianListAdapter;
import doctorsay.izx.com.test.utils.recyclerview.XRecylcerView;

/**
 * Created by sujie on 2018/5/1.
 */

public class TabFragment extends Fragment implements DoudianListView,XRecylcerView.LoadingListener {
    private View parentView;

    private XRecylcerView rvTestList;
    private DoudianListAdapter doudianListAdapter;
    private List<StrictSelectionBean.PageStarResult> mData;
    private DoudianListPresenter doudianListPresenter;

    private int pageIndex = 0;
    private String type = "tandian";


    public static TabFragment newInstance() {
        return new TabFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        parentView = inflater.inflate(R.layout.fragment_tab, container, false);
        return parentView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
    }

    private void initview() {
        rvTestList = parentView.findViewById(R.id.rvTestList);
        doudianListPresenter = new DoudianListPresenterImpl(this);
        rvTestList.setHasFixedSize(true);
        rvTestList.setLayoutManager(new LinearLayoutManager(App.getAppContext()));
        rvTestList.setLoadingListener(this);

        doudianListAdapter = new DoudianListAdapter(getActivity());
        
        rvTestList.setAdapter(doudianListAdapter);
    }

    @Override
    public void showProgressBar() {
        
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void loadSuccess(List<StrictSelectionBean.PageStarResult> results) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        if (pageIndex == 0) {
            mData.clear();
        }
        mData.addAll(results);
        doudianListAdapter.setmDate(mData);
    }

    @Override
    public void loadFail() {

    }

    public void onRefresh(String type) {
        pageIndex = 0;
        // 判断当前是否处于上拉加载状态
        if (!rvTestList.isLoadData()) {
            // 设置当前刷新数，当下拉刷新的时候置为0，上拉加载时已经初始化
            rvTestList.setPreviousTotal(0);
            // 设置是否还有更多
            rvTestList.setIsnomore(false);

            doudianListPresenter.loadFinsh(type, pageIndex);
        }
    }

    @Override
    public void onLoadMore() {
        pageIndex++;
        doudianListPresenter.loadFinsh(type, pageIndex);
        rvTestList.loadMoreComplete();
    }
}
