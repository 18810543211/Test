package doctorsay.izx.com.test;

import android.app.Application;
import android.content.res.Resources;

import com.alibaba.android.arouter.launcher.ARouter;

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
        initARouter();
    }

    public static App getAppContext() {
        return mContext;
    }

    public static Resources getAppResources() {
        return mContext.getResources();
    }


    /**
     * 初始化页面路由框架
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {   // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
