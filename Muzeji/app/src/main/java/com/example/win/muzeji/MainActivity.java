package com.example.win.muzeji;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Muzej> muzejList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private ContentAdapter contentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        ApiService api = RetrofitClient.getApiService();

        Call<MuzejList> call = api.getJSON();

        call.enqueue(new Callback<MuzejList>() {
            @Override
            public void onResponse(Call<MuzejList> call, Response<MuzejList> response) {
                pDialog.dismiss();
                if(response.isSuccessful()){
                    muzejList = response.body().getMuzeji();
                    recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                    contentAdapter = new ContentAdapter(muzejList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(contentAdapter);

                }
            }

            @Override
            public void onFailure(Call<MuzejList> call, Throwable t) {
                    pDialog.dismiss();
                Toast.makeText(MainActivity.this,"Nesto nije uspjelo.",Toast.LENGTH_LONG).show();
            }
        });
    }
}
