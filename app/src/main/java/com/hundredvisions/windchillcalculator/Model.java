package com.hundredvisions.windchillcalculator;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by winikkc on 4/21/2016.
 */
public class Model {
    private static int lowerTempRange = -50;
    private static int upperTempRange = 50;
    private static int lowerWindRange =  4;
    private static int upperWindRange = 109;

    /* Form Validation Methods */
    public static boolean isEmpty(EditText field) {
        if (field.length() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isInRange(int data, int lower, int upper) {
        if (data >= lower && data <= upper) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isWindValid(EditText field) {
        if(isEmpty(field)) {
            field.setError("You must enter a number");
            return false;
        }
        else {
            try {
                int data = Integer.parseInt(field.getText().toString());
                if (isInRange(data, lowerWindRange, upperWindRange)) {
                    return true;
                }
                else {
                    field.setError("Wind must be between " + lowerWindRange +
                    " & " + upperWindRange + ".");
                    return false;
                }
            }
            catch (Exception e) {
                field.setError("You must enter a number (not character)");
                return false;
            }
        }
    }
    public static boolean isTempValid(EditText field) {
        if (isEmpty(field)) {
            field.setError("You must enter a number");
            return false;
        }
        else {
            // try to parse the field to an integer
            try {
                int data = Integer.parseInt(field.getText().toString());
                // Check to make sure it's in range
                if (isInRange(data, lowerTempRange, upperTempRange)) {
                    return true;
                }
                else {
                    field.setError("Temp must be between " + lowerTempRange +
                    " & " + upperTempRange + ".");
                    return false;
                }
            }
            catch (Exception e) {
                field.setError("Entry must be a number (not character)");
                return false;
            }
        }
    }

    // Calculate Windchill
    public static String calculateWindChill(EditText editWind, EditText editTemp) {
        String results = "Results: ";
        if (isWindValid(editWind) && isTempValid(editTemp)) {
            double wind = Double.parseDouble(editWind.getText().toString());
            int temp = Integer.parseInt(editTemp.getText().toString());
            // Formula: 35.74 + 0.6215 * temp - 35.75 * (wind^0.16) + 0.4275 * temp * (wind^0.16)
            double windchill = 35.74 + 0.6215 * temp - 35.75 * Math.pow(wind,0.16) +
                    0.4275 * temp * Math.pow(wind, 0.16);
            results += "with a temperature of " + temp + " and a windspeed of " + (int) wind +
                    ", it feels like " + Math.round(windchill) + " degrees.";
        }
        else {
            results += "there was a problem with your inputs.";
        }
        return results;
    }
}