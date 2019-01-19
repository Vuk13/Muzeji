package com.example.win.muzeji;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MuzejDetailActivity extends AppCompatActivity implements OnMapReadyCallback {
    static final String GOOGLE_API_KEY = "AIzaSyBLEm7rthP1M-tjYOzDABQ3_ReLkY4SlvQ";
    private static final String TAG = "MuzejDetailActivity";
    private ArrayList<Fotografija> fotoList;
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private Integer muzej_id;
    private MapView mapView;
    private GoogleMap gMap;
    private Context context = this;
    double lat,lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muzej_detail);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.map_view, mapFragment).commit();
        mapFragment.getMapAsync(this);

        ImageView back = (ImageView)findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        muzej_id = (Integer)getIntent().getIntExtra("MUZEJ_ID_KEY",-1);


        ApiService api = RetrofitClient.getApiService();
        Call<FotografijaList> call = api.getSlike();

        call.enqueue(new Callback<FotografijaList>() {
            @Override
            public void onResponse(Call<FotografijaList> call, Response<FotografijaList> response) {
                // pDialog.dismiss();
                if(response.isSuccessful()){
                    fotoList = response.body().getFotografije();
                    if(fotoList.isEmpty()){
                        Log.d(TAG, "onResponse: fotoList je prazan");
                    }else{
                        Log.d(TAG, "onResponse: fotoList ima nesto");
                        Log.d(TAG, "onResponse:" + fotoList.get(1).getImage_url());
                    }
                    Log.d(TAG, "onResponse: Muzej ID je "+ muzej_id);
                    mCustomPagerAdapter = new CustomPagerAdapter(MuzejDetailActivity.this,fotoList,muzej_id);
                    mViewPager = (ViewPager) findViewById(R.id.viewPager);
                    mViewPager.setAdapter(mCustomPagerAdapter);
                }
            }

            @Override
            public void onFailure(Call<FotografijaList> call, Throwable t) {
                //pDialog.dismiss();
                Toast.makeText(MuzejDetailActivity.this,"Nesto nije uspjelo.",Toast.LENGTH_LONG).show();
            }
        });


        String naziv =(String) getIntent().getStringExtra("MUZEJ_NAZIV_KEY");
        String telefon=(String) getIntent().getStringExtra("MUZEJ_TELEFON_KEY");
        String email = (String) getIntent().getStringExtra("MUZEJ_EMAIL_KEY");
        String latituda=(String)getIntent().getStringExtra("MUZEJ_LATITUDA_KEY");
        String longituda=(String)getIntent().getStringExtra("MUZEJ_LONGITUDA_KEY");
        String cijena = (String)getIntent().getStringExtra("MUZEJ_CIJENA_KEY");
        double cijenaBr = Double.parseDouble(cijena);
        cijenaBr=cijenaBr/2;
        String cijena2 = Double.toString(cijenaBr);
        String ikonica = (String)getIntent().getStringExtra("MUZEJ_ICON_KEY");
        String ikonica2 = ikonica.replaceAll("\\\\", "");

        TextView naziv_tv = (TextView)findViewById(R.id.nazivTV);
        TextView email_tv = (TextView)findViewById(R.id.email_TV);
        TextView telefon_tv = (TextView)findViewById(R.id.telefonTV);
        TextView cijena_tv = (TextView)findViewById(R.id.cijena_odrasli);
        TextView cijena2_tv = (TextView)findViewById(R.id.cijena_mladi);
        ImageView icon = (ImageView)findViewById(R.id.detailIconImage);
        Log.d(TAG, "onBindViewHolder: "+ikonica2);
        Picasso.get().load(ikonica2).fit().into(icon);



        naziv_tv.setText(naziv);
        email_tv.setText(email);
        telefon_tv.setText(telefon);
        cijena_tv.setText(cijena+"€");
        cijena2_tv.setText(cijena2 +"€");
        setLL(latituda,longituda);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setLL(String latS, String lonS)
    {
        this.lat = Double.parseDouble(latS);
        this.lng = Double.parseDouble(lonS);
    }
    public double getLat(){
        return this.lat;
    }
    public double getLng(){
        return this.lng;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Log.d(TAG, "onMapReady: starts");
        gMap = map;
        double lat = getLat();
        double lng = getLng();
        LatLng loc = new LatLng(lat,lng);
        gMap.addMarker(new MarkerOptions().position(loc).title("LOKACIJA"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
        gMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));

        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

               Intent intent = new Intent(context,MapsActivity.class);
               intent.putExtra("LATITUDA_KEY",getLat());
               intent.putExtra("LONGITUDA_KEY",getLng());
               context.startActivity(intent);
            }
        });
    }


}
