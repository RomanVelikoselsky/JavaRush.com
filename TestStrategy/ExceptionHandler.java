package com.javarush.task.task33.task3310;

public class ExceptionHandler extends Exception{
    public static void log(Exception e) {
        Helper.printMessage(e.toString());
    }
}
