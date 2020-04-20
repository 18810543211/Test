package doctorsay.izx.com.test.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

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
