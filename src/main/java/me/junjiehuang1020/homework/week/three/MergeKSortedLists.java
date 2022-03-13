package me.junjiehuang1020.homework.week.three;

import me.junjiehuang1020.homework.week.common.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) {
            return null;
        }
        
        List<ListNode> nodesArray = new ArrayList<>();
        
        for (int i = 0; i < lists.length; i++) {
            nodesArray.add(lists[i]);
        }
        
        List<ListNode> nodes = merge(nodesArray);
        
        return nodes.get(0);
    }
    
    private List<ListNode> merge(List<ListNode> nodes) {
        
        if (nodes.size() == 1) {
            return nodes;
        }
        
        List<ListNode> recurAns = new ArrayList<>();
        
        for (int i = 0; i < nodes.size() - 1; i = i + 2) {
            
            ListNode node = mergeTwoNodes(nodes.get(i), nodes.get(i + 1));
            recurAns.add(node);
            
        }
        
        if (nodes.size() % 2 == 1) {
            recurAns.add(nodes.get(nodes.size() - 1));
        }
        
        return merge(recurAns);
        
    }
    
    
    private ListNode mergeTwoNodes(ListNode node1, ListNode node2) {
        
        ListNode protect = new ListNode(0, null);
        
        ListNode head = protect;
        
        while (node1 != null || node2 != null) {
            
            if (node2 == null || (node1 != null && node1.getVal() <= node2.getVal())) {
                
                head.setNext(node1);
                node1 = node1.getNext();
                head = head.getNext();
                
            } else {
                
                head.setNext(node2);
                node2 = node2.getNext();
                head = head.getNext();
                
            }
            
        }
        
        return protect.getNext();
    }
}
