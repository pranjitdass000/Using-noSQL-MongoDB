package com.stackroute.in;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student1 = new Student(1,"pranjit",24);

        System.out.println("the student name is " + student1.getName());
        System.out.println("the student age is " + student1.getAge());
        System.out.println("the student id is " + student1.getId());
    }
}
