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

public class eng_CustomLV extends ArrayAdapter<String> {

    private String[] eng_places;
    private Integer[] eng_price;
    private Integer[] eng_imgid;
    private Activity context;

    public eng_CustomLV(AdapterView.OnItemSelectedListener context, String[] eng_places, Integer[] eng_price, Integer[] eng_imgid) {
        super((Context) context, R.layout.listview,eng_places);
        this.context= (Activity) context;
        this.eng_places=eng_places;
        this.eng_price=eng_price;
        this.eng_imgid=eng_imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        CustomListview.ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview,null,true);
            viewHolder=new CustomListview.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder= (CustomListview.ViewHolder) r.getTag();
        }

        viewHolder.iv.setImageResource(eng_imgid[position]);
        viewHolder.tv1.setText(eng_places[position]);
        viewHolder.tv2.setText(eng_price[position]);
        return r;
    }

    class ViewHolder
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
