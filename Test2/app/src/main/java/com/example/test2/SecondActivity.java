package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class SecondActivity extends AppCompatActivity {

    private ImageView image;
    TextView capital;
    ListView lv;
    Button calc;
    TextView total;
    TextView sb_txt;
    SeekBar sb;
    Integer tota;


    String[] can_places={"Niagara falls", "CN Tower", "The Butchart Gardens", "Notre-Dame Basilica"};
    Integer[] can_price={100,30,30,50};
    Integer[] imgid={R.drawable.niagara_falls,R.drawable.cn_tower,R.drawable.thebutchartgardens,R.drawable.notredamebasilica};

    String[] usa_places={"The Statue of Liberty", "The White Houser", "Tims Square"};
    Integer[] usa_price={90,60,75};
    Integer[] usa_imgid={R.drawable.thestatueofliberty,R.drawable.thewhitehouse,R.drawable.timssquare};

    String[] eng_places={"Big Ben", "Westminster Abbey", "Hyde Park"};
    Integer[] eng_price={30,25,15};
    Integer[] eng_imgid={R.drawable.bigben,R.drawable.westminsterabbey,R.drawable.hydepark};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        image=findViewById(R.id.imageView_flag);
        capital=findViewById(R.id.txt_Capital);
        calc=findViewById(R.id.btn_calculate);
        total=findViewById(R.id.txt_total_price);
        sb_txt=findViewById(R.id.txt_quantity);
        sb=findViewById(R.id.seekBar);


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.CountryName, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 1:
                        image.setImageResource(R.drawable.flagcanada);
                        capital.setText("Ottawa");
                        lv=findViewById(R.id.listview);
                        CustomListview clv=new CustomListview(this, can_places,can_price,imgid);
                        lv.setAdapter(clv);
                        break;

                    case 2:
                        image.setImageResource(R.drawable.usa_flag);
                        capital.setText("Wahington");
                        lv=findViewById(R.id.listview);
                        usa_CustomLV usalv=new usa_CustomLV(this, usa_places,usa_price,usa_imgid);
                        lv.setAdapter(usalv);
                        break;

                    case 3:
                        image.setImageResource(R.drawable.england_flag);
                        capital.setText("London");
                        lv=findViewById(R.id.listview);
                        eng_CustomLV englv=new eng_CustomLV(this, eng_places,eng_price,eng_imgid);
                        lv.setAdapter(englv);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp =  sb.getProgress();
                sb_txt.setText((String.format("%.2f", temp)));
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                
            }

        });





        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp =  sb.getProgress();
                if(temp>20)
                {
                    tota = tota - (5/100);
                }
                total.setText((String.format("%.2f", tota)));
            }
        });






    }



}