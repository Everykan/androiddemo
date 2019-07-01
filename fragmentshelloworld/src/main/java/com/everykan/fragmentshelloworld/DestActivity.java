package com.everykan.fragmentshelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;

import com.everykan.fragmentshelloworld.fragments.AFragment;
import com.everykan.fragmentshelloworld.fragments.BFragment;
import com.everykan.fragmentshelloworld.fragments.CFragment;

public class DestActivity extends AppCompatActivity implements ComunicaMenu{

    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);

        fragments = new Fragment[3];

        fragments[0] = new AFragment();
        fragments[1] = new BFragment();
        fragments[2] = new CFragment();

        Bundle extras = getIntent().getExtras();





    }

    @Override
    public void menu(int botonPulsado) {


    }
}
