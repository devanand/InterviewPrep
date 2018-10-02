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
public class RotateLinkedList
{
    public static Node rotateList(Node start, int n)
    {
        Node current = start;
        int listSize = 0;
        while (current != null)
        {
            current = current.right;
            listSize++;
        }
        if (n > listSize) 
        {
            n = n % listSize;
        }
        if (n == 0)
        {
            return start;
        }
        int count = 0;
        current = start;
        while (count < listSize - n) 
        {
            current = current.right;
            count++;
        }
        
        Node temp = current;
        while (temp.right != null) 
        {
            temp = temp.right;
        }
        temp.right = start;
        count = 0;
        while (start.right != null) 
        {
            count++;
            if (count == (listSize - n)) 
            {
                start.right = null;
                break;
            }
            start = start.right;
        }
        return current;
    }
    
    public static void printList(Node start) 
    {
        while (start != null)
        {
            System.out.print(start.value+ " ");
            start = start.right;
        }
     }
    
    public static void main(String[] args)
    {
        Node start = new Node(1);
        start.right = new Node(2);
        start.right.right = new Node(3);
        start.right.right.right = new Node(4);
        //printList(start);
        printList(rotateList(start, 9));
    }
}
