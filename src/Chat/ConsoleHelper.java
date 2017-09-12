package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by v.roman on 12.07.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        String result = "";
        int flag = 0;
        while (flag == 0) {
            try {
                result = bufferedReader.readLine();
                flag = 1;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return result;
    }

    public static int readInt() {
        int flag = 0;
        int result = 0;
        while (flag == 0) {
            try {
                result = Integer.parseInt(readString());
                flag = 1;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return result;
    }
    public static void writeMessage(String message) {
        System.out.println(message);
    }
}
