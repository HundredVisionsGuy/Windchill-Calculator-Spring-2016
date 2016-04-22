package com.hundredvisions.windchillcalculator;

import android.widget.EditText;

/**
 * Created by winikkc on 4/21/2016.
 */
public class Model {
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
}
