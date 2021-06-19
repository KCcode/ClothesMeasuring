package com.lennycorp.ARClothes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.company.product.OverrideUnityActivity;

public class MainUnityActivity extends OverrideUnityActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addControlsToUnityFrame();
        //setContentView(R.layout.activity_main_unity);
    }

    public static String setToColor = "default";
    @Override
    protected void showMainActivity(String aSetToColor) {
        Intent intent = new Intent(this, MainActivity.class);
        setToColor = aSetToColor;
        startActivity(intent);
    }

    public void addControlsToUnityFrame() {
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
            myButton.setText("Send Msg");
            myButton.setX(320);
            myButton.setY(500);
            myButton.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    UnitySendMessage("Cube", "ChangeColor", "yellow");
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
    }
}