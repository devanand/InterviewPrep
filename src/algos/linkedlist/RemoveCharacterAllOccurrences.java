/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.linkedlist;

/**
 *
 * @author anand
 */
public class RemoveCharacterAllOccurrences
{
    public static Node removeAllOccurrences(Node start, int n)
    {
        Node current = start;
        while (current != null)
        {
            if (current.value == n)
            {
                Node temp = current;
                Node prev = current.left;
                Node next = null;
                while (temp.right != null && temp.right.value == n) 
                {
                    temp = temp.right;
                }
                next = temp.right;
                if (prev == null && next == null)
                {
                    return null;
                }
                if (prev == null)
                {
                    current = next;
                    start = current;
                }
                else
                {
                    if (next != null)
                    {
                        next.left = prev;
                        current = next;
                    }
                    prev.right = next;
                }
             }
            current = current.right;
        }
        return start;
    }
    
    public static void printList(Node start)
    {
        if (start == null)
        {
            System.out.println(start);
        }
        while (start != null)
        {
            System.err.println(start.value + " ");
            start =  start.right;
        }
    }
    
    public static void main(String[] args)
    {
        Node start = new Node(1);
        start.right = new Node(1);
        start.right.left = start;
        start.right.right = new Node(3);
        start.right.right.left = start.right;
        
        printList(removeAllOccurrences(start, 1));
    }
}
