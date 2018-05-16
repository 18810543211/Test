package doctorsay.izx.com.test.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import doctorsay.izx.com.test.App;
import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.mvp.presenter.DoudianListPresenter;
import doctorsay.izx.com.test.mvp.presenter.impl.DoudianListPresenterImpl;
import doctorsay.izx.com.test.mvp.view.DoudianListView;
import doctorsay.izx.com.test.ui.adapter.DoudianListAdapter;
import doctorsay.izx.com.test.utils.ConstantsUtils;
import doctorsay.izx.com.test.utils.LogUtils;
import doctorsay.izx.com.test.utils.MySwiperefreshlayout;
import doctorsay.izx.com.test.utils.PullRefreshLayout;
import doctorsay.izx.com.test.utils.recyclerview.XRecylcerView;

/**
 * Created by sujie on 2018/1/19.
 */

public class DoudianListAct extends AppCompatActivity implements DoudianListView, PullRefreshLayout.OnRefreshListener,/*SwipeRefreshLayout.OnRefreshListener,*/ XRecylcerView.LoadingListener {

    private static final String TAG = "DoudianListAct";

    private DoudianListPresenter doudianListPresenter;
    private PullRefreshLayout swipeRefreshLayout;
    private XRecylcerView xRecylcerView;
    private DoudianListAdapter doudianListAdapter;
    private List<StrictSelectionBean.PageStarResult> mData;
    private int pageIndex = 0;
    private String type = "tandian";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doudian_list);
        doudianListPresenter = new DoudianListPresenterImpl(this);
        initView();
    }

    private void initView() {
        swipeRefreshLayout = findViewById(R.id.mSwipeRefreshLayout);
//        swipeRefreshLayout.setColorSchemeResources(R.color.black);
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
//            @Override
//            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
//                // 刷新
//                onRefresh2();
//            }
//        });
        swipeRefreshLayout.setOnRefreshListener(this);
        xRecylcerView = findViewById(R.id.mXRecylcerView);
        xRecylcerView.setHasFixedSize(true);
        xRecylcerView.setLayoutManager(new LinearLayoutManager(App.getAppContext()));
        xRecylcerView.setLoadingListener(this);

        doudianListAdapter = new DoudianListAdapter(getApplicationContext());
        doudianListAdapter.setOnItemClickListener(new DoudianListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                StrictSelectionBean.PageStarResult result = doudianListAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString(DoudianDetailAct.PROJECTID, result.getId());
                Intent intent = new Intent(DoudianListAct.this, DoudianDetailAct.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        xRecylcerView.setAdapter(doudianListAdapter);
        onRefresh();
    }

    void onRefresh2() {
        pageIndex = 0;
        doudianListPresenter.loadFinsh(type, pageIndex);

    }

    @Override
    public void showProgressBar() {
        swipeRefreshLayout.setLoading(false);
//        swipeRefreshLayout.setRefreshing(true);
//        if (swipeRefreshLayout != null) {
//            // 自动刷新...
//            swipeRefreshLayout.autoRefresh();
//        }
    }

    @Override
    public void hideProgressBar() {
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setLoading(false);
//        if (swipeRefreshLayout != null) {
//            // 结束下拉刷新...
//            swipeRefreshLayout.finishRefresh();
//        }
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
        if (pageIndex == 0) {
            doudianListAdapter.notifyDataSetChanged();
        }
    }

//    @Override
//    public void onRefresh() {
//        LogUtils.i(TAG, "刷新咯。。。。");
//        pageIndex = 0;
//        doudianListPresenter.loadFinsh(type, pageIndex);
//    }

    @Override
    public void onLoadMore() {
        LogUtils.i(TAG, "加载咯。。。。");
        pageIndex++;
        doudianListPresenter.loadFinsh(type, pageIndex);
        xRecylcerView.loadMoreComplete();
    }

    @Override
    public void onRefresh() {
        LogUtils.i(TAG, "刷新咯。。。。");
        pageIndex = 0;
        // 判断当前是否处于上拉加载状态
        if (!xRecylcerView.isLoadData()) {
            // 设置当前刷新数，当下拉刷新的时候置为0，上拉加载时已经初始化
            xRecylcerView.setPreviousTotal(0);
            // 设置是否还有更多
            xRecylcerView.setIsnomore(false);

            doudianListPresenter.loadFinsh(type, pageIndex);
        }
    }
}
