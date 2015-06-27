package tk.jinhao.jhlibrary.util;

/**
 * Created by shanks on 15/6/8.
 */
public abstract class CallBack {
    public void response(Result result){
        if (null == result){
            return;
        }
        response(result.getStatusCode());

    }

    public abstract void response(int resultCode);
}
