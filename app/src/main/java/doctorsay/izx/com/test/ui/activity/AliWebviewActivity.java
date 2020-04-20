package doctorsay.izx.com.test.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;

import org.json.JSONObject;

import doctorsay.izx.com.test.R;
import wendu.dsbridge.CompletionHandler;
import wendu.dsbridge.DWebView;

/**
 * Created by sujie on 2018/4/8.
 */

public class AliWebviewActivity extends AppCompatActivity {

    private static final String TAG = "AliWebviewActivity";

    private DWebView mDWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali_webview);
        initView();
    }

    private void initView() {
        mDWebView = findViewById(R.id.mDWebView);

        mDWebView.addJavascriptObject(new Object() {

            /**
             * Note: This method is for Fly.js
             * In browser, Ajax requests are sent by browser, but Fly can
             * redirect requests to native, more about Fly see  https://github.com/wendux/fly
             * @param requestData passed by fly.js, more detail reference https://wendux.github.io/dist/#/doc/flyio-en/native
             * @param handler
             */
            @JavascriptInterface
            public void onAjaxRequest(JSONObject requestData, CompletionHandler handler) {
                // Handle ajax request redirected by Fly
                Log.i(TAG, "onAjaxRequest: " + requestData.toString());
//                AjaxHandler.onAjaxRequest((JSONObject)requestData,handler);
            }

        }, null);

        mDWebView.loadUrl("https://h5.m.taobao.com/mlapp/olist.html?tabCode=all&condition=%7B%22extra%22%3A%7B%22attributes%22%3A%7B%22ttid%22%3A%2224839542%22%7D%7D%7D&umpChannel=1-24839542&isv_code=appisvcode&ybhpss=dHRpZD0yMDE0XzBfMjQ4Mzk1NDIlNDBiYWljaHVhbl9hbmRyb2lkXzMuMS4xLjExJmFsaWJhYmE9%0AJUU5JTk4JUJGJUU5JTg3JThDJUU1JUI3JUI0JUU1JUI3JUI0%0A&ttid=2014_0_24839542@baichuan_android_3.1.1.11&u_channel=1-24839542");
    }
}
