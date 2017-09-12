package TestStrategy;

import TestStrategy.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String...args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    // Получаем идентификаторы
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();

        for (String s : strings) {
            ids.add(shortener.getId(s));
        }

        return ids;
    }

    // Получаем строки
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();

        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }

        return strings;
    }

    // Тестируем работу переданной стратегии на определенном количестве элементов
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage("Стратегия: " + strategy.getClass().getSimpleName());

        HashSet<String> stringHashSet = new HashSet<>();

        for (long i = 0; i < elementsNumber; i++) {
            stringHashSet.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        long dateStartIds = new Date().getTime();
        Set<Long> testIds = getIds(shortener, stringHashSet);
        long dateEndIds = new Date().getTime();
        long timeIds = dateEndIds - dateStartIds;

        Helper.printMessage("Время обработки множества Id: " + String.valueOf(timeIds));

        long dateStartStrings = new Date().getTime();
        Set<String> testStrings = getStrings(shortener, testIds);
        long dateEndStrings = new Date().getTime();
        long timeStrings = dateEndStrings - dateStartStrings;

        Helper.printMessage("Время обработки множества строк: " + String.valueOf(timeStrings));

        if (stringHashSet.containsAll(testStrings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
