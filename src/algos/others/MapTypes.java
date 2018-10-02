/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author anand
 */
public class MapTypes
{
    //Comparison is done using == operator instead of equals and hashcode. So comparison is 
    //faster and it intentionally violates the equals agreement of java
    public static void identityMapExample()
    {
        Map <String, String> map = new IdentityHashMap<>();
        map.put("a", "b");
        map.put(new String("a"), "c");
        System.out.println(map);
    }
    
    public static void hashMapExample()
    {
        Map <String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put(new String("a"), "c");
        System.out.println(map);
    }
    
    public static void weakHashMap()
    {
        String s = new String("A");
        WeakHashMap<String, String> map = new WeakHashMap<>();
        
        map.put(s, "a");
        s = null;
        System.gc();
        System.out.println(map);
    }
    
    public static void concurrentHashMap()
    {
        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: "+myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while(it.hasNext())
        {
                String key = it.next();
                if(key.equals("3")) 
                    myMap.put(key+"new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: "+myMap);

        //HashMap
        myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: "+myMap);
        Iterator<String> it1 = myMap.keySet().iterator();
        while(it1.hasNext())
        {
                String key = it1.next();
                if(key.equals("3")) 
                {
                    myMap.put(key+"new", "new3");
                    break;
                }
                    
        }
        System.out.println("HashMap after iterator: "+myMap);
    }
    
    public static void main(String[] args)
    {
        identityMapExample();
        hashMapExample();
        weakHashMap();
        concurrentHashMap();
    }
}
