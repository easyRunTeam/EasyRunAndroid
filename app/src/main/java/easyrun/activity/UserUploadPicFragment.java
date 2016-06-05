package easyrun.activity;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import easyrun.util.R;

/**
 * Created by 91337 on 2016/5/26.
 */
public class UserUploadPicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().getActionBar().hide();
        return inflater.inflate(R.layout.user_upload_pic, container, false);
    }

}
