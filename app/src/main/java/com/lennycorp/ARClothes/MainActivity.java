package com.lennycorp.ARClothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.btnUnload);
        /*switch (MainUnityActivity.setToColor) {
            case "yellow": v.setBackgroundColor(Color.YELLOW); break;
            case "red": v.setBackgroundColor(Color.RED); break;
            case "blue": v.setBackgroundColor(Color.BLUE); break;
            default: break;
        }*/
    }

    public void onUnityLoad(View v) {
        Intent intent = new Intent(this, MainUnityActivity.class);
        startActivity(intent);
    }

    public void onUnityUnload(View v) {
        if(MainUnityActivity.instance != null)
            MainUnityActivity.instance.finish();
        else showToast("Show Unity First");
    }

    public void showToast(String message) {
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }
}