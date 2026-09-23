/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;


        for (ListNode list: lists){
            if (list !=null){
                heap.add(list);
            }
        }
        
        while (!heap.isEmpty()){
            ListNode removedNode = heap.poll();
            if (removedNode.next != null){
                heap.add(removedNode.next);
            }
            tail.next = removedNode;
            tail = removedNode;
        }
        return dummyHead.next;
    }
}