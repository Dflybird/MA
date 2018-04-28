package com.example.gq.ma.utils;

import android.util.Log;

import java.util.List;

public class GLog {

    private static final char TOP_LEFT_CORNER = '┌';
    private static final char BOTTOM_LEFT_CORNER = '└';
    private static final char MIDDLE_CORNER = '├';
    private static final String HORIZONTAL_LINE = "│  ";
    private static final String DOUBLE_DIVIDER = "───────────────────────────────────────────────────────────";
    private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER;

    private static boolean debug = true;
    private static String mTag = "TAG";

    public static void d(String msg){
        if (debug){

            Log.d(mTag, printor(msg));
        }
    }

    public static void d(String tag, String[] values){
        if (debug){
            StringBuilder sb = new StringBuilder(tag);
            for (String s: values) {
                sb.append("\n");
                sb.append(s);
            }
            Log.d(mTag, printor(sb.toString()));
        }
    }

    public static void d(String tag, String msg){
        if (debug){

            Log.d(tag, printor(msg));
        }
    }

    private static String printor(String msg){
        String str = " \n" +
                TOP_BORDER +
                "\n" +
                HORIZONTAL_LINE + getStackTraceElement() +
                "\n" +
                MIDDLE_BORDER +
                "\n" +
                HORIZONTAL_LINE + msg +
                "\n" +
                BOTTOM_BORDER;
        return str;
    }

    private static StackTraceElement getStackTraceElement(){
        boolean shouldTrace = false;
        StackTraceElement[] stackTrace= Thread.currentThread().getStackTrace();
        for (StackTraceElement s: stackTrace) {
            boolean isLogMethod = s.getClassName().equals(GLog.class.getName());
            if (shouldTrace && !isLogMethod)
                return s;
            shouldTrace = isLogMethod;
        }
        return null;
    }
}
