package com.example.win.muzeji;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {
    private static final String TAG = "CustomPagerAdapter";
    Context mContext;
    LayoutInflater mLayoutInflater;
    private List<Fotografija> fotografije;
    private Fotografija foto;
    private int muzej_id;
    ApiService api = RetrofitClient.getApiService();
    private List<String> photoURLS = new ArrayList<String>();
    private List<Fotografija> photo = new ArrayList<Fotografija>();
    public CustomPagerAdapter(Context context, List<Fotografija> fotografije, int muzej_id){
        Log.d(TAG, "CustomPagerAdapter: constructor pozvan");
        this.fotografije = fotografije;
        mContext=context;
        this.muzej_id=muzej_id;

        for(int i=0;i<fotografije.size();i++){
            foto = fotografije.get(i);
            if(foto.getMuzej_id()==muzej_id)
            {
                //photoURLS.add(foto.getImage_url());
                photo.add(foto);
            }
        }

    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem: starts");
            mLayoutInflater = LayoutInflater.from(mContext);
            ViewGroup itemView = (ViewGroup) mLayoutInflater.inflate(R.layout.pager_item,container,false);
            ImageView pagerImage = itemView.findViewById(R.id.pagerImage);

                 try {
                     if(position>=3){
                         position = 1;
                     }
                     foto = photo.get(position);
                     Log.d(TAG, "instantiateItem: starts");
                     String fotoURL = foto.getImage_url();
                     Log.d(TAG, "instantiateItem: " + fotoURL);
                     fotoURL = foto.getImage_url();
                     fotoURL = fotoURL.replaceAll("\\\\", "");
                     Picasso.get().load(fotoURL).fit().into(pagerImage);
                     container.addView(itemView);
                 }catch(IndexOutOfBoundsException e){
                    // position=position-(position-1);
                 }
            return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public int getCount() {
        return fotografije.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }
}
