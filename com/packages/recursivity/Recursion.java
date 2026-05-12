package com.packages.recursivity;

public class Recursion {
    
    public Recursion() {
        
    }

    public int factorial(int n) {
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

    public void printNaturalNumbers(int count) {
        if (count > 0) {
            printNaturalNumbers(count - 1);
            System.out.print(count + " ");
        }
    }

    public void printFibonacci(int fibcount) 
    {
        if (fibcount > 0) {
            printFibonacci(fibcount - 1);
            System.out.print(fibonacci(fibcount - 1) + " ");
        }
    }
}
    


