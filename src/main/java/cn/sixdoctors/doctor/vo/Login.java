package cn.sixdoctors.doctor.vo;

public class Login<T> {

    private String token;

    private T data;

    public Login() {
    }

    public Login(String token, T data) {
        this.token = token;
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Login{" +
                "token='" + token + '\'' +
                ", data=" + data +
                '}';
    }
}
