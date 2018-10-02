/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author anand
 */
public class GraphDFSAndBFS
{
    public void bfs(int start, Graph g)
    {
        Map <Integer, Boolean> visitedMap = new HashMap<>();
        
        visitedMap.put(start, true);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty())
        {
            start = q.poll();
            System.out.println(start);
            
            Iterator<Integer> i = g.getAdj(start).iterator();
            while(i.hasNext())
            {
                int n = i.next();
                if (!visitedMap.containsKey(n))
                {
                    visitedMap.put(n, true);
                    q.add(n);
                }
            }
        }
    }
    
    public void dfs(int start, Graph g, Map <Integer, Boolean> visitMap)
    {
        visitMap.put(start, Boolean.TRUE);
        System.out.println(start);
        
        Iterator <Integer> i = g.getAdj(start).iterator();
        
        while(i.hasNext())
        {
            int n = i.next();
            if (!visitMap.containsKey(n))
            {
                dfs(n, g, visitMap);
            }
        }
    }
    
    public static void main(String[] args)
    {
        
    }
}
