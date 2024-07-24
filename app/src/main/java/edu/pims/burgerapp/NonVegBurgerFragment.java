package edu.pims.burgerapp;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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

public class NonVegBurgerFragment extends Fragment {

    public NonVegBurgerFragment() {
        // Required empty public constructor
    }
//initial commit

    LinearLayout saladLayout, baconLayout, cheeseLayout, meatLayout;

    CardView addSalad, removeSalad, addBacon, removeBacon, addCheese, removeCheese, addMeat, removeMeat;

    Button orderButton;
    TextView totalPriceText;
    int bunPrice = 55;

    int saladPrice = 10;
    int baconPrice = 15;
    int cheesePrice = 20;
    int meatPrice = 25;

    int totalPrice;


    int saladCount = 0;
    int baconCount = 0;
    int cheeseCount = 0;
    int meatCount = 0;
    AlertDialog alert;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_non_veg_burger, container, false);
        saladLayout = view.findViewById(R.id.saladLayout);
        baconLayout = view.findViewById(R.id.baconLayout);
        cheeseLayout = view.findViewById(R.id.cheeseLayout);
        meatLayout = view.findViewById(R.id.meatLayout);
        addSalad = view.findViewById(R.id.addSalad);
        removeSalad = view.findViewById(R.id.removeSalad);
        addBacon = view.findViewById(R.id.addBacon);
        removeBacon = view.findViewById(R.id.removeBacon);
        addCheese = view.findViewById(R.id.addCheese);
        removeCheese = view.findViewById(R.id.removeCheese);
        addMeat = view.findViewById(R.id.addMeat);
        removeMeat = view.findViewById(R.id.removeMeat);

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
        addBacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baconCount++;
                changeBacon();
            }
        });
        removeBacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baconCount--;
                if (baconCount < 0) {
                    baconCount = 0;
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
        addMeat.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                meatCount++;
                changeMeat();
            }
        });
        removeMeat.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                meatCount--;
                if (meatCount < 0) {
                    meatCount = 0;
                }
                changeMeat();
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO

                showDialog();
                //we will do custom dialog.

            }
        });

        return view;
    }


    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirm Order");
        builder.setCancelable(false);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =  inflater.inflate(R.layout.non_veg_order_dialog, null);
        builder.setView(view);

        TextView saladCountText = view.findViewById(R.id.saladQuantity);

        TextView baconCountText = view.findViewById(R.id.baconQuantity);
        TextView cheeseCountText = view.findViewById(R.id.cheeseQuantity);
        TextView meatCountText = view.findViewById(R.id.meatQuantity);

        Button confirmBtn = view.findViewById(R.id.Confirm);

        saladCountText.setText(saladCount+"");
        baconCountText.setText(baconCount+"");
        cheeseCountText.setText(cheeseCount+"");
        meatCountText.setText(meatCount+"");

        TextView totalPriceTextSalad = view.findViewById(R.id.saladTotalPrice);
        totalPriceTextSalad.setText(saladCount*saladPrice +"");
        TextView totalPriceTextBacon = view.findViewById(R.id.baconTotalPrice);




        totalPriceTextBacon.setText(baconCount*baconPrice +"");


        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog.dismiss();
                alert.dismiss();

            }
        });


        alert = builder.create();

        alert.show();



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
        for (int i = 0; i < baconCount; i++) {
            ImageView imgView = new ImageView(getActivity());
            imgView.setBackgroundResource(R.drawable.bacon_shape);
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


    void changeMeat() {
        meatLayout.removeAllViews();
        for (int i = 0; i < meatCount; i++) {
            ImageView imgView = new ImageView(getActivity());
            imgView.setBackgroundResource(R.drawable.meat_shape);
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
            meatLayout.addView(imgView);

        }

        updateTotalPrice();
    }

    void updateTotalPrice() {
        totalPrice = bunPrice + (saladCount * saladPrice) + (baconCount * baconPrice) + (cheeseCount * cheesePrice) + (meatCount * meatPrice);

        totalPriceText.setText(String.valueOf(totalPrice));

    }


}