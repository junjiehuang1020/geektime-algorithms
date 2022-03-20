package me.junjiehuang1020.homework.week.four;

import me.junjiehuang1020.homework.week.common.list.TreeNode;

public class ConvertBSTtoGreaterTree {
    
    private int sum;
    
    public TreeNode convertBST(TreeNode root) {
        
        sum = 0;
        
        plusNode(root);
        
        return root;
        
    }
    
    private void plusNode(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        plusNode(root.getRight());
        
        sum = sum + root.getVal();
        
        root.setVal(sum);
        
        plusNode(root.getLeft());
        
    }
}
