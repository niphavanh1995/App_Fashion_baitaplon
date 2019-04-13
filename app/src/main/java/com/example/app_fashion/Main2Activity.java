package com.example.app_fashion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    private ImageView anhchinhInfor,anh1Infor,anh2Infor,anh3Infor;
    private TextView NDInfor,ND1Infor,ND2Infor,ND3Infor;
    public static String DOMAIN_anh="http://android-review-food.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhxa();

        Intent i = this.getIntent();
        String anh = i.getStringExtra("anhChinh");
        String ten = i.getStringExtra("tenTin");
        String mt1 = i.getStringExtra("moTa1");
        String a1 = i.getStringExtra("anh1");
        String mt2 = i.getStringExtra("moTa2");
        String a2 = i.getStringExtra("anh2");
        String mt3 = i.getStringExtra("moTa3");
        String a3 = i.getStringExtra("anh3");


        Picasso.with(this).load(DOMAIN_anh+anh).into(anhchinhInfor);
        NDInfor.setText(ten);
//        Format fmm = new SimpleDateFormat("yyyy-MM-dd");
//        TimeInfor.setText(fmm.format(ngay));
        Picasso.with(this).load(DOMAIN_anh+a1).into(anh1Infor);
        ND1Infor.setText(mt1);
        Picasso.with(this).load(DOMAIN_anh+a2).into(anh2Infor);
        ND2Infor.setText(mt2);
        Picasso.with(this).load(DOMAIN_anh+a3).into(anh3Infor);
        ND3Infor.setText(mt3);


    }
    private void anhxa() {
        anhchinhInfor= findViewById(R.id.imgInfor);
        NDInfor=findViewById(R.id.tenInfor);
        anh1Infor=findViewById(R.id.anh1Infor);
        ND1Infor=findViewById(R.id.noidung1infor);

        anh2Infor=findViewById(R.id.anh2Infor);
        ND2Infor=findViewById(R.id.noidung2Infor);

        anh3Infor=findViewById(R.id.anh3Infor);
        ND3Infor=findViewById(R.id.noidung3Infor);

    }
}
