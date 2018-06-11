package doctorsay.izx.com.test.mvp2;

import android.os.Bundle;

/**
 * Created by sujie on 2018/5/16.
 */

public interface MvpPresenter<V extends BaseMvpView> {

    void onMvpAttachView(V view, Bundle savedInstanceState);

    void onMvpStart();

    void onMvpResume();

    void onMvpPause();

    void onMvpStop();

    void onMvpSaveInstanceState(Bundle savedInstanceState);

    void onMvpDetachView(boolean retainInstance);

    void onMvpDestroy();
}
