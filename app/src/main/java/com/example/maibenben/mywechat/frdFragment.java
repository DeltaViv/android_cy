package com.example.maibenben.mywechat;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class frdFragment extends Fragment {
    private List<Peaky> peakyList = new ArrayList<>();

    public frdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_02,container,false);
        RecyclerView recyclerView;
        initPeakys();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        Adapter adapter = new Adapter(peakyList);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void initPeakys() {
        for (int i = 0; i < 10; i++) {
            Peaky a = new Peaky("a", R.drawable.t1);
            peakyList.add(a);
            Peaky b = new Peaky("b", R.drawable.t2);
            peakyList.add(b);
            Peaky c = new Peaky("c", R.drawable.t3);
            peakyList.add(c);
            Peaky d = new Peaky("d", R.drawable.t4);
            peakyList.add(d);
            Peaky e = new Peaky("d", R.drawable.t5);
            peakyList.add(e);
            Peaky f = new Peaky("f", R.drawable.t6);
            peakyList.add(f);
            Peaky g = new Peaky("g", R.drawable.t7);
            peakyList.add(g);
        }
    }

}

