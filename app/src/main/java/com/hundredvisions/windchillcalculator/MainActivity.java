package com.hundredvisions.windchillcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare our UI components
    EditText edit_temp, edit_wind;
    Button button_get_windchill;
    TextView text_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // "Connect" UI components to their counterparts in content_main
        edit_temp = (EditText) findViewById(R.id.edit_temp);
        edit_wind = (EditText) findViewById(R.id.edit_wind);
        button_get_windchill = (Button) findViewById(R.id.button_get_windchill);
        text_results = (TextView) findViewById(R.id.text_results);

        button_get_windchill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String results = "Results: ";
                int temp = 0;

                // Check temperature range
                try {
                    temp = Integer.parseInt(edit_temp.getText().toString());
                }
                catch (Exception ex) {  }
                if (edit_temp.getText().length() == 0) {
                    edit_temp.setError("Enter a #");
                    results += "Oops! Something is missing.";
                }
                else if (temp < -50 || temp > 50) {
                    edit_temp.setError("Out of range");
                    results += "Temperature range needs to be between -50 " +
                            "and 50 degrees fahrenheit.";
                }
                else {
                    results += "\nTemperature: " + edit_temp.getText() + "\n";
                }
                text_results.setText(results);
            }
        });
    }
}
