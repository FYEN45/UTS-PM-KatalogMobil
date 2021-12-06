package com.example.katalogkelompok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentMobil extends Fragment implements MobilListAdapter.OnGridItemSelectedListener{
    private RecyclerView lvSingle;
    private MobilListAdapter mobilListAdapter;
    private Context context;
    HomeActivity home = new HomeActivity();

    public static Fragment newInstance() { return new FragmentMobil();}

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragmen_mobil, container, false);
        lvSingle = rootView.findViewById(R.id.lvSingle);
        return rootView;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mobilListAdapter = new MobilListAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        lvSingle.setLayoutManager(gridLayoutManager);
        lvSingle.addItemDecoration(new GridMarginDecoration(0, 0, 0, 0));
        lvSingle.setAdapter(mobilListAdapter);
        loadData();
    }

    public void loadData(){
        List<Mobil> mobilList = new ArrayList<>();
        Mobil mobil;
        int[] img = {
                R.drawable.mobil0, R.drawable.mobil1, R.drawable.mobil2, R.drawable.mobil3,
                R.drawable.mobil4, R.drawable.mobil5, R.drawable.mobil6, R.drawable.mobil7
        };
        String[] title = {
                "New Vios", "All New Corolla Altis", "All New Camry", "All New Corolla Altis Hybrid",
                "All New Camry Hybrid", "New Toyota 86", "Toyota GR Supra", "All New Avanza"
        };
        for(int i = 0; i < img.length; i++){
            mobil = new Mobil();
            mobil.setImg(img[i]);
            mobil.setTitle(title[i]);
            mobilList.add(mobil);
        }
        mobilListAdapter.addAll(mobilList);
    }
    @Override
    public void onGridItemClick(View v, int position){
        Toast.makeText(context, mobilListAdapter.getItem(position).getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DescriptionActivity.class);
        intent.putExtra("img", home.gridimg[position]);
        intent.putExtra("title", home.gridtitle[position]);
        intent.putExtra("deskripsi", home.griddeskripsi[position]);
        startActivity(intent);
    }
}
