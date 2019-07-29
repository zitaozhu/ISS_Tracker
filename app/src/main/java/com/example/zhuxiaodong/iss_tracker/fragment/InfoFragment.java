package com.example.zhuxiaodong.iss_tracker.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhuxiaodong.iss_tracker.R;
import com.example.zhuxiaodong.iss_tracker.adapter.InfoAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuxiaodong on 2019/7/28.
 */

public class InfoFragment extends Fragment {

    private RecyclerView infoRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        infoRecyclerView = view.findViewById(R.id.info_recyclerview);

        infoRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());

        infoRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new InfoAdapter(getData());
        infoRecyclerView.setAdapter(mAdapter);

        return view;
    }

    public List<String> getData(){
        List<String> data = new LinkedList<>();
        String temp = " item -------";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }
        return data;
    }
}
