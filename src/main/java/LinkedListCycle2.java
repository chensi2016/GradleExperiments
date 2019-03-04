import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode pointer = head;
        ListNode result = null;
        Map<ListNode, Boolean> map = new HashMap<>();
        while(pointer.next != null) {
            if(map.containsKey(pointer)) {
                result = pointer;
                break;
            }
            map.put(pointer, true);
            pointer = pointer.next;
        }
        return result;

    }
}
