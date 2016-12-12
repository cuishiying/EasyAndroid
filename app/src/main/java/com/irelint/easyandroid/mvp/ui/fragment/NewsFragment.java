package com.irelint.easyandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irelint.easyandroid.R;
import com.irelint.easyandroid.mvp.ui.adapter.NewsRecyclerAdapter;

import java.util.ArrayList;

/**
 * 作者：当我遇上你 on 2016-9-27 22:19
 * 邮箱：cuishiying163@163.com
 */

public class NewsFragment extends Fragment {
    private static final String TAB_POSITION = "tab_position";
    public NewsFragment() {

    }

    public static NewsFragment newInstance(int tabPosition) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int tabPosition = args.getInt(TAB_POSITION);

        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            items.add("Tab #" + tabPosition + " item #" + i);
        }

        View v =  inflater.inflate(R.layout.fragment_recyclerview, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new NewsRecyclerAdapter(items));

        return v;
    }
}
