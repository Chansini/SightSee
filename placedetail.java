package com.example.sightsee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class placedetail extends AppCompatActivity {
         TextView tv1;
         TextView output;
         String strpName;
         String  strLocation;
         String strpDetail;
         String strpPhone;
         String strpDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placedetail);

        output = (TextView) findViewById(R.id.detail);

         Intent intent = this.getIntent();
         final String placeName = intent.getStringExtra("id");
         tv1 = (TextView) findViewById(R.id.placeName);
         tv1.setText(placeName);



         final String strJson = "{\"Place_id\":\"20004\"," +
            "\"Place_Name\":\"จันโอชา ติ่มซำ ย่านตาขาว\"," + "\"Place_Details\":\"ร้านอาหาร\"," +
                 "\"Place_phone\":\"0954844348\"," +"\"Place_Date\":\"เปิดทุกวัน\"," +
            "\"Location\":\"15/9-10 ถ.ตรัง-ปะเหลียน ตรัง (มาจากฝั่งตลาดเลยวัดนิกรณ์ไป100 ม. อยู่ฝั่งเดียวกับวัด)\"}";

        try {
            JSONObject  PlaceObject = new JSONObject(strJson);
            strpName = PlaceObject.getString("Place_Name");
            strpDetail = PlaceObject.getString("Place_Details");
            strpPhone = PlaceObject.getString("Place_phone");
            strpDate = PlaceObject.getString("Place_Date");
            strLocation = PlaceObject.getString("Location");
            output.setText(strLocation);
            output.setText(strpName);



        }

        catch (JSONException e) {
            e.printStackTrace();
        }



        output.setText(" "+strpName+" เป็น" +strpDetail+"\n เบอร์โทรศัพท์ : "+strpPhone+"\n "+strpDate+"\n "+ strLocation);

        }



        }
