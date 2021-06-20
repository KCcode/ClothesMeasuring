package com.lennycorp.ARClothes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.company.product.OverrideUnityActivity;


public class MainUnityActivity extends OverrideUnityActivity {

    private EditText[] etList;
    private int focusOn;
    private String valFromUnity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        etList = new EditText[3];
        focusOn = 0;
        createUI();
    }

    @Override
    protected void showMainActivity(String aSetToColor) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void displayMeasurement(double measuredVal){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                valFromUnity = Double.toString(measuredVal);
                Log.d("UNITY MAIN: ", valFromUnity);

                etList[0].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            focusOn = 0;
                        }
                    }
                });

                etList[1].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            focusOn = 1;
                        }
                    }
                });

                etList[2].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            focusOn = 2;
                        }
                    }
                });
                etList[focusOn].setText(valFromUnity);
            }
        });

        /*

        valueFromUnity = Double.toString(measuredVal);
        Log.d("UNITY MAIN: ", valueFromUnity);

        etList.get(0).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    val = 0;
                }
            }
        });

        etList.get(1).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    val = 1;
                }
            }
        });

        etList.get(2).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    val = 2;
                }
            }
        });
        etList.get(val).setText(valueFromUnity);*/
    }

    public void createUI() {
        {
            LayoutInflater allUI = getLayoutInflater();
            View viewAll = allUI.inflate(R.layout.ar_ui, null);

            ImageButton backBtn = viewAll.findViewById(R.id.btnBack);
            backBtn.setOnClickListener((v) -> {
                showMainActivity("");
                finish();
            });

            Button resetBtn = viewAll.findViewById(R.id.btnReset);
            resetBtn.setOnClickListener((v) -> {
                UnitySendMessage("AR Session Origin", "ResetARSession", "");
            });

            etList[0] = viewAll.findViewById(R.id.etA);
            etList[1] = viewAll.findViewById(R.id.etB);
            etList[2] = viewAll.findViewById(R.id.etC);
            getUnityFrameLayout().addView(viewAll);

            Button ABtn = viewAll.findViewById(R.id.btnA);
            ABtn.setOnClickListener((v)->{
                etList[0].getText().clear();
            });

            Button BBtn = viewAll.findViewById(R.id.btnB);
            BBtn.setOnClickListener((v)->{
                etList[1].getText().clear();
            });

            Button CBtn = viewAll.findViewById(R.id.btnC);
            CBtn.setOnClickListener((v)->{
                etList[2].getText().clear();
            });
        }

        /*
        {
            Button myButton = new Button(this);
            myButton.setText("Unload");
            myButton.setX(630);
            myButton.setY(500);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });
            getUnityFrameLayout().addView(myButton, 300, 200);
        }*/
    }
}