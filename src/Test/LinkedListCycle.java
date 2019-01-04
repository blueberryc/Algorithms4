package Test;

import java.util.HashSet;

/**
 * Created by Zive on 2018-12-28.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head){
        if (head == null || head.next == null)
            return false;
        HashSet<ListNode> mark = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (mark.contains(cur))
                return true;
            mark.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public static ListNode buildLinkedList(int[] values, int index){
        /**
         * 根据输入的数组值和环的索引位构建链表
         * @parm: values
         * @parm: index
         * */
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        if (index >= 0 && index <= values.length - 2){
            ListNode linkNode = head.next;
            while (index > 0){
                index--;
                linkNode = linkNode.next;
            }
            cur.next = linkNode;
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < 30){
            count++;
            System.out.print(cur.val + "-->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] values = {5, 6, 9, 8, 4, 5};
        int index = -1;
        ListNode head = buildLinkedList(values, index);
        printList(head);
        System.out.println(hasCycle(head));
    }
}
