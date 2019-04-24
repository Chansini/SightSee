package com.example.sightsee;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;

public class listplace extends AppCompatActivity {
    ListView listView;
    String result;
    private ArrayList<String> Nameplace = new ArrayList<String>();
    private ArrayList<Integer> photo = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listplace);
        listView = (ListView) findViewById(R.id.listVeiw2);

        getPlace();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("result",result);
                setResult(Activity.RESULT_OK, intent);

            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                 result = data.getStringExtra("ร้านเฟรนชิน คาเฟ่");
            }
        }
    }

    private void getPlace() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyInterface myInterface = retrofit.create(MyInterface.class);
        Call<List<Place>> call = myInterface.getPlace();
        call.enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                List<Place> placeList = response.body();

                String[] places = new String[placeList.size()];
                for (int i = 0; i < placeList.size(); i++) {
                    places[i] = placeList.get(i).getPlaceName();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, places));
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



}

