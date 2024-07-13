package edu.pims.burgerapp;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class VegBurgerFragment extends Fragment {

    public VegBurgerFragment() {
        // Required empty public constructor
    }
    LinearLayout saladLayout, baconLayout, cheeseLayout, PattyLayout;

    CardView addSalad, removeSalad, addCarrotBacon, removeCarrotBacon, addCheese, removeCheese, addPatty, removePatty;

    Button orderButton;
    TextView totalPriceText;
    int bunPrice = 55;

    int saladPrice = 10;
    int carrotBaconPrice = 10;
    int cheesePrice = 20;
    int PattyPrice = 15;

    int totalPrice;


    int saladCount = 0;
    int carrotBaconCount = 0;
    int cheeseCount = 0;
    int PattyCount = 0;

    





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_veg_burger, container, false);



        saladLayout = view.findViewById(R.id.saladLayout);
        baconLayout = view.findViewById(R.id.baconLayout);
        cheeseLayout = view.findViewById(R.id.cheeseLayout);
        PattyLayout = view.findViewById(R.id.pattyLayout);
        addSalad = view.findViewById(R.id.addSalad);
        removeSalad = view.findViewById(R.id.removeSalad);
        addCarrotBacon = view.findViewById(R.id.addBacon);
        removeCarrotBacon = view.findViewById(R.id.removeBacon);
        addCheese = view.findViewById(R.id.addCheese);
        removeCheese = view.findViewById(R.id.removeCheese);
        addPatty = view.findViewById(R.id.addPatty);
        removePatty = view.findViewById(R.id.removePatty);

        totalPriceText = view.findViewById(R.id.totalpriceText);

        orderButton = view.findViewById(R.id.orderBtn);

        addSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saladCount++;
                changeSalad();
            }
        });
        removeSalad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("saladCount", String.valueOf(saladCount));
                saladCount--;
                if (saladCount < 0) {
                    saladCount = 0;
                }
                changeSalad();
            }
        });
        addCarrotBacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carrotBaconCount++;
                changeBacon();
            }
        });
        removeCarrotBacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carrotBaconCount--;
                if (carrotBaconCount < 0) {
                    carrotBaconCount = 0;
                }
                changeBacon();
            }
        });
        addCheese.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cheeseCount++;
                changeCheese();
            }

        });
        removeCheese.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cheeseCount--;
                if (cheeseCount < 0) {
                    cheeseCount = 0;
                }
                changeCheese();
            }

        });
        addPatty.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                PattyCount++;
                changePatty();
            }
        });
        removePatty.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                PattyCount--;
                if (PattyCount < 0) {
                    PattyCount = 0;
                }
                changePatty();
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //TODO  code

            }
        });
        
        
        return  view;
    }


    void changeSalad() {

        saladLayout.removeAllViews();
        for (int i = 0; i < saladCount; i++) {
            ImageView imgView = new ImageView(getActivity());
            imgView.setBackgroundResource(R.drawable.salad_shape);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    20,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, // Width
                    heightInPixels  // Height
            );

            imgView.setLayoutParams(params);
            saladLayout.addView(imgView);


        }

        updateTotalPrice();
    }


    void changeBacon() {
        baconLayout.removeAllViews();
        for (int i = 0; i < carrotBaconCount; i++) {
            ImageView imgView = new ImageView(getActivity());
            imgView.setBackgroundResource(R.drawable.carrot_bacon);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    10,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, // Width
                    heightInPixels  // Height
            );

            int marginInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    10, // Adjust the margin size as needed
                    getResources().getDisplayMetrics()
            );

            params.leftMargin = marginInPixels;
            params.rightMargin = marginInPixels;


            imgView.setLayoutParams(params);
            baconLayout.addView(imgView);


        }

        updateTotalPrice();
    }


    void changeCheese() {
        cheeseLayout.removeAllViews();
        for (int i = 0; i < cheeseCount; i++) {
            ImageView imgView = new ImageView(getActivity());
            imgView.setBackgroundResource(R.drawable.cheese_shape);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    15,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, // Width
                    heightInPixels  // Height
            );

            imgView.setLayoutParams(params);
            cheeseLayout.addView(imgView);

        }

        updateTotalPrice();

    }


    void changePatty() {
        PattyLayout.removeAllViews();
        for (int i = 0; i < PattyCount; i++) {
            ImageView imgView = new ImageView(getActivity());
            imgView.setBackgroundResource(R.drawable.veg_patty);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    35,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, // Width
                    heightInPixels  // Height
            );

            imgView.setLayoutParams(params);
            PattyLayout.addView(imgView);

        }

        updateTotalPrice();
    }

    void updateTotalPrice() {
        totalPrice = bunPrice + (saladCount * saladPrice) + (carrotBaconCount * carrotBaconPrice) + (cheeseCount * cheesePrice) + (PattyCount * PattyPrice);

        totalPriceText.setText(String.valueOf(totalPrice));

    }
}