package doctorsay.izx.com.test.utils.okhttp;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import doctorsay.izx.com.test.utils.LogUtils;

/**
 * okhttp网络请求工具类
 * Created by sujie on 2018/1/18.
 */

public class OkhttpUtils {
    public static final String TAG = "OkhttpUtils";

    private static OkhttpUtils mInstance;

    private OkHttpClient mHttpClient;

    private Gson mGson;

    private Handler mHandler;

    public Handler getHandler() {
        return mHandler;
    }

    public static OkhttpUtils getInstance() {
        return mInstance;
    }

    static {
        mInstance = new OkhttpUtils();
    }

    private OkhttpUtils() {
        mHttpClient = new OkHttpClient();
        mHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        mHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        mHttpClient.setWriteTimeout(30, TimeUnit.SECONDS);
        //针对https用
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new SecureRandom());
            mHttpClient.setSslSocketFactory(sc.getSocketFactory());
            mHttpClient.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            LogUtils.i(TAG, e.getMessage());
        }
        mGson = new Gson();

        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 普通get请求
     *
     * @param url
     * @param callback
     */
    public void get(String url, BaseCallback callback) {
        get(url, null, callback);
    }

    public void get(String url, Map<String, Object> params, BaseCallback callback) {
        Request request = buildGetRequest(url, params);
        request(request, callback);
    }

    /**
     * 下载网络图片请求
     *
     * @param url
     * @param callback
     */
    public void getDownloadImage(String url, BaseCallback callback) {
        getDownloadImage(url, null, callback);
    }

    public void getDownloadImage(String url, Map<String, Object> params, BaseCallback callback) {
        Request request = buildGetRequest(url, params);
        requestDownloadImage(request, callback);
    }

    /**
     * 普通post请求
     *
     * @param url
     * @param params
     * @param callback
     */
    public void post(String url, Map<String, Object> params, BaseCallback callback) {
        Request request = buildPostRequest(url, params);
        request(request, callback);
    }

    /**
     * post同步请求
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public Response syncPost(String url, Map<String, Object> params) throws IOException {
        Request request = buildPostRequest(url, params);
        return syncRequest(request);
    }

    /**
     * post请求，json数据为body
     *
     * @param url
     * @param json
     * @param callback
     */
    public void postJson(String url, String json, final BaseCallback callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        request(request, callback);
    }

    public void postUpload(String url, File file, final BaseCallback callback) {
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM)
                .addPart(Headers.of("multipart/form-data;"), fileBody)
                .build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        request(request, callback);
    }

    private void requestDownloadImage(Request request, final BaseCallback callback) {
        callback.onBeforeRequest(request);
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callbackFailure(callback, request, e);
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onResponse(Response response) throws IOException {
                callbackResponse(callback, response);
                if (response.isSuccessful()) {
                    if (callback.mType == File.class) {
                        callback.onSuccess(response, null);
                    } else {
                        byte[] resultStr = response.body().bytes();
                        if (response.isSuccessful()) {
                            callbackSuccess(callback, response, resultStr);
                        }
                    }
                } else {
                    callbackError(callback, response, null);
                }
            }
        });
    }

    private void request(Request request, final BaseCallback callback) {
        callback.onBeforeRequest(request);
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callbackFailure(callback, request, e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                callbackResponse(callback, response);
                if (response.isSuccessful()) {
                    if (callback.mType == File.class) {
                        callback.onSuccess(response, null);
                    } else {
                        String resultStr = response.body().string();
                        if (callback.mType == String.class) {
                            callbackSuccess(callback, response, resultStr);
                        } else {
                            try {
                                Object obj = mGson.fromJson(resultStr, callback.mType);
                                callbackSuccess(callback, response, obj);
                            } catch (JsonParseException e) {
                                callback.onError(response, response.code(), e);
                            }
                        }
                    }
                } else {
                    callbackError(callback, response, null);
                }
            }
        });
    }

    private Response syncRequest(Request request) throws IOException {
        return mHttpClient.newCall(request).execute();
    }

    private void callbackSuccess(final BaseCallback callback, final Response response, final Object obj) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response, obj);
//                LogUtils.i(Constants.ConstantsValue.ANG,"xsj  "+obj);
            }
        });
    }

    private void callbackError(final BaseCallback callback, final Response response, final Exception e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(response, response.code(), e);
            }
        });
    }


    private void callbackFailure(final BaseCallback callback, final Request request, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onFailure(request, e);
            }
        });
    }


    private void callbackResponse(final BaseCallback callback, final Response response) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onResponse(response);
            }
        });
    }

    private Request buildPostRequest(String url, Map<String, Object> params) {
        return buildRequest(url, HttpMethodType.POST, params);
    }

    private Request buildGetRequest(String url, Map<String, Object> params) {
        return buildRequest(url, HttpMethodType.GET, params);
    }

    private Request buildRequest(String url, HttpMethodType type, Map<String, Object> params) {
        Request.Builder builder = new Request.Builder().url(url);
        if (type == HttpMethodType.POST) {
            RequestBody body = buildFormData(params);
            builder.post(body);
        } else if (type == HttpMethodType.GET) {
            url = buildUrlParams(url, params);
            builder.url(url);
            builder.get();
        }
        return builder.build();
    }

    private String buildUrlParams(String url, Map<String, Object> params) {

        if (params == null) {
            params = new HashMap<>(1);
        }

        String token = null;

        if (!TextUtils.isEmpty(token)) {
            params.put("token", token);
        }

        StringBuffer sb = new StringBuffer();

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() == null ? "" : entry.getValue().toString());
            sb.append("&");
        }

        String s = sb.toString();

        if (s.endsWith("&")) {
            s = s.substring(0, s.length() - 1);
        }

        if (url.indexOf("?") > 0) {
            url = url + "&" + s;
        } else {
            url = url + "?" + s;
        }

        return url;
    }

    private RequestBody buildFormData(Map<String, Object> params) {
        FormEncodingBuilder builder = new FormEncodingBuilder();

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString());
            }

            String token = null;

            if (!TextUtils.isEmpty(token)) {
                builder.add("token", token);
            }
        }

        return builder.build();
    }


    enum HttpMethodType {
        GET,
        POST
    }

    public void onDestroy() {
        if (mHandler != null) mHandler.removeCallbacksAndMessages(null);
    }
}
