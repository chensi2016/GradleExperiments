import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Set<String> hash_set = new HashSet<>();
        char[][] charArrays = new char[strs.length][];
        for ( int i = 0; i < strs.length; i++ ) {
            charArrays[i] = strs[i].toCharArray();
            Arrays.sort(charArrays[i]);
            hash_set.add(new String(charArrays[i]));
        }

        List<List<String>> result = new ArrayList<>(hash_set.size());
        for (int i = 0; i < hash_set.size(); i++) {
            List<String> stringList = new ArrayList<>();
            result.add(stringList);
        }

        for (int i = 0; i < strs.length; i++) {
            Iterator<String> iterator = hash_set.iterator();
            int count = 0;
            while ( iterator.hasNext() ) {
                String sortedString = new String(charArrays[i]);
                if( sortedString.equals(iterator.next()) ){
                    result.get(count).add(strs[i]);
                }
                count++;
            }

        }
        return result;
    }
}
