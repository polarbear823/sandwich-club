package com.udacity.sandwichclub.utils;

import java.util.List;

public class StringUtils {
    private static final String SEPARATOR = ", ";
    public static String convertStringListToString(List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(SEPARATOR);
                }
            }
            return sb.toString();
        }
        return "";
    }
}
