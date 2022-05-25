package com.example.changedaworld.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.changedaworld.R;

import java.util.List;

public class LinkAdapter extends ArrayAdapter<UsefulLink> {
    private LayoutInflater inflater;
    private int layout;
    private List<UsefulLink> links;

    public LinkAdapter(Context context, int resource, List<UsefulLink> links) {
        super(context, resource, links);
        this.links = links;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.img);
        TextView nameView = view.findViewById(R.id.name);
        TextView capitalView = view.findViewById(R.id.link);

        UsefulLink food = links.get(position);
        flagView.setImageResource(food.getImgResource());
        nameView.setText(food.getName());
        capitalView.setText(food.getLink());

        return view;
    }
}
