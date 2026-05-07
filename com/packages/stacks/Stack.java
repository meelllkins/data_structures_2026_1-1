package com.packages.stacks;

public class Stack {
    private final int T = 100; 
    private int top;
    private int stack[] = new int[T];

    public Stack() 
    {
        top = 0;
    }

    public int getT() {
        return T;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }
    

    public void stacking(int datum) 
    {
        stack[top] = datum;
        top++;
    }

    public int unstacking() 
    {
        int datum = stack[top - 1];
        top--;
        return datum;
    }

    public void showStack()
    {
        System.out.println("------------------");
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
            System.out.println("-----------------");

        }
    }
     
}
