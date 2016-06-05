package easyrun.activity;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import easyrun.bean.FreePicBean;
import easyrun.util.R;

public class FindPictureFragment extends Fragment {

    private ArrayList<FreePicBean> pictureList;
    private View mMainView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().getActionBar().hide();
        mMainView = inflater.inflate(R.layout.find_picture, container, false);
        ListView picList = (ListView)mMainView.findViewById(R.id.picListView);

        //获取传递来的用户信息
        Bundle bundle = getArguments();
        bundle.getParcelable("userInfo");

        init();//初始化照片列表
        final PictureListAdapter adapter = new PictureListAdapter(mMainView.getContext(), pictureList);

        picList.setAdapter(adapter);
        picList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                ((FoldingCell) view).toggle(false);
                adapter.registerToggle(pos);
            }
        });
        return mMainView;
    }

    protected void init(){
        pictureList = new ArrayList<FreePicBean>();
        FreePicBean freePic = new FreePicBean();
        freePic.setDownloadCnt(1);
        freePic.setEventName("杭州马拉松");
        freePic.setUpTime(3661000l);
        freePic.setUserName("葛丛丛");
        int i=0;
        while(i<5){
            pictureList.add(freePic);
            i++;
        }
        //从服务器获取照片流跟相关数据

    }

    @Override
    public void onStop() {
        Log.v("test", "Find Picture Fragment-->onStop()");
        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.v("test", "Find Picture Fragment-->onDestroy()");
        super.onDestroy();
    }

}
