/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anand
 */
public class Trie
{
    Map <Character, Trie> children;
    boolean isEnd;
    
    public Trie()
    {
        children = new HashMap<>();
        isEnd = false;
    }

    public Map<Character, Trie> getChildren()
    {
        return children;
    }

    public boolean isIsEnd()
    {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd)
    {
        this.isEnd = isEnd;
    }
}
