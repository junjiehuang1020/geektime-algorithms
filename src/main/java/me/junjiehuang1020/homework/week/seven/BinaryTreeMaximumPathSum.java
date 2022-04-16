package me.junjiehuang1020.homework.week.seven;

import me.junjiehuang1020.homework.week.common.list.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {
    
    public int maxPathSum(TreeNode root) {
        
        t = new HashMap<TreeNode, Integer>();
        t.put(null, 0);
        
        dfs(root);
        
        ans = Integer.MIN_VALUE;
        
        traverse(root);
        
        return ans;
    }
    
    private void dfs(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        dfs(root.getLeft());
        dfs(root.getRight());
        
        if (Math.max(t.get(root.getLeft()), t.get(root.getLeft())) >= 0) {
            t.put(root, Math.max(t.get(root.getLeft()), t.get(root.getRight())) + root.getVal());
        } else {
            t.put(root, root.getVal());
        }
    }
    
    private void traverse(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        traverse(root.getLeft());
        traverse(root.getRight());
        
        if (t.get(root.getLeft()) < 0 && t.get(root.getRight()) < 0) {
            ans = Math.max(ans, root.getVal());
        } else if (t.get(root.getLeft()) < 0 && t.get(root.getRight()) >= 0) {
            ans = Math.max(ans, root.getVal() + t.get(root.getRight()));
        } else if (t.get(root.getRight()) < 0 && t.get(root.getLeft()) >= 0) {
            ans = Math.max(ans, root.getVal() + t.get(root.getLeft()));
        } else {
            ans = Math.max(ans, root.getVal() + t.get(root.getLeft()) + t.get(root.getRight()));
        }
    }
    
    private Map<TreeNode, Integer> t;
    
    private int ans;
    
}
