import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {
    WordSearch wordSearch = new WordSearch();
    char[][] board = {{'a','a'}};
    String word = "aaa";

    @Test
    public void exist() {
        assertFalse(wordSearch.exist(board,word));
    }
}