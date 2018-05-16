package doctorsay.izx.com.test.ui.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.zcolin.gui.zrecyclerview.BaseRecyclerAdapter;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.utils.ImageLoaderUtils;

/**
 * Created by sujie on 2018/4/13.
 */

public class ZRecyclerAdapter extends BaseRecyclerAdapter<StrictSelectionBean.PageStarResult> {

    public ZRecyclerAdapter() {
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_doudianlist;
    }

    @Override
    public void setUpData(CommonHolder holder, int position, int viewType, StrictSelectionBean.PageStarResult data) {
        TextView textView = getView(holder, R.id.tv_item_doudianlist_title);
        ImageView imageView = getView(holder, R.id.iv_item_doudianlist_image);

        if (!TextUtils.isEmpty(data.getProjectName())) {
            textView.setText(data.getProjectName());
        }
        if (!TextUtils.isEmpty(data.getPreviewImageUrl())) {
            ImageLoaderUtils.display(imageView.getContext(), imageView, data.getPreviewImageUrl());
        }
    }
}
