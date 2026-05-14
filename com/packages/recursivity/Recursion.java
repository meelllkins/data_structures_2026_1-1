package com.packages.recursivity;

public class Recursion {
    
    public Recursion() {
        
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public void printFibonacci(int fibcount) 
    {
        if (fibcount > 0) {
            printFibonacci(fibcount - 1);
            System.out.print(fibonacci(fibcount - 1) + " ");
        }
    }

    public static void displayNaturalNumbersAsc(int n, int i)
    {

        if (i <= n) {
            System.out.println(i);
            displayNaturalNumbersAsc(n, i + 1);
        }
    }

    public static void displayNaturalNumbersDescending(int n, int i)
    {
        if (i > 0) {
            System.out.println(i);
            displayNaturalNumbersDescending(n, i - 1);
        }
    }
    public static void FibonacciIterative(int n)
    {
        int t1, t2, t3;
        t1 = 0; 
        t2 = 1; 
        System.out.println(t1 + "\n" + t2);
        for (int i = 3; i <= n; i++) {
            t3 = t1 + t2;
            System.out.println(t3);
            t1 = t2;
            t2 = t3;
        }
    }

    public static void FibonacciRecursive(int n)
    {
        if (n >= 1) 
        {
            FibonacciRecursive(n - 1); FibonacciRecursive(n - 2);
        } else {
            System.out.println(n);
        }
    }
    
    
}