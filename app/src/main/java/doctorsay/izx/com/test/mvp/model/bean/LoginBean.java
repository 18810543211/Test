package doctorsay.izx.com.test.mvp.model.bean;

/**
 * 登陆实体类
 * Created by sujie on 2018/1/17.
 */

public class LoginBean {
    private String user_name;
    private String user_password;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}
