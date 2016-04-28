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
}