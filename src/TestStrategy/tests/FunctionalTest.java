package TestStrategy.tests;

import TestStrategy.Helper;
import TestStrategy.Shortener;
import TestStrategy.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String string1 = Helper.generateRandomString();
        String string2 = Helper.generateRandomString();
        String string3 = string1;

        long id1 = shortener.getId(string1);
        long id2 = shortener.getId(string2);
        long id3 = shortener.getId(string3);

        Assert.assertNotEquals(id2, id1);
        Assert.assertEquals(id1, id3);

        String newString1 = shortener.getString(id1);
        Assert.assertEquals(string1, newString1);

        String newString2 = shortener.getString(id2);
        Assert.assertEquals(string2, newString2);

        String newString3 = shortener.getString(id3);
        Assert.assertEquals(string3, newString3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
