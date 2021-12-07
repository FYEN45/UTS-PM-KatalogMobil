package com.example.katalogkelompok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private final Activity activity;
    private ArrayList<Users> arraylist_data = new ArrayList<>();

    public UserAdapter(Activity a, ArrayList<Users> d) {
        activity = a;
        arraylist_data = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arraylist_data.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylist_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null) {
            vi = inflater.inflate(R.layout.user_item, null);
        }
        TextView textViewname = vi.findViewById(R.id.ul_name);

        Users users = arraylist_data.get(position);
        textViewname.setText(users.getName());
        return vi;
    }
}
