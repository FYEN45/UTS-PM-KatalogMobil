package com.example.katalogkelompok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentMobil extends Fragment implements MobilListAdapter.OnGridItemSelectedListener {
    private RecyclerView lvSingle;
    private MobilListAdapter mobilListAdapter;
    private Context context;
    DataListMobil dataListMobil = new DataListMobil();

    public static Fragment newInstance() {
        return new FragmentMobil();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmen_mobil, container, false);
        lvSingle = rootView.findViewById(R.id.lvSingle);
        return rootView;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mobilListAdapter = new MobilListAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        lvSingle.setLayoutManager(gridLayoutManager);
        lvSingle.addItemDecoration(new GridMarginDecoration(0, 0, 0, 0));
        lvSingle.setAdapter(mobilListAdapter);
        loadData();
    }

    public void loadData() {
        List<Mobil> mobilList = new ArrayList<>();
        Mobil mobil;
        int[] img = dataListMobil.gridimg;
        String[] title = dataListMobil.gridtitle;
        for (int i = 0; i < img.length; i++) {
            mobil = new Mobil();
            mobil.setImg(img[i]);
            mobil.setTitle(title[i]);
            mobilList.add(mobil);
        }
        mobilListAdapter.addAll(mobilList);
    }

    @Override
    public void onGridItemClick(View v, int position) {
        Intent intent = new Intent(getActivity(), DescriptionActivity.class);
        intent.putExtra("img", dataListMobil.gridimg[position]);
        intent.putExtra("title", dataListMobil.gridtitle[position]);
        intent.putExtra("harga", dataListMobil.harga[position]);
        intent.putExtra("deskripsi1", dataListMobil.griddeskripsi1[position]);
        startActivity(intent);
    }
}