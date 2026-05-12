package com.packages.queues;

public class Queue {
    private final int T = 100; 
    private int end;
    private int queue[] = new int[T];

    
    
    public int getEnd() {
        return end;
    }
    
    public void setEnd(int end) {
        this.end = end;
    }
    
    public int[] getQueue() {
        return queue;
    }
    
    public void setQueue(int[] queue) {
        this.queue = queue;
    }
    
    public int getT() {
        return T;
    }
    
    public Queue() 
    {
        end  = 0;
    }
    
    public void addQueue(int datum) 
    {
        queue[end] = datum;
        end++;
    }
    
    public int popQueue()
    {
        int saved = queue[0];
        for (int i = 0; i < end - 1; i++) {
            queue[i] = queue[i + 1];
        }
        end--;
        return saved;
    }

    public void displayQueue()
    {
        for (int i = 0; i < end; i++) {
            System.out.print(queue[i] + " <- ");
        }
    }

    
}