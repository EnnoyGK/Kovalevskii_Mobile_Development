package com.example.lab_2_kovalevskii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.open_form_btn);
        final TextView textView = (TextView) findViewById(R.id.view_value);
        final EditText edText = (EditText) findViewById(R.id.enter_value);

        Intent mainActivityIntent = getIntent();
        textView.setText(mainActivityIntent.getStringExtra("message"));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = "";
                if(edText.getText().toString().equals("")){
                    value = "0";
                } else {
                    value = edText.getText().toString();
                }
                int valToSend = Integer.parseInt(textView.getText().toString()) + Integer.parseInt(value);

                Intent toMainActivityIntent = new Intent(SecondActivity.this, MainActivity.class);
                toMainActivityIntent.putExtra("result", Integer.toString(valToSend));
                startActivity(toMainActivityIntent);
            }
        });
    }
}