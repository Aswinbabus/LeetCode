package Solved.Year2023.Sept.Day6;

 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] splitedParts = new ListNode[k];

        ListNode ptr = head;

        int listLen = getLength(head);

        int splitSize = listLen / k, splitRem = listLen % k;

        for (int splitIndex = 0; splitIndex < k; splitIndex++) {

            splitedParts[splitIndex] = ptr;

            int currentSplitSize = splitSize + (splitRem > 0 ? 1 : 0),curr = 0;

            while(ptr != null && curr < currentSplitSize - 1) {

                ptr = ptr.next;
                curr++;

            }

            if(ptr != null) {

                ListNode tempPtr = ptr;

                ptr = ptr.next;
                tempPtr.next = null;

            }

            if(splitRem != 0) splitRem--;

        }

        return splitedParts;

    }

    private int getLength(ListNode head) {
        int len = 0;

        while(head != null) {
            len++;
            head = head.next;
        }

        return len;

    }
}