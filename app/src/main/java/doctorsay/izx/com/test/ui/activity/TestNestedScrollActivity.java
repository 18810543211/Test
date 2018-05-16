package doctorsay.izx.com.test.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.presenter.impl.DoudianListPresenterImpl;
import doctorsay.izx.com.test.ui.adapter.TabAdapter;
import doctorsay.izx.com.test.ui.adapter.Test1Adapter;
import doctorsay.izx.com.test.ui.fragment.TabFragment;
import doctorsay.izx.com.test.view.StickyNavLayout;

/**
 * Created by sujie on 2018/5/1.
 */

public class TestNestedScrollActivity extends AppCompatActivity {

    private StickyNavLayout snlTest;
    private RecyclerView rvTopList;
    private Test1Adapter test1Adapter;
    private List<String> stringList = new ArrayList<>();
    private TabLayout tlTest;
    private ViewPager vpTest;
    private Button btnTop;

    private List<String> tabs = new ArrayList<>();

    private String type = "tandian";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_nest_scroll);
        initView();
        initTabData();
    }

    private void initView() {
        snlTest = findViewById(R.id.snlTest);
        rvTopList = findViewById(R.id.rvTopList);
        tlTest = findViewById(R.id.tlTest);
        vpTest = findViewById(R.id.vpTest);
        btnTop = findViewById(R.id.btnTop);
        btnTop.setOnClickListener(v -> snlTest.fling(0));


        initTestData();
    }

    private void initTestData() {
        for (int i = 0; i < 7; i++) {
            stringList.add("测试标签" + i);
        }
        test1Adapter = new Test1Adapter();
        test1Adapter.setmDate(stringList);
        rvTopList.setLayoutManager(new LinearLayoutManager(this));
        rvTopList.setAdapter(test1Adapter);
    }

    private void initTabData() {
        tabs.add("探店");
        tabs.add("严选");

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabs.size(); i++) {
            if (tlTest != null) {
                tlTest.addTab(tlTest.newTab().setText(tabs.get(i)));
            }
            fragments.add(TabFragment.newInstance());
        }

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), fragments, tabs);
        if (vpTest.getAdapter() == null) {
            //给ViewPager设置适配器
            vpTest.setAdapter(tabAdapter);
            //将TabLayout和ViewPager关联起来。
            tlTest.setupWithViewPager(vpTest);
            //给TabLayout设置适配器
            tlTest.setTabsFromPagerAdapter(tabAdapter);
            tlTest.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    type = tab.getText().toString();
                    if ("探店".equals(type)) {
                        type = "tandian";
                    } else {
                        type = "yanxuan";
                    }
                    hotFragment(type);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
        hotFragment(type);
    }

    /**
     * 热销商品页面传值
     *
     * @param type 分类
     */
    private void hotFragment(String type) {
        Fragment fragment = getFragmentByIndex(0);
        if (fragment != null && fragment instanceof TabFragment) {
            TabFragment mEarnsHotGoodsChildFragment = (TabFragment) fragment;
            mEarnsHotGoodsChildFragment.onRefresh(type);
        }
    }

    /**
     * 查找fragment
     *
     * @param index 下标
     * @return
     */
    public Fragment getFragmentByIndex(int index) {
        return getSupportFragmentManager().findFragmentByTag(
                "android:switcher:" + R.id.vpTest + ":" + index);
    }
}
