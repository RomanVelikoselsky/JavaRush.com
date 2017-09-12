package TestStrategy;

public class ExceptionHandler extends Exception{
    public static void log(Exception e) {
        Helper.printMessage(e.toString());
    }
}
