import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GroupAnagramsTest {
    GroupAnagrams groupAnagrams = new GroupAnagrams();
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    List<String> result1 = Arrays.asList("ate","eat","tea");
    List<String> result2 = Arrays.asList("nat","tan");
    List<String> result3 = Arrays.asList("bat");
    List<List<String>> expected = Arrays.asList(result1, result2, result3);

    @Test
    public void groupAnagrams() {
        assertThat(groupAnagrams.groupAnagrams(strs), is(expected));
        return;
    }
}