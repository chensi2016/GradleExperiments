import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKListsByPriorityQueue {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null)
                queue.offer(node.next);
        }
        return dump.next;
    }
}