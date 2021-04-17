package com.saifrasel.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FahrenheitToCelsius extends Fragment {
    View view;
    Button calculateButton;
    TextView FtoCText;
    EditText FtoCinput;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fahrenheit_to_celsius, container, false);
        calculateButton = (Button)view.findViewById(R.id.FtoCcalculate);
        FtoCText = (TextView)view.findViewById(R.id.FtoCResult);
        FtoCinput = (EditText) view.findViewById(R.id.FtoCinputText);

        calculateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {

                            String fahrenheitValue = FtoCinput.getText().toString().trim();
                            float f = Float.parseFloat(fahrenheitValue);
                            float c = (5*(f-32))/9;

                            FtoCText.setText(String.valueOf(c));

                        }
                        catch (Exception e)
                        {
                            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        return view;
    }
}