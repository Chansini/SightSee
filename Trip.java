package com.example.sightsee;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class Trip extends AppCompatActivity {

    private ArrayList<String> Nameplace = new ArrayList<String>();
    private ArrayList<Integer> photo = new ArrayList<Integer>();
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        FloatingActionButton btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trip.this, listplace.class);
               startActivityForResult(intent,1);
                String message = intent.getStringExtra("result");

            //    setDataListView();
            //    Nameplace.add(message);
           //     photo.add(R.drawable.friendship);


            }
        });

        Intent i = this.getIntent();
        final String message = i.getStringExtra("message");
        TextView tv1 = (TextView) findViewById(R.id.textView);
        tv1.setText(message);


         adapter = new CustomAdapter(getApplicationContext(), Nameplace, photo);
        ListView listView = (ListView) findViewById(R.id.listVeiw1);
        setDataListView();
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


              TextView text = (TextView) view.findViewById(R.id.textView1);
              final String placeName = text.getText().toString();
              String placeId = Integer.toString(position + 1);

                //   Toast.makeText(getApplicationContext(), cartoon, Toast.LENGTH_SHORT).show();
             //   Intent intent = new Intent(Trip.this, placedetail.class);
              //  intent.putExtra("placeName", placeName);
               // intent.putExtra("placeId", placeId);
             //   startActivity(intent);


    AlertDialog.Builder builder =
            new AlertDialog.Builder(Trip.this);
                builder.setMessage("คุณต้องการทำอะไร?")
                   // .setIcon(R.drawable.)
// set three option buttons
                    .setPositiveButton("ลบ",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
// actions serving "YES" button go here
                                    Nameplace.remove(position);
                                    photo.remove(position);
                                    adapter.notifyDataSetChanged();
                                }
                            })// setPositiveButton
                    .setNeutralButton("ดูรายละเอียด",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
// actions serving "CANCEL" button go here
                                    Intent intent = new Intent(Trip.this, placedetail.class);
                                    String id = Nameplace.get(position);
                                   intent.putExtra("id",id);
                                       startActivity(intent);
                                }// OnClick
                            })// setNeutralButton
                  //  .setNegativeButton("แก้ไข", new DialogInterface.OnClickListener() {
                 //       public void onClick(DialogInterface dialog, int whichButton) {
// actions serving "NO" button go here
                  //          Intent intent = new Intent(Trip.this, listplace.class);
                   //         startActivity(intent);
                    //    }
                  //  })
                    .create()
                    .show();
        }// showMyAlertDialog

    });
}
    private void setDataListView() {
        Nameplace.add("จันทร์โอชา ติ่มซำคำโต");
        Nameplace.add("สวนพฤษศาสตร์ทุ่งค่าย");
        Nameplace.add("บะหมี่เกี๊ยวโกวอน");
        Nameplace.add("ท่าใคล้ ซีฟู้ด");

        photo.add(R.drawable.janocha);
        photo.add(R.drawable.tungkai);
        photo.add(R.drawable.kowon);
        photo.add(R.drawable.takai);


       // Intent intent = new Intent(Trip.this, Trip.class);
      //  startActivityForResult(intent,1);
       // String message = intent.getStringExtra("result");



    }


}


