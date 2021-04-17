package com.saifrasel.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class CalculateBmi extends Fragment {

    View view;
    Button fragmentButton;
    TextView bmiText;
    EditText bmiWeight;
    EditText bmiHeight;
    String res;
    ButtonClickNotifyParent buttonClickNotifyParent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calculate_bmi, container, false);
        fragmentButton = (Button)view.findViewById(R.id.calculateBmiBtn);

        bmiWeight = (EditText)view.findViewById(R.id.bmiWeightId);
        bmiHeight = (EditText)view.findViewById(R.id.bmiHeightId);
        fragmentButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {

                            String weight = bmiWeight.getText().toString().trim();
                            String height = bmiHeight.getText().toString().trim();
                            float w = Float.parseFloat(weight);
                            float h = Float.parseFloat(height);
                            float BMI = w / (h * h);
                            String res = checkBmiStatus(BMI);
                            MakeToast(res,String.valueOf(BMI)).show();
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

    private String checkBmiStatus(Float bmi) {
        String temp = "";
        if(bmi>25)
        {
            temp = "Overweight";
        }
        else if(bmi<25)
        {
            temp =  "Not Overweight";
        }
        else
        {
            temp = "";
        }
        return  temp;
    }

    private Toast MakeToast (String data, String status)
    {
        return Toast.makeText(getActivity(),"Your Score is : "+status+",\n"+data ,Toast.LENGTH_SHORT);
    }
}