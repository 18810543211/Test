package doctorsay.izx.com.test.utils.okhttp;

import android.content.Context;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public abstract class SimpleCallback<T> extends BaseCallback<T> {

	protected Context mContext;

    public SimpleCallback(Context context){
        mContext = context;
    }

    @Override
    public void onBeforeRequest(Request request) {

    }

    @Override
    public void onFailure(Request request, Exception e) {

    }

    @Override
    public void onResponse(Response response) {

    }
}
