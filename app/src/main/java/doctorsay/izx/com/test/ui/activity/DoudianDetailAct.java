package doctorsay.izx.com.test.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.presenter.DoudianDetailPresenter;
import doctorsay.izx.com.test.mvp.presenter.impl.DoudianDetailPresenterImpl;
import doctorsay.izx.com.test.mvp.view.DoudianDetailView;

/**
 * 斗店详情
 * Created by sujie on 2018/1/19.
 */
public class DoudianDetailAct extends AppCompatActivity implements DoudianDetailView {

    private TextView tv_detail_content;
    private DoudianDetailPresenter doudianDetailPresenter;

    public static String PROJECTID = "projectid";
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doudian_detail);
        doudianDetailPresenter = new DoudianDetailPresenterImpl(this);
        initView();
    }

    private void initView() {
        bundle = getIntent().getExtras();
        tv_detail_content = findViewById(R.id.tv_detail_content);
        doudianDetailPresenter.loadFinsh(bundle.getString(PROJECTID));

        // okhttp请求原理
        // 通过okhttpclient 创建 call对象，并发起同步或者异步请求
        // 然后okhttp通过dispacher对所有的realcall进行统一管理，通过execute（）和enqueue（）对同步或者异步请求进行处理
        // execute（）和enqueue（）两大方法最终通过realcall.getResponseWithInterceptorChain()方法，通过拦截器中获取结果返回给调用方


        test();
    }

    private void test() {
        try {
//            Integer;
//            String;
//            HashMap hashMap = new HashMap();
//            hashMap.put();
//            hashMap.hashCode()
//            Handler handler = new Handler();
//            handler.post();
//            tv_detail_content.post()
//            handler.sendEmptyMessage().postDelayed();
//            startActivity();

            Glide.with(this).load("").into(new ImageView(this));

        } catch (Exception ignored) {

        } finally {

        }
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void loadSuccess(String results) {
        tv_detail_content.setText(results);
    }

    @Override
    public void loadFail() {

    }
}
