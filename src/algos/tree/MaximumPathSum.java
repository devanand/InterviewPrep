/*
 * Given a binary tree of integers, find the maximum path sum between two nodes. 
 * The path must go through at least one node, and does not need to go through the root.
 */
package algos.tree;

import algos.model.Node;

/**
 *
 * @author anand
 */
public class MaximumPathSum
{
    static class Sum
    {
        int sum = Integer.MIN_VALUE;
    }
    public static int maximumPathSum(Node root, Sum sum)
    {
        if (root == null)
        {
            return 0;
        }
        int lSum = maximumPathSum(root.left, sum);
        int rSum = maximumPathSum(root.right, sum);
        
        int maxSide = Math.max(Math.max(lSum, rSum) + root.value, root.value);
        int allMax = Math.max(maxSide, lSum + rSum + root.value);
        sum.sum = Math.max(sum.sum, allMax);
        return maxSide;
    }
    public static void main(String[] args)
    {
        Node root = new Node(10); 
        root.left = new Node(2); 
        root.right = new Node(10); 
        root.left.left = new Node(20); 
        root.left.right = new Node(1); 
        root.right.right = new Node(-25); 
        root.right.right.left = new Node(3); 
        root.right.right.right = new Node(4); 
        Sum s = new Sum();
        maximumPathSum(root, s);
        System.out.println(s.sum);
    }
}
