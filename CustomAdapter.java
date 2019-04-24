package com.example.sightsee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
   private LayoutInflater mInflater;
    ArrayList<String> Nameplace;
    ArrayList<Integer> photo;

    public CustomAdapter(Context context, ArrayList<String> Nameplace, ArrayList<Integer> photo) {
        super();
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.Nameplace = Nameplace;
        this.photo = photo;
    }




    @Override
    public int getCount() {
        return Nameplace.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View row = mInflater.inflate(R.layout.listview_row, parent, false);

        TextView textView = (TextView)row.findViewById(R.id.textView1);
        textView.setText(Nameplace.get(position));
        ImageView imageView = (ImageView)row.findViewById(R.id.imageView1);
        imageView.setBackgroundResource(photo.get(position));

        return row;

    }
}
