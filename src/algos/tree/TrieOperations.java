/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.tree;

import java.util.Map;
import algos.model.Trie;

/**
 *
 * @author anand
 */
public class TrieOperations
{
    Trie root;
    public TrieOperations()
    {
        root = new Trie();
    }
    
    public void insert(String str)
    {
        Trie current = root;
        for (int i=0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            current = current.getChildren().get(c);
            if (current == null)
            {
                Trie newNode = new Trie();
                current.getChildren().put(c, newNode);
                current = newNode;
            }
        }
        current.setIsEnd(true);
    }
    
    public void search(String str)
    {
        Trie current = root;
        for (int i=0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            current = current.getChildren().get(c);
            if (current == null)
            {
                System.out.print("Word not present");
                return;
            }
        }
        System.out.println(current.isIsEnd());
    }
    
    public boolean searchPartial(String str)
    {
        Trie current = root;
        boolean isBeginFound = false;
        for (int i=0;i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (isBeginFound)
            {
                current = current.getChildren().get(c);
                if (current == null)
                {
                    return false;
                }
            }
            
            
            else if (!isBeginFound)
            {
                for (char key : current.getChildren().keySet())
                {
                    Trie temp = current.getChildren().get(key);
                    if (!temp.isIsEnd())
                    {
                        for (char tempKey : temp.getChildren().keySet())
                        {
                            if (tempKey == c)
                            {
                                isBeginFound = true;
                                current = temp.getChildren().get(tempKey);
                               
                            }
                        }
                    }
                    
                }
            }
        }
        return false;
    }
    
    public void delete(String s)
    {
        
    }
}
