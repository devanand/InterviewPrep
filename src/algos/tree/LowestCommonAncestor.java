/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.tree;

import algos.model.Node;

/**
 *
 * @author anand
 */
public class LowestCommonAncestor
{
    public static Node lowestCommonAncestor(Node root, Node n1, Node n2)
    {
        if (root == null || root == n1 || root == n2)
        {
            return root;
        }
        
        Node left = lowestCommonAncestor(root.left, n1, n2);
        Node right = lowestCommonAncestor(root.right, n1, n2);
        if (left != null && right != null)
        {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public static Node lca(Node root, int n1, int n2)
    {
        if (root == null || root.value == n1 || root.value == n2)
        {
            return root;
        }
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        
        if (left != null && right != null)
        {
            return root;
        }
        else if (left != null)
        {
            return lca(left, n1, n2);
        }
        else 
        {
            return lca(right, n1, n2);
        }
    }
    
    public static void main(String[] args)
    {
        Node root = new Node(1);
    }
}
