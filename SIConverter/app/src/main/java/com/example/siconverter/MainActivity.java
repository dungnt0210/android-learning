package com.example.siconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spF, spT;
    EditText textIn;
    Button convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textIn = (EditText)findViewById(R.id.input);
        spF = (Spinner)findViewById(R.id.spFrom);
        spT = (Spinner)findViewById(R.id.spTo);
        convert = (Button) findViewById(R.id.convert);

        String[] lib = {"BIN", "OCT", "DEC", "HEX"};
        ArrayAdapter ad = new ArrayAdapter <String>(this, R.layout.support_simple_spinner_dropdown_item, lib);

        spF.setAdapter(ad);
        spT.setAdapter(ad);

        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = textIn.getText().toString();
                if (spF.getSelectedItem().toString().equals(spT.getSelectedItem().toString())) {
                    convertInput(input);
                } else {
                    switch (spF.getSelectedItem().toString()) {
                        case ("HEX"):
                            int hex = Integer.parseInt(input, 16);
                            input = Integer.toString(hex);
                            break;
                        case ("OCT"):
                            int oct = Integer.parseInt(input, 8);
                            input = Integer.toString(oct);
                            break;
                        case ("BIN"):
                            int bin = Integer.parseInt(input, 2);
                            input = Integer.toString(bin);
                            break;
                    }

                    int change = Integer.parseInt(input);
                    String s = "0";
                    switch (spT.getSelectedItem().toString()) {
                        case ("HEX"):
                            s = Integer.toHexString(change);
                            convertInput(s);
                            break;
                        case ("OCT"):
                            s = Integer.toOctalString(change);
                            convertInput(s);
                            break;
                        case ("BIN"):
                            s = Integer.toBinaryString(change);
                            convertInput(s);
                            break;
                        case ("DEC"):
                            convertInput(input);
                            break;
                    }
                }
            }
        });
    }
    void convertInput(String out){
        TextView result = (TextView)findViewById(R.id.result);
        result.setText(out);
    }
}