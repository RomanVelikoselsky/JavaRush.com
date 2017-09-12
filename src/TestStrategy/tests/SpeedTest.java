package TestStrategy.tests;

import TestStrategy.Helper;
import TestStrategy.Shortener;
import TestStrategy.strategy.HashBiMapStorageStrategy;
import TestStrategy.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long time = new Date().getTime();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        return new Date().getTime() - time;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long time = new Date().getTime();
        for (Long longs : ids) {
            strings.add(shortener.getString(longs));
        }
        return new Date().getTime() - time;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();

        for (long i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long timeForShortener1 = getTimeForGettingIds(shortener1, origStrings, ids);
        long timeForShortener2 = getTimeForGettingIds(shortener2, origStrings, ids);

        Assert.assertTrue(timeForShortener1 > timeForShortener2);

        timeForShortener1 = getTimeForGettingStrings(shortener1, ids, origStrings);
        timeForShortener2 = getTimeForGettingStrings(shortener2, ids, origStrings);

        Assert.assertEquals(timeForShortener1, timeForShortener2, 300);
    }
}
