package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    // Получаем случайную строку
    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    // Вывод в консоль
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
