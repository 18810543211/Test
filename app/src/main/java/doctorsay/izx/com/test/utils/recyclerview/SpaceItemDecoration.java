package doctorsay.izx.com.test.utils.recyclerview;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * Created by haohaitao on 17/11/1.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;//编剧
    private int gridNum;//表格数量

    public SpaceItemDecoration(int space,int gridNum) {
        this.space = space;
        this.gridNum = gridNum;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //不是第一个的格子都设一个左边和底部的间距
        outRect.right = space;
        outRect.bottom = space;
    }
}