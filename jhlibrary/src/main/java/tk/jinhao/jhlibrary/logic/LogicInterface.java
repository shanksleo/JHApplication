package tk.jinhao.jhlibrary.logic;

import android.content.Context;

import tk.jinhao.jhlibrary.util.CallBack;

/**
 * Created by shanks on 15/6/8.
 */
public interface LogicInterface {
    void login(Context context,CallBack callBack);
    void loginOut(Context context,CallBack callBack);
}
