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

public class usa_CustomLV extends ArrayAdapter<String> {

    private String[] usa_places;
    private Integer[] usa_price;
    private Integer[] usa_imgid;
    private Activity context;

    public usa_CustomLV(AdapterView.OnItemSelectedListener context, String[] usa_places, Integer[] usa_price, Integer[] usa_imgid) {
        super((Context) context, R.layout.listview,usa_places);
        this.context= (Activity) context;
        this.usa_places=usa_places;
        this.usa_price=usa_price;
        this.usa_imgid=usa_imgid;
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

        viewHolder.iv.setImageResource(usa_imgid[position]);
        viewHolder.tv1.setText(usa_places[position]);
        viewHolder.tv2.setText(usa_price[position]);
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
