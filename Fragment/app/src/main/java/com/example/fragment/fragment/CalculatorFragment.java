package com.example.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment.R;

public class CalculatorFragment extends Fragment {
    private EditText calculation, result;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_c, btn_ce, btn_del, btn_add, btn_sub, btn_multi, btn_divide, btn_equal;
    String cal_past,res_past, current;
    boolean dot;
    boolean operator, operator_last, done;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        calculation = (EditText) view.findViewById(R.id.calculation);
        result = (EditText) view.findViewById(R.id.cal_result);
        calculation.getText().clear();

        btn_0 = (Button) view.findViewById(R.id.btn_0);
        btn_1 = (Button) view.findViewById(R.id.btn_1);
        btn_2 = (Button) view.findViewById(R.id.btn_2);
        btn_3 = (Button) view.findViewById(R.id.btn_3);
        btn_4 = (Button) view.findViewById(R.id.btn_4);
        btn_5 = (Button) view.findViewById(R.id.btn_5);
        btn_6 = (Button) view.findViewById(R.id.btn_6);
        btn_7 = (Button) view.findViewById(R.id.btn_7);
        btn_8 = (Button) view.findViewById(R.id.btn_8);
        btn_9 = (Button) view.findViewById(R.id.btn_9);
        btn_add = (Button) view.findViewById(R.id.btn_add);
        btn_sub = (Button) view.findViewById(R.id.btn_sub);
        btn_multi = (Button) view.findViewById(R.id.btn_multi);
        btn_divide = (Button) view.findViewById(R.id.btn_divide);
        btn_c = (Button) view.findViewById(R.id.btn_c);
        btn_ce = (Button) view.findViewById(R.id.btn_ce);
        btn_del = (Button) view.findViewById(R.id.btn_del);
        btn_equal = (Button) view.findViewById(R.id.btn_equal);

        cal_past = "";
        res_past = "";
        current = "0";
        dot = false;
        operator = false;
        operator_last = false;
        done = false;

        btn_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "0";
                displayCal();
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "1";
                displayCal();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "2";
                displayCal();
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "3";
                displayCal();
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "4";
                displayCal();
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "5";
                displayCal();
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "6";
                displayCal();
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "7";
                displayCal();
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "8";
                displayCal();
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "9";
                displayCal();
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                actionC();
                displayCal();
                displayPastCal();
            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (operator_last == false) {
                    actionDel();
                    displayCal();
                }
            }
        });
        btn_ce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                current = "0";
                dot = false;
                operator = false;
                operator_last = false;
                displayCal();
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "÷";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("÷");
                displayPastCal();
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "×";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("×");
                displayPastCal();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "+";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("+");
                displayPastCal();
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "-";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("-");
                displayPastCal();
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                delZero();
                if (operator == false) {
                    cal_past = current + "=";
                    res_past = current;
                    current = "0";
                    displayPastRes();
                } else {
                    String operator_text = cal_past.substring(cal_past.length() - 1, cal_past.length());
                    String first_value = cal_past.substring(0, cal_past.length() - 1);
                    switch (operator_text) {
                        case "+" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) + Double.parseDouble(current));

                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) + Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;
                        case "-" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) - Double.parseDouble(current));
                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) - Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;
                        case "×" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) * Double.parseDouble(current));

                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) * Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;
                        case "÷" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) / Double.parseDouble(current));

                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) / Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;

                    }
                    if (current.substring(current.length() - 2, current.length()).equals(".0")) {
                        current = current.substring(0, current.length() - 2);
                    }
                    if (current.equals("-0")) current = "0";
                    if (current.equals("-Infinity")) current = "Infinity";
                    displayCal();
                }
                dot = false;
                displayPastCal();
            }
        });
        return view;
    }
    public void displayCal() {
        delLong();
        result.setText(current);
    }
    public void displayPastRes() {
        result.setText(res_past);
    }
    public void displayPastCal() {
        calculation.setText(cal_past);
    }
    public boolean checkEmpty(String inset_text) {
        if (current.isEmpty()) {
            current = "0";
            current = current + inset_text;
            return true;
        }
        return false;
    }
    public void actionC(){
        current = "0";
        res_past = "";
        cal_past ="";
        dot = false;
        operator = false;
        operator_last = false;
    }
    public void actionDel() {
        if (current != "0") {
            if (current.substring(current.length() - 1, current.length()).equals(".")) {
                dot = false;
            }
            current = current.substring(0, current.length() - 1);
            if (current.isEmpty()) current = "0";
        }
    }
    public void changeOperator (String newOperator){
        cal_past = cal_past.substring(0, cal_past.length() - 1);
        cal_past = cal_past + newOperator;
    }
    public void delZero() {
        if (dot == true) {
            while (current.substring(current.length() - 1, current.length()).equals("0")){
                current = current.substring(0, current.length() - 1);
            }
            if (current.substring(current.length() - 1, current.length()).equals(".")) actionDel();
        }
    }
    public void delLong(){
        int max_length;
        if (current.indexOf(".") == -1) max_length = 10;
        else max_length = 11;
        while (current.length() > max_length) {
            actionDel();
        }
    }
}
