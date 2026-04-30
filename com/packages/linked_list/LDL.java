package com.packages.linked_list;

public class LDL 
{
    public NodeLDL head;
    private int n;

    public LDL()
    {
        head = null;
        n = 0;
    }

    public NodeLDL getHead() 
    {
        return head;
    }

    public void setHead(NodeLDL head) 
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

    public void createBeginLDL(int datum)
    {
        NodeLDL mem = new NodeLDL();
        mem.info = datum;
        mem.right = head;
        if (head != null) {
            head.left = mem;
        }
        head = mem;
        mem.left = null;
        n++;
    }

    public void showLDL()
    {
        NodeLDL p = head;
        while (p != null) {
            System.out.println("-------------");
            System.out.println("Información: " + p.info);
            System.out.println("Liga izquierda: " + p.left);
            System.out.println("Liga derecha: " + p.right);
            System.out.println("Dirección nodo: " + p);
            System.out.println("-------------");
            p = p.right;
        }
    }

    public NodeLDL findLDL(int datum)
    {
        NodeLDL p = head;
        NodeLDL q = null;
        while (p != null && q == null) {
            if (p.info == datum) {
                q = p; 
            } else {
                p = p.right;
            }
        }
        return q;
    }

    public void updateNodeLDL(NodeLDL p, int datum)
    {
        p.info = datum;
    }

    public void deleteNodeLDL(NodeLDL dir)
    {
        if (head == dir) {
            head.left = null;
            head = head.right;
        } else {
            dir.left.right = dir.right;
            if (dir.right != null) {
                (dir.right).left = dir.left;
            } 
        }
        n--;
    }
}
