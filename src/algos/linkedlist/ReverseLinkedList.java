/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anand
 */
public class ReverseLinkedList
{
    public static Node reverseSinglyLinkedList(Node root)
    {
        if (root == null)
        {
            return root;
        }
        
        Node prev = null;
        Node current = root;
        Node next = null;
        
        while(current != null)
        {
            next = current.right;
            current.right = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    
    static Node reverseDoublyLinkedList(Node root)
    {
        if (root == null)
        {
            return root;
        }
        
        Node current = root,
                next = null,
                prev = null;
        
        while (current != null)
        {
            next = current.right;
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    void sort()
    {
        

    }
    
    static void print(Node node)
    {
        while (node != null)
        {
            System.out.print(node.value + " ");
            node = node.right;
        }
    }
    
    static void zigZagTraversal(Node root)
    {
        List <Node> nodes = new LinkedList<>();
        nodes.add(root);
        boolean leftToRight = true;
        List <Node> nodes1 = new LinkedList<>();
        nodes1.add(root);
        while(!nodes1.isEmpty())
        {
            nodes1.clear();
            for(Node node : nodes) 
            {
                if (node.left != null)
                {
                    nodes1.add(node.left);
                }
                if (node.right != null)
                {
                    nodes1.add(node.right);
                }
            }
            if(leftToRight) 
            {
                for (int i=0; i < nodes.size(); i++)
                {
                    System.out.print(nodes.get(i).value + " " );
                }
            }
            else
            {
                for (int i = nodes.size() - 1; i>=0; i--)
                {
                    System.out.print(nodes.get(i).value + " " );
                }
            }
            
            nodes = new LinkedList<>(nodes1);
            leftToRight = !leftToRight;
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
           Node root = new Node(1);
           root.left = new Node(2);
           root.right = new Node(3);
           root.left.left = new Node(4);
           root.left.right = new Node(5);
           root.right.left = new Node(6);
           root.right.right = new Node(7);
           zigZagTraversal(root);
        
    }
}
