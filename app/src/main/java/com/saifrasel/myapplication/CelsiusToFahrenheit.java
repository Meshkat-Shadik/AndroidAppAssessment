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


public class CelsiusToFahrenheit extends Fragment {

    View view;
    Button fragmentButton;
    TextView ctoFText;
    EditText ctoFinput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_celsius_to_fahrenheit, container, false);
        fragmentButton = (Button)view.findViewById(R.id.CtoFcalculate);
        ctoFText = (TextView)view.findViewById(R.id.CtoFResult);
        ctoFinput = (EditText) view.findViewById(R.id.CtoFinputText);

        fragmentButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {

                            String celsiusValue = ctoFinput.getText().toString().trim();
                            float c = Float.parseFloat(celsiusValue);
                            float f = ((9*c)/5)+32;

                            ctoFText.setText(String.valueOf(f));

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

//C/5 = (F-32)/9

// F = ((9*C)/5)+32