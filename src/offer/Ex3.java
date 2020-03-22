package offer;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

import java.util.ArrayList;
import java.util.List;


public class Ex3 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}