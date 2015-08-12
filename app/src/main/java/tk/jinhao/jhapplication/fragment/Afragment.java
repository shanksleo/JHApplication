package tk.jinhao.jhapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.jinhao.jhapplication.R;
import tk.jinhao.jhapplication.base.JHFragment;

/**
 * Created by shanks on 15/5/25.
 */
public class Afragment extends JHFragment{

    private View mView;

    @Override
    public void handleActivityEvent(int eventType, int eventId, Bundle data) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (null == mView){
            mView = inflater.inflate(R.layout.fragment_baidu_map,container,false);
        }else{
//          解开于父级 View 的绑定关系,用于第二次开启这个 Fragment 的时候
            ViewGroup mViewGroup = (ViewGroup) mView.getParent();
            if (null != mViewGroup){
                mViewGroup.removeView(mView);
            }
        }

        return mView;

    }


}
