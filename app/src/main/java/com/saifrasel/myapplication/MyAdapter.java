package com.saifrasel.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ButtonClickNotifyParent buttonClickNotifyParent;
    private Context mContext;
    private ArrayList<String> mArrData;
    Fragment fragment;

    public MyAdapter(Context context, ArrayList arrData) {
        super();
        mContext = context;
        mArrData = arrData;
        buttonClickNotifyParent = (NextActivity)mContext;
    }

    public int getCount() {
        // return the number of records
        return mArrData.size();
    }

    // getView method is called for each item of ListView
    public View getView(int position, View view, ViewGroup parent) {
        // inflate the layout for each item of listView
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.mybutton, parent, false);


        // get the reference of textView and button
        final Button btnAction = (Button) view.findViewById(R.id.btnAction);

        // Set the title and button name
        btnAction.setText(mArrData.get(position));

        // Click listener of button
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logic goes here
//"Calculate BMI,Fahrenheit to Celsius,Celsius to Fahrenheit"
              //
                String btnName = btnAction.getText().toString().trim();

                if(btnName.toLowerCase().trim().equals(mArrData.get(0).toLowerCase().trim()))
                {
                    //Toast.makeText(mContext,"BMI",Toast.LENGTH_SHORT).show();
                  buttonClickNotifyParent.onButtonClick(0);


                }
                else if(btnName.toLowerCase().trim().equals(mArrData.get(1).toLowerCase().trim()))
                {
                  //  Toast.makeText(mContext,"F to C",Toast.LENGTH_SHORT).show();
                    buttonClickNotifyParent.onButtonClick(1);
                }
                else if(btnName.toLowerCase().trim().equals(mArrData.get(2).toLowerCase().trim()))
                {
                  //  Toast.makeText(mContext,"C to F",Toast.LENGTH_SHORT).show();
                    buttonClickNotifyParent.onButtonClick(2);
                }

            }
        });

        return view;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    class FragmentWork extends AppCompatActivity{
        private void setFragment(Fragment f)
        {
            androidx.fragment.app.FragmentManager fM = getSupportFragmentManager();
            androidx.fragment.app.FragmentTransaction fT = fM.beginTransaction();
            fT.replace(R.id.fragment_container,fragment);
            fT.commit();

        }
    }

}