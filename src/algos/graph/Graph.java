/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graph;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anand
 */
public class Graph
{
    private int v;
    private LinkedList <Integer> adj[];

    public Graph(int v)
    {
        this.v = v;
        for (int i=0; i < v; i++)
        {
            adj[i] = new LinkedList<>();
        }
    }
    
    public List<Integer> getAdj(int s)
    {
        return adj[s];
    }
}
