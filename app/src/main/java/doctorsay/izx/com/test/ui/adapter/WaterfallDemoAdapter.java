package doctorsay.izx.com.test.ui.adapter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import doctorsay.izx.com.test.R;

/**
 * Created by sujie on 2018/6/7.
 */

public class WaterfallDemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mData;

    public WaterfallDemoAdapter(List<String> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_waterfall, parent, false);
        WaterfallDemoAdapter.ItemViewHolder vh = new WaterfallDemoAdapter.ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WaterfallDemoAdapter.ItemViewHolder) {
            String result = mData.get(position);
            if (result == null) {
                return;
            }
//            if (!TextUtils.isEmpty(result)) {
//                ImageLoaderUtils.display(((ItemViewHolder) holder).ivWaterfall.getContext(), ((ItemViewHolder) holder).ivWaterfall, result);
//            }
            ((ItemViewHolder) holder).ivWaterfall.setBackgroundColor(getColor(((ItemViewHolder) holder).ivWaterfall));
        }
    }

    private int getColor(ImageView imageView) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        if (bitmapDrawable == null)
            return Color.BLUE;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Palette palette = Palette.from(bitmap).generate();
        int defaultColor = Color.BLUE;
        int color = palette.getLightMutedColor(defaultColor);

        return color;
    }

    @Override
    public int getItemCount() {
        return mData != null && mData.size() > 0 ? mData.size() : 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivWaterfall;

        public ItemViewHolder(View v) {
            super(v);
            ivWaterfall = v.findViewById(R.id.ivWaterfall);
        }
    }

}
