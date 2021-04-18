package com.saifrasel.myapplication;

import androidx.fragment.app.FragmentActivity;

public interface ButtonClickNotifyParent {
    void onButtonClick(int position);
    void ToastMaker(String data, String status);
}
