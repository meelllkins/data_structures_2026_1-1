package com.packages.linked_list;

public class LSLC 
{
    public Node head;
    public Node tail;
    private int n;

    public LSLC()
    {
        head = null;
        tail = null;
        n = 0;
    }

    public Node getHead() 
    {
        return head;
    }

    public void setHead(Node head) 
    {
        this.head = head;
    }

    public int getN() 
    {
        return n;
    }

    public void setN(int n) 
    {
        this.n = n;
    }

    public void createEndLSLC(int datum)
    {
        Node mem = new Node();
        mem.info = datum;
        n++;
        if (head == null) {
            head = mem;
        } else {
            tail.link = mem;
        }
        tail = mem;
        tail.link = head;
    }

    public void showLSLC()
    {
        Node p = head;
        System.out.println(p.info);
        p = p.link;
        while (p != head) {
            System.out.println(p.info);
            p = p.link;
        }
    }

    

    
}
