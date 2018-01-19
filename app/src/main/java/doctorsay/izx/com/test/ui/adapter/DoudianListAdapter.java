package doctorsay.izx.com.test.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.utils.ImageLoaderUtils;

/**
 * Created by sujie on 2018/1/19.
 */

public class DoudianListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StrictSelectionBean.PageStarResult> mData;
    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public DoudianListAdapter(Context context) {
        this.mContext = context;
    }

    public void setmDate(List<StrictSelectionBean.PageStarResult> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doudianlist, parent, false);
        ItemViewHolder vh = new ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            StrictSelectionBean.PageStarResult result = mData.get(position);
            if (result == null) {
                return;
            }
            if (!TextUtils.isEmpty(result.getProjectName())) {
                ((ItemViewHolder) holder).tv_item_doudianlist_title.setText(result.getProjectName());
            }
            if (!TextUtils.isEmpty(result.getPreviewImageUrl())) {
                ImageLoaderUtils.display(mContext, ((ItemViewHolder) holder).iv_item_doudianlist_image, result.getPreviewImageUrl());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData != null && mData.size() > 0 ? mData.size() : 0;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public StrictSelectionBean.PageStarResult getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tv_item_doudianlist_title;
        public ImageView iv_item_doudianlist_image;

        public ItemViewHolder(View v) {
            super(v);
            tv_item_doudianlist_title = v.findViewById(R.id.tv_item_doudianlist_title);
            iv_item_doudianlist_image = v.findViewById(R.id.iv_item_doudianlist_image);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }

}
