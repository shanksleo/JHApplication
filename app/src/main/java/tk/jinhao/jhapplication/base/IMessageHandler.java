package tk.jinhao.jhapplication.base;

import android.os.Message;

/**
 * Created by shanks on 15/5/22.
 */
public interface IMessageHandler {
    /*
    * 在这里处理异步消息
    * */
    public void handleMessage(Message msg);
}
