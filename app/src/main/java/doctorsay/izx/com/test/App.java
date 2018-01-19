package doctorsay.izx.com.test;

import android.app.Application;
import android.content.res.Resources;

/**
 * Created by sujie on 2018/1/5.
 */

public class App extends Application {
    public static String uid = "111";

    private static App mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static App getAppContext() {
        return mContext;
    }

    public static Resources getAppResources() {
        return mContext.getResources();
    }
}
