package doctorsay.izx.com.test.utils;

import android.content.Context;
import android.graphics.Rect;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * Created by sujie on 2018/4/18.
 */

public class MySwiperefreshlayout extends SwipeRefreshLayout {

    private static final String TAG = "MySwiperefreshlayout ";

    //比如手指移动了100px, 那么View就只移动50px
    //目的是达到一个延迟的效果
    private static final float MOVE_MODE = 0.5f;

    //弹回去的时间
    private static final int ANIM_TIME = 300;

    //MySwiperefreshlayout的子View,这个表示RecycleView
    private View view;

    //MySwiperefreshlayout的子View,这个表示CircleImageView（就是那个圈圈）
    private View child;

    //手指按下时的Y值, 用于在移动时计算移动距离
    private float startY;

    //用于记录正常的布局位置
    private Rect rect = new Rect();

    //在手指滑动的过程中记录是否移动了布局
    private boolean isMoved = false;

    //是否已经移动到顶部，手指按下时，判断是否能够下拉
    private boolean isTop = false;

    //延迟时间
    public static int time;

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        MySwiperefreshlayout.time = time;
    }

    public MySwiperefreshlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            child = getChildAt(0);
            view = getChildAt(getChildCount() - 1);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (view == null) return;
        //RecycleView的初始信息，这个位置保留之后，保持不变
        rect.set(view.getLeft(), view.getTop(), view
                .getRight(), view.getBottom());
    }

    /**
     * 滑动监听，处理下拉事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (view == null) {
            return super.dispatchTouchEvent(ev);
        }
        int action = ev.getAction();
        switch (action) {

            case MotionEvent.ACTION_DOWN:
                canDropDown();
                //记录按下时的Y值
                startY = ev.getY();
                break;

            case MotionEvent.ACTION_UP:
                if (!isMoved) break;  //没有移动布局，不执行
                //移动的距离
                int distance = (int) ((int) (ev.getY() - startY) * MOVE_MODE);
                //如果移动的距离大于CircleImageView.getTop，那么缩小移动距离，达到加载中的效果
                if (distance > child.getTop()) {
                    distance = child.getTop() + 30;
                }
                //Recycle移动到CircleImageView下拉的距离，表示加载中
                view.layout(rect.left, rect.top + distance,
                        rect.right, rect.bottom + distance);
                // 开启动画
                TranslateAnimation anim = new TranslateAnimation(0, 0, view.getTop(),
                        rect.top);
                anim.setDuration(ANIM_TIME);
                if (time > 0) {
                    //设置延迟时间
                    //移动的最大距离 小于这个距离不刷新
                    if (distance > 92) {
                        anim.setStartOffset(time);
                    }
                }
                view.startAnimation(anim);
                // 设置回到正常的布局位置
                view.layout(rect.left, rect.top,
                        rect.right, rect.bottom);
                //重置
                isTop = false;
                isMoved = false;
                startY = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                //是否允许移动
                if (!canDropDown()) {
                    break;
                }
                //计算手指移动的距离
                int distanceMove = (int) (ev.getY() - startY);
                //允许移动并且是上拉的情况次下，移动布局
                if (isTop && distanceMove > 0) {
                    int offset = (int) (distanceMove * MOVE_MODE);
                    //随着手指的移动而移动布局
                    view.layout(rect.left, rect.top + offset,
                            rect.right, rect.bottom + offset);
                    isMoved = true;  //记录移动了布局
                }
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }


    /**
     * 判断是否滚动到顶部
     */
    private boolean canDropDown() {
        if (child.getVisibility() == View.VISIBLE)
            isTop = true;
        else
            isTop = false;
        return isTop;
    }

}
