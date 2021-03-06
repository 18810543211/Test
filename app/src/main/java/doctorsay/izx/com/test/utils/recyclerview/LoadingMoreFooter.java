package doctorsay.izx.com.test.utils.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import doctorsay.izx.com.test.R;


public class LoadingMoreFooter extends LinearLayout {

    private ProgressBar progressCon;
    private Context mContext;
    public final static int STATE_LAODING = 0;
    public final static int STATE_COMPLETE = 1;
    public final static int STATE_NOMORE = 2;
    private TextView mText;

    public LoadingMoreFooter(Context context) {
        super(context);
        initView(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public LoadingMoreFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void initView(Context context) {
        mContext = context;
        setGravity(Gravity.CENTER);
        setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        progressCon = new ProgressBar(context);
        progressCon.setLayoutParams(new ViewGroup.LayoutParams(
                (int) getResources().getDimension(R.dimen.dimen_25dp),
                (int) getResources().getDimension(R.dimen.dimen_25dp))
        );

        addView(progressCon);
        mText = new TextView(context);
        mText.setText("正在加载...");
        mText.setTextColor(context.getResources().getColor(R.color.black));
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins((int) getResources().getDimension(R.dimen.dimen_10dp), 0, 0, 0);
        mText.setLayoutParams(layoutParams);
        addView(mText);
    }

    public void setState(int state) {
        switch (state) {
            // 刷新中
            case STATE_LAODING:
                progressCon.setVisibility(View.VISIBLE);
                mText.setText("正在加载...");
                this.setVisibility(View.VISIBLE);
                break;
            // 刷新完成
            case STATE_COMPLETE:
                mText.setText("正在加载...");
                this.setVisibility(View.VISIBLE);
                break;
            // 没有更多数据
            case STATE_NOMORE:
                mText.setText("没有更多数据了");
                progressCon.setVisibility(View.GONE);
                this.setVisibility(View.VISIBLE);
                break;
        }

    }
}
