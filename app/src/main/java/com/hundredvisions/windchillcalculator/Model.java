package com.hundredvisions.windchillcalculator;

import android.widget.EditText;

/**
 * Created by winikkc on 4/21/2016.
 */
public class Model {
    static int upperWindRange = 109;
    static int lowerWindRange = 4;
    static int upperTempRange = 50;
    static int lowerTempRange = -50;

    public static boolean isEmpty(EditText field) {
        if (field.length() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String checkRange(EditText field, String field_name,
                                    int lower, int upper) {
        String results = "";
        String field_string = field.getText().toString();
        try {
            int data = Integer.parseInt(field_string);
            if (data < lower || data > upper) {
                String error_msg;
                error_msg = field_name + " field is out of range (" +
                lower + "..." + upper + ")!";
                results = error_msg;
            }
        }
        catch (Exception e) {
            return e.getMessage();
        }
        return results;
    }
    public static boolean inRange(int data, int lower, int upper) {
        boolean results = false;
        if (data >= lower && data <= upper) {
            results = true;
        }
        return results;
    }
    public static boolean isValidWind(EditText windfield) {
        int data;
        if (!isEmpty(windfield)) {
            try {
                data = Integer.parseInt(windfield.getText().toString());
                if (inRange(data, lowerWindRange, upperWindRange)) {
                    return true;
                }
                else return false;

            }
            catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
