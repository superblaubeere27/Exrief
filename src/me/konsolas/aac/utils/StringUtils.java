package me.konsolas.aac.utils;

/**
 * Created by Marco on 31.01.2017.
 */
public class StringUtils {

    public static String toString(String[] strings, int start) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = start; i < strings.length; i++)
            stringBuilder.append(strings[i] + " ");
        return stringBuilder.toString();
    }
}