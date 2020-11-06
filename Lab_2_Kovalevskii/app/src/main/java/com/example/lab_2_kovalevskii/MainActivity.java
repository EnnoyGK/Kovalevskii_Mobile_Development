package com.example.lab_2_kovalevskii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.open_form_btn);
        final TextView tView = (TextView) findViewById(R.id.view_value);
        final EditText edText = (EditText) findViewById(R.id.enter_value);

        Intent secondActivityIntent = getIntent();
        if( secondActivityIntent.getStringExtra("result") != null){
            tView.setText(secondActivityIntent.getStringExtra("result"));
        }


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String value = "";
                if(edText.getText().toString().equals("")){
                    value = "0";
                } else {
                    value = edText.getText().toString();
                }
                int valToSend = Integer.parseInt(tView.getText().toString()) + Integer.parseInt(value);
                Intent toSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                toSecondActivityIntent.putExtra("message", Integer.toString(valToSend));
                startActivity(toSecondActivityIntent);
            }
        });
    }

}