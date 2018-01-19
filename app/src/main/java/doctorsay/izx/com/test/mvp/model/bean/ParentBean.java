package doctorsay.izx.com.test.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by haohaitao on 17/10/18.
 */

public class ParentBean implements Serializable {
    private String resptime;


    public String getResptime() {
        return resptime;
    }

    @Override
    public String toString() {
        return "ParentBean{" +
                "resptime='" + resptime + '\'' +
                '}';
    }


}
