package doctorsay.izx.com.test.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sujie on 2018/1/26.
 */

public class StrictSelectionBean2 implements Serializable {
    private int code;
    private boolean result;
    private List<StrictSelectionBean.PageStarResult> data;

    @Override
    public String toString() {
        return "DouDianProject{" +
                "code=" + code +
                ", result=" + result +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public boolean isResult() {
        return result;
    }

    public List<StrictSelectionBean.PageStarResult> getData() {
        return data;
    }
}
