package com.lennycorp.ARClothes;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.company.product.OverrideUnityActivity;

import java.util.ArrayList;

public class MainUnityActivity extends OverrideUnityActivity {

    private ArrayList<EditText> etList;
    String valueFromUnity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        etList = new ArrayList<>(3);
        createUI();
        //setContentView(R.layout.activity_main_unity);
    }

    public static String setToColor = "default";


    @Override
    protected void showMainActivity(String aSetToColor) {
        Intent intent = new Intent(this, MainActivity.class);
        setToColor = aSetToColor;
        startActivity(intent);
    }

    @Override
    protected void displayMeasurement(double measuredVal){
        valueFromUnity = Double.toString(measuredVal);
        Log.d("UNITY MAIN: ", valueFromUnity);
        etList.get(0).setText(valueFromUnity);

    }

    public void createUI() {
        {
            Button myButton = new Button(this);
            myButton.setText("Show Main");
            myButton.setX(10);
            myButton.setY(500);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showMainActivity("");
                    finish();
                }
            });
            getUnityFrameLayout().addView(myButton, 300, 200);
        }

        {
            Button myButton = new Button(this);
            myButton.setText("Reset");
            myButton.setX(320);
            myButton.setY(500);
            myButton.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    UnitySendMessage("AR Session Origin", "ResetARSession", "");
                }
            });
            getUnityFrameLayout().addView(myButton, 300, 200);
        }

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
        }

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

            etList.add(0, viewAll.findViewById(R.id.etA));

            getUnityFrameLayout().addView(viewAll);


            /*Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int height = size.y ;



            LinearLayout panel = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,height,0,0);
            panel.setLayoutParams(params);
            //panel.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            panel.setOrientation(LinearLayout.VERTICAL);
            //panel.setGravity(Gravity.BOTTOM | Gravity.CENTER);
            getUnityFrameLayout().addView(panel);

            LayoutInflater inflateA = getLayoutInflater();
            View viewA = inflateA.inflate(R.layout.measure_layout, null);
            EditText et = (EditText) viewA.findViewById(R.id.etMeasure);
            et.setText("123");

            panel.addView(viewA);

            LayoutInflater inflateB = getLayoutInflater();
            View viewB = inflateB.inflate(R.layout.measure_layout, null);
            EditText etB = (EditText) viewB.findViewById(R.id.etMeasure);
            et.setText("3456");

            panel.addView(viewB);*/

        }
/*
        {
            displayA = new EditText(this);
            displayA.setX(20);
            displayA.setY(750);
            displayA.requestFocus();
            displayA.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            displayA.setHint("Measurement A");
            //myEditText.setText(valueFromUnity);
            getUnityFrameLayout().addView(displayA, 600, 200);
        }*/
    }
}