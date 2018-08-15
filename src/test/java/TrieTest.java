import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    Trie trie = new Trie();

    @Test
    public void insert() {
        trie.insert("apple");
    }

    @Test
    public void search() {
        trie.insert("apple");
        boolean result = trie.search("apple");
        assertTrue(result);

    }

    @Test
    public void startsWith() {
        trie.insert("apple");
        boolean result = trie.startsWith("apple");
        assertTrue(result);
    }
}