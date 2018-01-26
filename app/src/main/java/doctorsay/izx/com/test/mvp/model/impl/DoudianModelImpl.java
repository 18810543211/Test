package doctorsay.izx.com.test.mvp.model.impl;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.HashMap;
import java.util.Map;

import doctorsay.izx.com.test.App;
import doctorsay.izx.com.test.mvp.OnDoudianListDetailFinishedInterface;
import doctorsay.izx.com.test.mvp.OnDoudianListFinishedInterface;
import doctorsay.izx.com.test.mvp.model.DoudianModel;
import doctorsay.izx.com.test.mvp.model.bean.ResultData;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;
import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean2;
import doctorsay.izx.com.test.utils.ConstantsUtils;
import doctorsay.izx.com.test.utils.LogUtils;
import doctorsay.izx.com.test.utils.okhttp.OkhttpUtils;
import doctorsay.izx.com.test.utils.okhttp.SimpleCallback;

/**
 * Created by sujie on 2018/1/19.
 */

public class DoudianModelImpl implements DoudianModel {

    private static final String TAG = "DoudianModelImpl";

    @Override
    public void loadList(String url, String type, final int page, final OnDoudianListFinishedInterface onDoudianListFinishedInterface) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("projectType", type);
        map.put("pageIndex", page);
        map.put("pageSize", ConstantsUtils.PAGE_INDEX);
        OkhttpUtils.getInstance().post(url, map, new SimpleCallback<ResultData<StrictSelectionBean2>>(App.getAppContext()) {

            @Override
            public void onSuccess(Response response, final ResultData<StrictSelectionBean2> results) {
                LogUtils.i(TAG, "请求成功" + page);
                if (results.getResult() != null && results.getResult().getData() != null && results.getResult().getData().size() > 0) {
                    onDoudianListFinishedInterface.onSuccess(results.getResult().getData());
                }
            }

            @Override
            public void onError(Response response, int code, Exception e) {
                LogUtils.i(TAG, "请求错误");

            }

            @Override
            public void onFailure(Request request, Exception e) {
                LogUtils.i(TAG, "请求失败");

                onDoudianListFinishedInterface.onFailure();
            }
        });
    }

    @Override
    public void loadListDetail(String url, String projectId, final OnDoudianListDetailFinishedInterface mOnDoudianListDetailFinishedInterface) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("projectId", projectId);
        map.put("token", "0d5fff06a0bf4be1bc364883817dc58a.001");
        OkhttpUtils.getInstance().post(url, map, new SimpleCallback<String>(App.getAppContext()) {

            @Override
            public void onSuccess(Response response, final String results) {
                LogUtils.i(TAG, "请求成功" + results);
                mOnDoudianListDetailFinishedInterface.onSuccess(results);
            }

            @Override
            public void onError(Response response, int code, Exception e) {
                LogUtils.i(TAG, "请求错误");
            }

            @Override
            public void onFailure(Request request, Exception e) {
                LogUtils.i(TAG, "请求失败");
                mOnDoudianListDetailFinishedInterface.onFailure();
            }
        });
    }

}
