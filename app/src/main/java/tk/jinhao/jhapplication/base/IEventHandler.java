package tk.jinhao.jhapplication.base;

import android.os.Bundle;

/**
 * Created by shanks on 15/5/21.
 */
public interface IEventHandler {
    /*
    * 用于接受子 fragment 事件
    * eventType   事件类型
    * eventId 事件 id
    * data    数据
    * */
    public void handleFragmentEvent(int eventType,int eventId,Bundle data);

    /*
    * 切换Fragment
    * */
    public void switchFragment(int eventId,Bundle data);
}
