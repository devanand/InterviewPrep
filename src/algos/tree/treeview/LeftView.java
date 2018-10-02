/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.tree.treeview;

import algos.model.Node;

/**
 *
 * @author anand
 */
public class LeftView
{
    static class MaxLevel
    {
        static int level;
    }
    public static void leftView(Node root, int level)
    {
        if (root == null)
        {
            return;
        }
        
        if (level > MaxLevel.level)
        {
            System.out.println(root.value);
            MaxLevel.level = level;
        }
        
        leftView(root.left, level+1);
        leftView(root.right, level+1);
    }
    
    public static void main(String[] args)
    {
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(20);
        root.right.right = new Node(40);
        root.right.right.right = new Node(50);
        
        leftView(root, 1);
    }
}
