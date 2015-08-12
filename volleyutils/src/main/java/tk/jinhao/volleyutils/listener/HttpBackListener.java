package tk.jinhao.volleyutils.listener;

/**
 * Created by shanks on 15/8/1.
 */
public interface HttpBackListener<T> {
    public void onSuccess(T t);
    public void onFail();

}
