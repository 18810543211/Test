package doctorsay.izx.com.test.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.utils.ImageLoaderUtils;

/**
 * Created by sujie on 2018/5/2.
 */

public class Test1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mData;

    private Test1Adapter.OnItemClickListener mOnItemClickListener;

    public Test1Adapter() {
        mData = new ArrayList<>();
    }

    public void setmDate(List<String> data) {
        this.mData.clear();
        this.mData.addAll(data);
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test1, parent, false);
        Test1Adapter.ItemViewHolder vh = new Test1Adapter.ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Test1Adapter.ItemViewHolder) {
            String result = mData.get(position);
            if (result == null) {
                return;
            }
            ((ItemViewHolder) holder).tvTest.setText(result);
        }
    }

    @Override
    public int getItemCount() {
        return mData != null && mData.size() > 0 ? mData.size() : 0;
    }

    public void setOnItemClickListener(Test1Adapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public String getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvTest;

        public ItemViewHolder(View v) {
            super(v);
            tvTest = v.findViewById(R.id.tvTest);
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