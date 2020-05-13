

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 无虚拟头节点
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {


        while(head!=null&&head.val==val){
            ListNode delNode=head;
            head=head.next;
            delNode.next=null;
        }
        if(head==null)
            return null;
        ListNode prev=head;
        while(prev.next!=null)
            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }
        else {
                prev=prev.next;
            }

        return head;
    }
}