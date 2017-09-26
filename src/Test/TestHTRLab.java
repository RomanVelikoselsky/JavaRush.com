import java.util.Random;

public class TestHTRLab {
    public static void main(String...args) {
        // Вычисление корня двойки
        System.out.println(getSqrt());

        // Кубик с 7 гранями, тест 25 бросков, побитовый метод.
        for (int i = 0; i < 25; i++) {
            System.out.print(dice() + " ");
        }

        // Можно просто выдавать с шансом 14% семерку, но подозреваю, что это не совсем верно
    }

    private static double getSqrt() {
        int num = 2;
        double t;
        double square = num / 2;

        do {
            t = square;
            square = (t + (num / t)) / 2;
        } while ((t - square) != 0);

        return square;
    }

    // Бросок 7-гранного кубика на основании броска 6-гранного
    private static int dice() {
        String byteDice = "";

        for (int i = 0; i < 3; i++) {
            if (roll(6) <= 3) {
                byteDice += "0";
            } else byteDice += "1";

            if (byteDice.equals("000")) {
                byteDice = "";
                i = -1;
            }
        }

        return Integer.parseInt(byteDice, 2);
    }

    private static int roll(int a) {
        Random random = new Random();
        return 1 + random.nextInt(a);
    }
}
