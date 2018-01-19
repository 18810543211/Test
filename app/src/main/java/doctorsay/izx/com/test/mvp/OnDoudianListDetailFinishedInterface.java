package doctorsay.izx.com.test.mvp;

import java.util.List;

import doctorsay.izx.com.test.mvp.model.bean.StrictSelectionBean;

/**
 * Created by sujie on 2018/1/19.
 */

public interface OnDoudianListDetailFinishedInterface {

    void onSuccess(String results);

    void onFailure();
}
