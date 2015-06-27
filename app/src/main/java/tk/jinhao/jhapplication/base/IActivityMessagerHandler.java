package tk.jinhao.jhapplication.base;

import android.os.Bundle;

/**
 * Created by shanks on 15/6/8.
 */
public interface IActivityMessagerHandler {

    /*
    * 处理来自 Activity 的消息
    * */
    public void handleActivityEvent(int eventType,int eventId,Bundle data);
}
