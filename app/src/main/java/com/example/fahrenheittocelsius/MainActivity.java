package com.example.fahrenheittocelsius;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    //Referencing the buttons and text views
    private Button celsiusButton;
    private TextView resultId;
    private EditText fahrenEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* finding the buttons and text views in activity_main.xml and programming and referencing them in
        MainActivity.java
         */

        celsiusButton = (Button) findViewById(R.id.celsiusButton);
        resultId = (TextView) findViewById(R.id.resultId);
        fahrenEditText = (EditText) findViewById(R.id.FahrenEditText);

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Conversion formula from fahrenheit to celsius
                //(32°F − 32) × 5/9 = 0°C
                double subtraction = 32.00d;
                double fraction = 0.55d;
                int result = 0;

                ////If statement to prevent app from crashing if user enters no numbers(Degrees)

                if(celsiusButton.getText().toString().equals("")) {
                    /* If no number was entered a red error message
                    will display indicating no number was entered
                     */
                    resultId.setText(R.string.error_message);
                    resultId.setTextColor(Color.RED);
                }else{
                    // Else if a number was entered the inches conversion result will display in dark grey
                    double celsiusValue = Double.parseDouble(fahrenEditText.getText().toString());
                    result = (int) ((celsiusValue-subtraction)*(fraction));
                    resultId.setText(String.format(String.valueOf(result))+ " Degrees");

                }






            }
        });
    }
}
