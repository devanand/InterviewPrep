/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * @author anand
 */

class Singleton implements Serializable
{
    private static volatile Singleton singleton = null;

    private Singleton()
    {
        if (singleton != null)
        {
            throw new RuntimeException("Cannot create duplicates");
        }
    }
    
    public static Singleton getInstance()
    {
        if (singleton == null)
        {
            synchronized(Singleton.class)
            {
                if (singleton == null)
                {
                    singleton = new Singleton();
                }
            }
            
        }
        return singleton;
    }
    
    public Object readResolve() throws ObjectStreamException
    {
        return singleton;
    }
}
public class SingletonExample
{
    public static void main(String[] args) throws Exception
    {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        print("s1", s1);
        print("s2", s2);
        //For serialization        
        ObjectOutputStream ostr = new ObjectOutputStream(new FileOutputStream("s2.err"));
        ostr.writeObject(s2);
        ostr.close();;
        ObjectInputStream istr = new ObjectInputStream(new FileInputStream("s2.err"));
        Singleton s3 = (Singleton) istr.readObject();
        istr.close();
        
        //For reflection
        
//        Class clazz = Singleton.class;
//        Constructor<Singleton> cons = clazz.getDeclaredConstructor();
//        cons.setAccessible(true);
//        Singleton s3 = cons.newInstance();
//        print("s3", s3);
        
//        For thread

//        ExecutorService service = Executors.newFixedThreadPool(2);
//        service.submit(SingletonExample::get);
//        service.submit(SingletonExample::get);
//        service.shutdown();
    }
    
    public static void get()
    {
        Singleton singleton = Singleton.getInstance();
        print("singleton", singleton);
    }
    
    private static void print(String name, Singleton s)
    {
        System.out.println(String.format("Singleton: %s, HashCode %d", name, s.hashCode()));
    }
}
