package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView result;
    int num1 , num2 ;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.textViewResult);
    }

    //setText() - פונקציה שדורסת את הקיים
    //append() - פונקציה שמשרשרת לקיים
    //getText() - שולף את המידע שקיים על הפקד

    public void buttonClickFunction(View view)
    {
        if (view instanceof Button)
        {
            Button button = (Button) view;
            String str = button.getText().toString();
            result.append(str);
        }
    }

    public void buttonClearFunction(View view)
    {
        result.setText("");
    }

    public void buttonOperatorFunction(View view)
    {
        if (view instanceof Button)
        {
            Button button = (Button) view;
            num1 = Integer.parseInt(result.getText().toString());
            operator = button.getText().toString().charAt(0);
            result.setText("");
        }
    }

    public void buttonEqualFunction(View view)
    {
        double res = 0.0;
        if (view instanceof Button)
        {
            num2 = Integer.parseInt(result.getText().toString());
            switch(operator)
            {
                case 'X':
                    res = num1 * num2;
                    break;

                case '/':
                    if (num2 != 0)
                        res = (double)num1 / num2;
                    else
                    {
                        result.setText("Error - It is not possible to divide by 0");
                        return;
                    }
                    break;

                case '+':
                    res = num1 + num2;
                    break;

                case '-':
                    res = num1 - num2;
                    break;
            }
            result.setText(String.valueOf(res));
        }
    }
}