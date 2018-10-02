/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.tree;

/**
 *
 * @author anand
 */
public class MirrorImageOfTree
{
    public boolean mirrorImage(Node1 root1, Node1 root2)
    {
        if (root1 == null && root2 == null)
        {
            return true;
        }
        if (root1 == null || root2 == null)
        {
            return false;
        }
        return root1.value == root2.value &&
                mirrorImage(root1.left, root2.right) &&
                mirrorImage(root1.right, root2.left);
    }
    
    public Node1 convertToMirrorImage(Node1 root)
    {
        if (root == null)
        {
            return null;
        }
        
        Node1 left = convertToMirrorImage(root.left);
        Node1 right = convertToMirrorImage(root.right);
        
        root.left = right;
        root.right = left;
        return root;
    }
}
