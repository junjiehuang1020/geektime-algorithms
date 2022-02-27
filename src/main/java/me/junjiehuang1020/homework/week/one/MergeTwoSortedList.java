package me.junjiehuang1020.homework.week.one;

import me.junjiehuang1020.homework.week.common.list.ListNode;

public class MergeTwoSortedList {
    
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode protect = new ListNode(0, null);
        
        ListNode head = protect;
    
        while (list1 != null || list2 != null) {
            
            if(list2 == null || (list1 != null && list1.getVal() <= list2.getVal())) {
                
                head.setNext(list1);
                head = head.getNext();
                list1 = list1.getNext();
                
            } else {
                head.setNext(list2);
                head = head.getNext();
                list2 = list2.getNext();
            }
        }
        
        return protect.getNext();
    }
}
