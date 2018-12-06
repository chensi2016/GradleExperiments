import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesTest {
    UniqueBinarySearchTreesRewrite uniqueBinarySearchTrees = new UniqueBinarySearchTreesRewrite();
    @Test
    public void generateTrees() {
        assertEquals(5, uniqueBinarySearchTrees.generateTrees(3).size());
    }
}