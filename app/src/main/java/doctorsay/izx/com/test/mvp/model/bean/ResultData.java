package doctorsay.izx.com.test.mvp.model.bean;

/**
 * Created by sujie on 2018/1/26.
 */

public class ResultData<T> {
    private String resptime;
    private long timestamp;
    private T result;

    public String getResptime() {
        return resptime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public T getResult() {
        return result;
    }
}
