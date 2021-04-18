package com.saifrasel.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextActivity extends AppCompatActivity implements  ButtonClickNotifyParent{
    private ArrayList<String> mArrData;
    ListView listView;
    Button btn;
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        listView = (ListView) findViewById(R.id.list_view);
        btn = (Button) findViewById(R.id.btnAction);


        mArrData = new ArrayList<String>(Arrays.asList("Calculate BMI,Fahrenheit to Celsius,Celsius to Fahrenheit".split(",")));
;
        // Initialize adapter and set adapter to list view
        mAdapter = new MyAdapter(NextActivity.this, mArrData);
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }


    @Override
    public void onButtonClick(int position) {
        if(position == 0)
        {
            setFragment(new CalculateBmi(NextActivity.this));
        }
        else if(position==1)
        {
            setFragment(new FahrenheitToCelsius());
        }
        else if(position==2)
        {
            setFragment(new CelsiusToFahrenheit());
        }

    }

    @Override
    public void ToastMaker(String data, String status) {
//        Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Your Score is : "+status+",\n"+data ,Toast.LENGTH_SHORT).show();
    }


    private void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();
    }
}


