package RemoveNthNodeFromEndofList;

/**
 * Created by lianglitu on 16/10/7.
 *
 * Not Solved
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail=head;
        while (n>1)
        {
            tail=tail.next;
        }

        while (tail.next==null)
        {
            tail=tail.next;
            head=head.next;
        }

        return head;

    }
}
