package com.rainbow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 标准解是用两个指针，还是不错的。
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        new RemoveNthNodeFromEndOfList().removeNthFromEnd(node, 2);
    }

    public Map<ListNode, ListNode> parentMap = new HashMap<>();

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        ListNode oldHead = head;
        ListNode tail = null;
        while (head != null) {
            if (head.next != null) {
                parentMap.put(head.next, head);
            }
            else {
                tail = head;
            }
            head = head.next;
        }

        while (--n > 0) {
            tail = parentMap.get(tail);
        }
        ListNode nodeToDelete = tail;

        if (parentMap.get(nodeToDelete) == null) {
            // 如果删的是头
            return oldHead.next;
        }
        else {
            parentMap.get(nodeToDelete).next = nodeToDelete.next;
            return oldHead;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

