package doctorsay.izx.com.test.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.view.MyScollview;

/**
 * Created by sujie on 2018/5/22.
 */

public class ScrollviewTestActivity extends AppCompatActivity implements MyScollview.ScrollViewListener, View.OnClickListener {

    private static final String TAG = "ScrollviewTestActivity";

    private MyScollview msvTest;

    private LinearLayout llTest1;
    private LinearLayout llTest2;
    private LinearLayout llTest3;

    private RelativeLayout rlTest;

    private RadioButton rbTestBaby;
    private RadioButton rbTestDetail;
    private RadioButton rbTestRecommend;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scollview);
        initView();
        initClick();
    }

    private void initView() {
        msvTest = findViewById(R.id.msvTest);

        llTest1 = findViewById(R.id.llTest1);
        llTest2 = findViewById(R.id.llTest2);
        llTest3 = findViewById(R.id.llTest3);

        rlTest = findViewById(R.id.rlTest);

        rbTestBaby = findViewById(R.id.rbTestBaby);
        rbTestDetail = findViewById(R.id.rbTestDetail);
        rbTestRecommend = findViewById(R.id.rbTestRecommend);
    }

    private void initClick() {
        msvTest.setScrollViewListener(this);
        rbTestBaby.setOnClickListener(this);
        rbTestDetail.setOnClickListener(this);
        rbTestRecommend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbTestBaby:
                msvTest.smoothScrollTo(0, 0);
                break;
            case R.id.rbTestDetail:
                msvTest.smoothScrollTo(0, getLayout1Height());
                break;
            case R.id.rbTestRecommend:
                msvTest.smoothScrollTo(0, getLayout2Height());
                break;
        }
    }

    private int getLayout1Height() {
        return llTest1.getMeasuredHeight() - rlTest.getMeasuredHeight();
    }

    private int getLayout2Height() {
        return llTest2.getMeasuredHeight() - rlTest.getMeasuredHeight();
    }

    private void setArgb(int alpha) {
        rlTest.setBackgroundColor(Color.argb(alpha, 255, 255, 255));
//        rbTestBaby.setTextColor(Color.argb(alpha, 128, 0, 128));
//        rbTestDetail.setTextColor(Color.argb(alpha, 0, 0, 0));
//        rbTestRecommend.setTextColor(Color.argb(alpha, 0, 0, 0));
    }

    @Override
    public void onScrollChanged(ScrollView scrollView, int scrollX, int scrollY, int oldx, int oldy) {

//        int alpha = 0;
//        float scale;
//        int toolBarHeight = rlTest.getMeasuredHeight();
//        if (scrollY <= toolBarHeight) {
//            scale = (float) scrollY / toolBarHeight;
//            alpha = (int) (255 * scale);
//            // 随着滑动距离改变透明度
//            setArgb(alpha);
//
//        } else {
//
//            if (alpha < 255) {
//                // 防止频繁重复设置相同的值影响性能
//                alpha = 255;
//                setArgb(alpha);
//            }
//        }
        if (Math.abs(scrollY) == 0) {
            rlTest.setVisibility(View.GONE);
        } else {
            rlTest.setVisibility(View.VISIBLE);
        }

        if (Math.abs(scrollY) >= 0 && scrollY < getLayout1Height()) {
            rbTestBaby.setChecked(true);
        } else if (Math.abs(scrollY) >= getLayout1Height() && Math.abs(scrollY) < getLayout2Height()) {
            rbTestDetail.setChecked(true);
        } else {
            rbTestRecommend.setChecked(true);
        }

//        Log.i(TAG, "onScrollChanged: Test1-->scrollY-->" + Math.abs(scrollY));
//        Log.i(TAG, "onScrollChanged: Test1-->rlTest-->" + rlTest.getMeasuredHeight());
//        Log.i(TAG, "onScrollChanged: Test1-->" + llTest1.getMeasuredHeight());
//        Log.i(TAG, "onScrollChanged: Test2-->" + llTest2.getMeasuredHeight());
    }
}
