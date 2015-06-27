package tk.jinhao.jhapplication.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

/**
 * Created by shanks on 15/5/21.
 */
public abstract class JHFragment extends Fragment implements IEventSender, IMessageHandler, IActivityMessagerHandler {
    private static final int SEND_TO_FRAGMENT = 0x001;

    private IEventHandler mEventHandler;
    private BaseHanlder mHanlder;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof IEventHandler) {
            mEventHandler = (IEventHandler) getActivity();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == mHanlder) {
            mHanlder = new BaseHanlder(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHanlder = null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mEventHandler = null;
    }

    @Override
    public void sendToActivity(int eventType, int eventId, Bundle data) {
        mEventHandler.handleFragmentEvent(eventType, eventId, data);
    }


    /*
    * 如果当前处于子线程,则 用这个向主线程发送消息
    * */
    public void postToActivity(int eventType, int eventId, Bundle data) {
        Message message = mHanlder.obtainMessage();
        message.what = SEND_TO_FRAGMENT;
        message.arg1 = eventType;
        message.arg2 = eventId;
        message.setData(data);
        mHanlder.sendMessage(message);
    }

    public void setListener(View.OnClickListener listener, View... views) {
        for (View view : views) {
            view.setOnClickListener(listener);
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SEND_TO_FRAGMENT:
                sendToActivity(msg.arg1, msg.arg2, msg.getData());
                break;

            default:
                break;
        }
    }

    @Override
    public abstract void handleActivityEvent(int eventType, int eventId, Bundle data);


}
