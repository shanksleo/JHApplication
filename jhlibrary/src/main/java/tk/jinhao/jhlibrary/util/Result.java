package tk.jinhao.jhlibrary.util;

/**
 * Created by shanks on 15/6/8.
 */
public class Result {
    public static final int OK = 0x001;
    public static final int ERROR = 0x002;

    private int statusCode;
    private String result;

    public Result(int statusCode) {
        this.statusCode = statusCode;
    }

    public Result(int statusCode, String result) {
        this.statusCode = statusCode;
        this.result = result;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
