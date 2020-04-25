package com.example.hellotoastapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.AttributedCharacterIterator;

public class MainActivity extends AppCompatActivity {

    private int count;
    private TextView countTv;
    private Button countUpBtn;
    private Button zeroBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTv = findViewById(R.id.countTv);
        countUpBtn =findViewById(R.id.button_count);
        zeroBtn=findViewById(R.id.button_Zero);
        //para que no se resetee al voltear
        if(savedInstanceState!=null){
            String countString = savedInstanceState.getString("count");
            if(countTv!=null){
                countTv.setText(countString);
                count =Integer.parseInt(countString);

                if (count >= 1 ){
                    zeroBtn.setBackgroundColor(Color.GREEN);
                    countUpBtn.setBackgroundColor(Color.MAGENTA);
                }else {
                    zero();
                }
            }
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //guardando count
        outState.putString("count", countTv.getText().toString());
        super.onSaveInstanceState(outState);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUp(View view) {
        count++;
        if (count >= 1 ){
            zeroBtn.setBackgroundColor(Color.GREEN);
            countUpBtn.setBackgroundColor(Color.MAGENTA);
        }
        if(countTv != null)
            countTv.setText(Integer.toString(count));
        }

    public void makeZero(View view) {
        zero();
    }


    public void zero() {
        count=0;
        zeroBtn.setBackgroundColor(Color.RED);
        countUpBtn.setBackgroundColor(Color.RED);
        if(countTv != null) countTv.setText(Integer.toString(count));
    }
}
