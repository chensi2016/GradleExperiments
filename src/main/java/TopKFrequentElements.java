import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++ ) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if ( list.size() < k ) {
                list.add(entry);
                list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
            } else {
                if ( entry.getValue() > list.get(k-1).getValue() ) {
                    list.remove(k-1);
                    list.add(k-1, entry);
                    list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                            return o2.getValue() - o1.getValue();
                        }
                    });
                }

            }

        }
        List<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: list) {
            result.add(entry.getKey());
        }
        return result;
    }
}
