package com.example.test2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListview extends ArrayAdapter<String> {

    private String[] can_places;
    private Integer[] can_price;
    private Integer[] imgid;
    private Activity context;

    public CustomListview(AdapterView.OnItemSelectedListener context, String[] can_places, Integer[] canPrice, Integer[] can_price) {
        super((Context) context, R.layout.listview,can_places);
        this.context= (Activity) context;
        this.can_places=can_places;
        this.can_price=can_price;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) r.getTag();
        }

        viewHolder.iv.setImageResource(imgid[position]);
        viewHolder.tv1.setText(can_places[position]);
        viewHolder.tv2.setText(can_price[position]);
        return r;
    }

    static class ViewHolder
    {
        TextView tv1;
        TextView tv2;
        ImageView iv;

        ViewHolder(View v)
        {
            tv1=v.findViewById(R.id.txt_placeName);
            tv2=v.findViewById(R.id.txt_Price);
            iv=v.findViewById(R.id.imageView);
        }


    }
}
