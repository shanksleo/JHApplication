package tk.jinhao.jhapplication.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by shanks on 15/5/21.
 */
public abstract class JHActivity extends AppCompatActivity implements IEventHandler {
//    实际干活的那个小子
    private IEventHandler mIEventHandler;

    @Override
    public void handleFragmentEvent( int eventType, int eventId,Bundle data) {
        mIEventHandler.handleFragmentEvent(eventType,eventId,data);
    }

    @Override
    public void switchFragment(int eventId, Bundle data) {
        mIEventHandler.switchFragment(eventId,data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIEventHandler = getInstace();
        if (mIEventHandler instanceof JHActivityEventHandler){
            ((JHActivityEventHandler)mIEventHandler).setContext(this);

        }

    }

//    public static class Instance{
//       static JHActivityEventHandler jhActivityEventHandler = new JHActivityEventHandler();
//    }

  /*  public static IEventHandler  getInstace(){
        return Instance.jhActivityEventHandler;
    }*/

    public abstract IEventHandler getInstace();

    public void setListeners(View.OnClickListener listener, View... views) {
        for (View view : views) {
            view.setOnClickListener(listener);
        }
    }
}
