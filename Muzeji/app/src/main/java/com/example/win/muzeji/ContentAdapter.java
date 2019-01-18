package com.example.win.muzeji;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.CustomViewHolder> implements Serializable {
    private static final String TAG = "ContentAdapter";
    private List<Muzej> muzeji;
    public static int position;

    public ContentAdapter(List<Muzej> muzeji){
        this.muzeji = muzeji;
    }

    @NonNull
    @Override
    public ContentAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return new CustomViewHolder(itemView);
    }
    private void passData(Context context, int position){
        Muzej muzej = muzeji.get(position);
        String email = muzej.getEmail();
        String telefon = muzej.getTelefon();
        String cijena = muzej.getCijena_ulaznice();
        String opis = muzej.getOpis();
        String iconURL = muzej.getIconURL();
        String latituda = muzej.getLatituda();
        String longituda = muzej.getLongituda();


        Intent intent = new Intent(context, MuzejDetailActivity.class);
        intent.putExtra("MUZEJ_ID_KEY",muzej.getId());
        intent.putExtra("MUZEJ_NAZIV_KEY",muzej.getNaziv());
        intent.putExtra("MUZEJ_EMAIL_KEY",email);
        intent.putExtra("MUZEJ_TELEFON_KEY",telefon);
        intent.putExtra("MUZEJ_CIJENA_KEY",cijena);
        intent.putExtra("MUZEJ_OPIS_KEY",opis);
        intent.putExtra("MUZEJ_ICON_KEY",iconURL);
        intent.putExtra("MUZEJ_LATITUDA_KEY",latituda);
        intent.putExtra("MUZEJ_LONGITUDA_KEY",longituda);
        context.startActivity(intent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapter.CustomViewHolder holder, int position) {
        final int pozicija = position;
        Muzej muzej = muzeji.get(position);
        holder.naziv.setText(muzej.getNaziv());
        String ikonica = muzej.getIconURL();
        String ikonica2 = ikonica.replaceAll("\\\\", "");
        Log.d(TAG, "onBindViewHolder: "+ikonica2);
        Picasso.get().load(ikonica2).fit().into(holder.icon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData(v.getContext(),pozicija);
            }
        });

    }

    @Override
    public int getItemCount() {
        return muzeji.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public TextView naziv;
        public ImageView icon;

        public CustomViewHolder(View view){
            super(view);
            naziv = view.findViewById(R.id.nazivTV);
            icon = view.findViewById(R.id.detailIconImage);
        }

    }

}
