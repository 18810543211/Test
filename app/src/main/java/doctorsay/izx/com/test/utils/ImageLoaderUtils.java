package doctorsay.izx.com.test.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;

import doctorsay.izx.com.test.R;


/**
 * Description : 图片加载工具类 使用glide框架封装
 */
public class ImageLoaderUtils {

    private static Context mContext;

    public static void display(Context context, ImageView imageView, String url, int placeholder, int error) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).placeholder(placeholder)
                .error(error).crossFade().into(imageView);
    }

    /**
     * 普通加载
     *
     * @param context   上下文
     * @param imageView 显示控件
     * @param url       地址
     */
    public static void display(Context context, ImageView imageView, String url) {
        mContext = context.getApplicationContext();
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(mContext).load(url.replace("https://", "http://"))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

    /**
     * 加载封面图
     */
    public static void displayThumbImage(Context context, ImageView imageView, String url) {
        mContext = context.getApplicationContext();
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(mContext).load(url.replace("https://", "http://")).fitCenter().into(imageView);
    }

    /**
     * 获取图片显示在ImageView后的宽高
     */
    public static void displayBitmapImage(Context context, ImageView imageView, String url) {
        mContext = context.getApplicationContext();
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(mContext)
                .load(url.replace("https://", "http://"))
                .asBitmap()//强制Glide返回一个Bitmap对象
                .placeholder(R.drawable.ic_image_loading)
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap bitmap, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {

                        return false;
                    }
                }).into(imageView);
    }

    public static void display(Context context, ImageView imageView, File url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

    public static void displaySmallPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .thumbnail(0.5f)
                .into(imageView);
    }

    public static void displayBigPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .into(imageView);
    }

    public static void display(Context context, ImageView imageView, int url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

}
