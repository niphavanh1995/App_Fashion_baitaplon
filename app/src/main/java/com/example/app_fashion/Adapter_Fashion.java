package com.example.app_fashion;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

public class Adapter_Fashion extends RecyclerView.Adapter<Adapter_Fashion.MyHolder> {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<Fashion> listFa;

//    public static String DOMAIN_anh="https://android-review-food.000webhostapp.com/";


    public Adapter_Fashion(Context context, List<Fashion> listFa) {
        this.context = context;
        this.listFa = listFa;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.lish_item_fashion,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Fashion fashion = listFa.get(i);

        if (!TextUtils.isEmpty(fashion.getAnh_Interface())) {
            String imgUrl = Api.getURLImage() + fashion.getAnh_Interface();
            Api.getPicaso(context).load(imgUrl).resize(350,350).into(myHolder.anhchinh);
            Log.e("True ","Co anh "+ fashion.getAnh_Interface());
        } else {
            Log.e("Err anh", "Khong co anh");
        }


        myHolder.tvTenTin.setText(fashion.getTenTin_Interface());
        myHolder.tvMoTa.setText(fashion.getMoTaMain());


    }

    @Override
    public int getItemCount() {
        return listFa.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView anhchinh,anh1,anh2,anh3;
        TextView tvTenTin,tvNd1,tvNd2,tvNd3;
        TextView tvMoTa;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            anhchinh=itemView.findViewById(R.id.ivAnh);
            tvTenTin=itemView.findViewById(R.id.tvTen);
            tvMoTa=itemView.findViewById(R.id.tvmoTaChinh);
            anh1=itemView.findViewById(R.id.tvanh1);
            tvNd1=itemView.findViewById(R.id.tvMoTa1);
            anh2=itemView.findViewById(R.id.tvanh2);
            tvNd2=itemView.findViewById(R.id.tvMoTa2);
            anh3=itemView.findViewById(R.id.tvanh3);
            tvNd3=itemView.findViewById(R.id.tvMoTa3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText(ct,"a",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, Main2Activity.class);
                    // Gui du lieu
                    int vitri = getAdapterPosition();
                    i.putExtra("anhChinh",listFa.get(vitri).getAnh_Interface());
                    i.putExtra("tenTin",listFa.get(vitri).getTenTin_Interface());
                    i.putExtra("anh1",listFa.get(vitri).getAnh1());
                    i.putExtra("moTa1",listFa.get(vitri).getNoiDung1());
                    i.putExtra("anh2",listFa.get(vitri).getAnh2());
                    i.putExtra("moTa2",listFa.get(vitri).getNoiDung2());
                    i.putExtra("anh3",listFa.get(vitri).getAnh3());
                    i.putExtra("moTa3",listFa.get(vitri).getNoiDung3());
                    context.startActivity(i);
                }
            });



        }
    }
}
