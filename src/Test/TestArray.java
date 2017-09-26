import java.util.*;

/*
Имеется массив чисел, получить список вида {число, количество вхождений числа в массив},
список должен быть отсортирован по количеству вхождений, внутри по возрастания числа.
Использовать можно любой алгоритмический язык.
*/
public class TestArray {
    public static void main(String...args) {
        // Создаем массив для теста
        int[] testArray = createTestArray();
        // Ищем количество вхождений
        TreeMap<Integer, Integer> tempMap = createTempMap(testArray);

        // Сортируем по условиям задачи
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>((tempMap.entrySet()));

        list.sort((a1, a2) -> a2.getValue() - a1.getValue());

        // Список готов, выводим тест
        for (Object result : list) {
            System.out.println(result);
        }
    }

    private static int[] createTestArray() {
        Random random = new Random(564);

        int[] result = new int[random.nextInt(100)];

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(result.length);
        }

        return result;
    }

    private static TreeMap<Integer,Integer> createTempMap(int[] testArray) {
        TreeMap<Integer, Integer> tempMap = new TreeMap<>();

        for (int i = 0; i < testArray.length; i++) {
            if (tempMap.containsKey(testArray[i])) {
                tempMap.put(testArray[i], tempMap.get(testArray[i]) + 1);
            } else {
                tempMap.put(testArray[i], 1);
            }
        }

        return tempMap;
    }
}
