package Solved.Year2023.Sept.Day7;




public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
          ListNode dummyHead = new ListNode(-1,head);

          ListNode curr = dummyHead,leftNode,ptr;

          // move currrent point to before the left node

          for(int i = 1;i<left;i++) {
              curr = curr.next;
          }

          ptr = curr;
          curr = curr.next;
          ptr.next = null;
          leftNode = curr;


          for(int i = left;i<=right;i++) {

              ListNode tempNext = curr.next;
              curr.next = ptr.next;
              ptr.next = curr;
              curr = tempNext;

          }

        leftNode.next = curr;

          return dummyHead.next;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}