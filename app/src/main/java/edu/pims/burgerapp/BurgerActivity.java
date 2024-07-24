package edu.pims.burgerapp;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BurgerActivity extends AppCompatActivity {

    RadioButton nonVegButton, vegButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_burger);

        nonVegButton = findViewById(R.id.nonVegRadioBtn);
        vegButton = findViewById(R.id.VegRadioBtn);




        nonVegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                NonVegBurgerFragment nonVegBurgerFragment=new NonVegBurgerFragment();

                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.burgerFrame,nonVegBurgerFragment);
               // transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        vegButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                VegBurgerFragment VegBurgerFragment=new VegBurgerFragment();

                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.burgerFrame,VegBurgerFragment);
                //transaction.addToBackStack(null);
                transaction.commit();

            }
        });



    }


}