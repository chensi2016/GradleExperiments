import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
    private LRUCache lruCache;

    @Before
    public void setUp() throws Exception {
        lruCache = new LRUCache(3);
    }

    @Test
    public void get() {
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        assertEquals(4, lruCache.get(4));
        assertEquals(3, lruCache.get(3));
        assertEquals(2, lruCache.get(2));
        assertEquals(-1, lruCache.get(-1));

    }

    @Test
    public void put() {
        lruCache.put(5, 5);
        assertEquals(-1, lruCache.get(1));
        assertEquals(-1, lruCache.get(2));
        assertEquals(-1, lruCache.get(3));
        assertEquals(-1, lruCache.get(4));
        assertEquals(5, lruCache.get(5));


    }
}