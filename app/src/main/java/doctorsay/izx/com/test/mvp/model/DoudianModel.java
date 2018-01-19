package doctorsay.izx.com.test.mvp.model;

import doctorsay.izx.com.test.mvp.OnDoudianListDetailFinishedInterface;
import doctorsay.izx.com.test.mvp.OnDoudianListFinishedInterface;

/**
 * Created by sujie on 2018/1/19.
 */

public interface DoudianModel {
    void loadList(String url, String type, int page, OnDoudianListFinishedInterface onDoudianListFinishedInterface);

    void loadListDetail(String url, String projectId, OnDoudianListDetailFinishedInterface mOnDoudianListDetailFinishedInterface);
}
