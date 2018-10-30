import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if ( strs == null || strs.length ==0 ) {
            return new ArrayList<>();
        }
        Map<String, List<String>> hash_map = new HashMap<>();
        for ( int i = 0; i < strs.length; i++ ) {
            char[]charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (hash_map.containsKey(sortedString)) {
                hash_map.get(sortedString).add(strs[i]);
            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(strs[i]);
                hash_map.put(sortedString, valueList);
            }
        }
        return new ArrayList<>(hash_map.values());
    }
}
