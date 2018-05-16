package doctorsay.izx.com.test.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zcolin.gui.zrecyclerview.BaseRecyclerAdapter;
import com.zcolin.gui.zrecyclerview.ZRecyclerView;

import java.util.ArrayList;
import java.util.List;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.mvp.presenter.DoudianListPresenter;
import doctorsay.izx.com.test.mvp.presenter.impl.DoudianListPresenterImpl;
import doctorsay.izx.com.test.mvp.view.DoudianListView;
import doctorsay.izx.com.test.ui.adapter.ZRecyclerAdapter;

/**
 * Created by sujie on 2018/4/13.
 */

public class NewListActivity extends AppCompatActivity implements DoudianListView, ZRecyclerView.PullLoadMoreListener {

    private static final String TAG = "NewListActivity";

    private ZRecyclerView recyclerView;
    private ZRecyclerAdapter recyclerAdapter;
    private DoudianListPresenter doudianListPresenter;
    private View headerView2;
    // 第1页
    private int mPage = 0;

    private String type = "tandian";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);
        initView();
    }


    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);

        doudianListPresenter = new DoudianListPresenterImpl(this);

        //recyclerView.setGridLayout(true, 2);  //默认为LinearLayoutManager
        recyclerView.setOnPullLoadMoreListener(this);

        //设置数据为空时的EmptyView，DataObserver是注册在adapter之上的，也就是setAdapter是注册上，notifyDataSetChanged的时候才会生效
//        recyclerView.setEmptyView(this, R.layout.view_recycler_empty);

        //设置HeaderView和footerView
//        recyclerView.addHeaderView(this, R.layout.view_recyclerheader);
//        headerView2 = LayoutInflater.from(this).inflate(R.layout.view_recyclerheader, null);
//        ((TextView) headerView2.findViewById(R.id.textView)).setText("HEDER 2");
//        recyclerView.addHeaderView(headerView2);
//        recyclerView.addFooterView(this, R.layout.view_recyclerfooter);

        //recyclerView.setLoadMoreProgressView(view);
//        recyclerView.setIsShowNoMore(true);      //不显示已加载全部
        // recyclerView.setIsLoadMoreEnabled(false);//到底加载是否可用
        // recyclerView.setIsRefreshEnabled(false);//下拉刷新是否可用
        //recyclerView.setIsProceeConflict(true);   //处理与子控件的冲突，如viewpager
        //recyclerView.setLoadMoreFooter(customview implements ILoadMoreFooter);   //设置自定义的加载Footer
        recyclerView.setLoadMoreText("正在加载...", "正在加载...", "已加载全部");//设置加载文字
        //recyclerView.addDefaultItemDecoration();//增加默认分割线


//        recyclerView.refreshWithPull();
        // recyclerView.refresh();//没有下拉刷新效果，直接刷新数据
        // recyclerView.setRefreshing(true);只有下拉刷新效果，不刷新数据
//         recyclerView.setLoadMoreTextColor(R.color.colorAccent);
//         recyclerView.setLoadMoreTextSize(15);
        onRefresh();
    }

    /**
     * 设置数据Adapter
     */
    public void notifyData(List<StrictSelectionBean.PageStarResult> list) {
        if (recyclerAdapter == null) {
            recyclerAdapter = new ZRecyclerAdapter();
            recyclerView.setAdapter(recyclerAdapter);
        } else {
            recyclerAdapter.notifyDataSetChanged();
        }
        if (mPage == 0) {
            recyclerAdapter.setDatas(list);
        } else {
            recyclerAdapter.addDatas(list);
//                if (recyclerAdapter.getDatas().size() >= recyclerAdapter.getItemCount()) {
//                    recyclerView.setNoMore(true);
//                }
        }
        Log.i(TAG, "notifyData--->Adapter: " + recyclerAdapter.getItemCount());
        Log.i(TAG, "notifyData--->ItemCount: " + recyclerView.getLayoutManager().getItemCount());
        Log.i(TAG, "notifyData--->List: " + recyclerAdapter.getDatas().size());
    }

    /**
     * 加载数据
     *
     * @param page
     */
    private void requestData(int page) {
        new Handler().postDelayed(() -> {
            if (doudianListPresenter != null) {
                doudianListPresenter.loadFinsh(type, page);
            }
            recyclerView.setPullLoadMoreCompleted();
        }, 1000);
    }

    @Override
    public void onRefresh() {
        mPage = 0;
        requestData(mPage);
        recyclerView.setNoMore(false);
    }

    @Override
    public void onLoadMore() {
        mPage = mPage + 1;
        requestData(mPage);
    }

    @Override
    public void showProgressBar() {
        recyclerView.setRefreshing(true);
    }

    @Override
    public void hideProgressBar() {
        recyclerView.setRefreshing(false);
    }

    @Override
    public void loadSuccess(List<StrictSelectionBean.PageStarResult> results) {
        notifyData(results);
    }

    @Override
    public void loadFail() {

    }
}
