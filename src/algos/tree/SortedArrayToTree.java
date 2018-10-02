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
public class SortedArrayToTree
{
    
    
    public Node toTree(int a[], int l, int h)
    {
        if (l < h)
        {
            int mid = (l + h)/2;
            
            Node node = new Node(a[mid]);
            
            node.left = toTree(a, l, mid-1);
            node.right = toTree(a, mid+1, h);
            return node;
        }
        return null;
    }
}
