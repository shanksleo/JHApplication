package tk.jinhao.jhapplication.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.jinhao.jhapplication.R;

/**
 * Created by shanks on 15/6/24.
 */
public class BaseDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate( R.layout.dialog_confim,null);

        return view;
    }
}
