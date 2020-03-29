package com.example.maibenben.mywechat;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class contactFragment extends Fragment {

    private static final String TAG = contactFragment.class.getSimpleName();

    private List<String> mList = new ArrayList<>();

    private List<GroupDataBean> mDataList = new ArrayList<>();
    public contactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_03,container,false);
        RecyclerView recyclerView;
        initList();
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_03);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        GroupAdapter adapter = new GroupAdapter(mDataList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initList() {
        mList.add("我的同学|小美人鱼?"+R.drawable.fish);
        mList.add("我的同学|白雪公主?"+R.drawable.queen);
        mList.add("我的同学|樱桃小丸子?"+R.drawable.yintao);
        mList.add("我的朋友|小兔子?"+R.drawable.t10);
        mList.add("我的家人|蜡笔小新的妈妈?"+R.drawable.l1);
        mList.add("我的家人|蜡笔小新的爸爸?"+R.drawable.l2);
        mList.add("我的家人|蜡笔小新的妹妹?"+R.drawable.l5);
        mList.add("我的家人|蜡笔小新的弟弟?"+R.drawable.l6);
        mList.add("我的家人|蜡笔小新的姐姐?"+R.drawable.l7);
        mList.add("我的家人|蜡笔小新的哥哥?"+R.drawable.l8);

    }

    private void initData() {
        for (int i = 0; i < mList.size(); i++) {
            GroupDataBean bean = new GroupDataBean();

            String s = mList.get(i);
            // area
            String area = s.substring(0, s.indexOf("|"));
            // team
            String team = s.substring(s.indexOf("|") + 1, s.indexOf("?"));
            int img = Integer.parseInt(s.substring(s.indexOf("?") + 1, s.length()));
            bean.setArea(area);
            bean.setTeam(team);
            bean.setimageid(img);
            mDataList.add(bean);
        }

        Log.d(TAG, "initData: " + mDataList.size());
    }

//    private void initView() {
//        GroupAdapter adapter = new GroupAdapter(this);
//
//        RecyclerView rcvGroup = findViewById(R.id.rcv_group);
//
//        rcvGroup.setLayoutManager(new LinearLayoutManager(this));
//        rcvGroup.setHasFixedSize(true);
//        rcvGroup.setAdapter(adapter);
//
//        adapter.setGroupDataList(mDataList);
//    }
}
