/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.interfaces;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author anand
 */

interface I1
{
   public static final int a = 10;
   
   default void log()
   {
       System.out.println("Interface1");
   }
}

interface I2
{
    public void operation(int a, int b);
    default void log()
    {
        System.out.println("Interface2");
    }
}

interface I3 extends I1
{
    default void log()
    {
        System.out.println("Interface3");
        I1.super.log();
    }
}

public class InterfaceTest implements I1, I3
{

    @Override
    public void log()
    {
       I3.super.log(); 
    }
    
    public static void main(String[] args)
    {
        new InterfaceTest().log();
        List<InterfaceTest> list = Arrays.asList(new InterfaceTest(), new InterfaceTest());
        list.forEach(s->    System.out.println(s));
    }
}
