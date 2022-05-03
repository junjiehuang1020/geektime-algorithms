package me.junjiehuang1020.homework.week.ten;

import javax.sound.midi.Soundbank;
import java.util.Random;

public class Skiplist {
    
    private final int MAX_LEVEl = 16;
    private Node head;
    
    private int count;
    
    public Skiplist() {
        
        count = 0;
        // initialize head
        head = new Node(-1, MAX_LEVEl);
        head.next = null;
        Node node = head;
        for (int i = MAX_LEVEl - 1; i >= 1; i--) {
            Node dnode = new Node(-1, i);
            dnode.next = null;
            node.down = dnode;
            node = dnode;
        }
    }
    
    public boolean search(int target) {
        
        Node node = head;
        
        while(node != null && node.level >= 1) {
            while (node.next != null && target >= node.next.val ) {
                node = node.next;
                if (target == node.val) {
                    return true;
                }
            }
            // 若node的next为空或者target小于node的next的值，则往下走
            node = node.down;
        }
        
        return false;
        
    }
    
    
    public void add(int num) {
        
        int tlevel = dial();
        Node node = head;
        Node[] nodeRecord = new Node[MAX_LEVEl + 1];
        nodeRecord[0] = null;
        
        while(node != null && node.level >= 1) {
            while (node.next != null && num >= node.next.val) {
                node = node.next;
            }
            nodeRecord[node.level] = node;
            if (node.level != 1) {
                node = node.down;
            } else {
                break;
            }
        }
        
        Node nextNode;
        //protect node
        Node upNode = new Node(-1, tlevel + 1);
        
        for (int i = MAX_LEVEl; i >= 1; i--) {
            if (i <= tlevel) {
                Node numNode = new Node(num, i);
                nextNode = nodeRecord[i].next;
                nodeRecord[i].next = numNode;
                numNode.next = nextNode;
                
                upNode.down = numNode;
                upNode = numNode;
            }
        }
        
        count++;
        
    }
    
    public boolean erase(int num) {
        
        Node node = head;
        Node preNode;
        
        while(node != null && node.level >= 1) {
            while (node.next != null && num >= node.next.val) {
                preNode = node;
                node = node.next;
                if (num == node.val) {
                    preNode.next = node.next;
                    node = preNode.down;
                    if (node == null) {
                        count--;
                        return true;
                    }
                }
            }
            // 若node的next为空或者target小于node的next的值，则往下走
            node = node.down;
        }
    
        return false;
        
    }
    
    
    private int dial() {
        int res = 1;
        Random rand = new Random();
        while((rand.nextInt() & 1) == 1 && res < MAX_LEVEl) {
            res++;
        }
        return res;
    }
    
    private class Node {
        
        int val;
        int level;
        Node next;
        Node down;
    
        public Node() {
        }
    
        public Node(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }
}
