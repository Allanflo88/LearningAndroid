package com.allan.colorpicker;

/**
 * Created by allan on 22/02/18.
 */

public class Converter {
    String color;

    public String intToString(int i) {
        if (i != 0) {
            color = "#" + Integer.toHexString(i);

            if (color.length() < 7) {
                String x = color.substring(color.length() - 1);
                color = color.substring(0, color.length() - 1) + "0" + x;
                return color;
            }
            return color;
        }
        return "#000000";
    }
}

