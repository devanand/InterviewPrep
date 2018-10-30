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
class NodePeer
{
    NodePeer left;
    int value;
    NodePeer right;
    NodePeer peer;
}
public class AttachTreePeers
{
    public void attachTreePeers(NodePeer root)
    {
        NodePeer childRef = null,
                 child = null;
        
        while (root != null)
        {
            while (root != null)
            {
                if (root.left != null)
                {
                    if (childRef != null)
                    {
                        child.peer = root.left;
                    }
                    else
                    {
                        childRef = root.left;
                    }
                    child = root.left;
                }
                if (root.right != null)
                {
                    if (childRef != null)
                    {
                        child.peer = root.right;
                    }
                    else
                    {
                        childRef = root.right;
                    }
                    child = root.right;
                }
                root =  root.peer;
            }
            
            root = childRef;
            childRef = child = null;
        }
    }
}
