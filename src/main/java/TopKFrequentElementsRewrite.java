import java.util.*;

public class TopKFrequentElementsRewrite {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for ( int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            queue.add(entry);
        }
        List<Integer> result = new ArrayList<>();
        for ( int i = 0; i < k; i++ ) {
            result.add(queue.poll().getKey());
        }
        return result;
    }
}
