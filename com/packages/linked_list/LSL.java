package com.packages.linked_list;

public class LSL 
{
    public Node head;

    public LSL() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void createBeginLSL(int datum) {
        Node p = new Node();
        p.info = datum;
        p.link = head;
        head = p;
    }

    public int countNodesLSL() {
        Node p = head;
        int i = 0;
        while (p != null) {
            i++;
            p = p.link;
        }
        return i;
    }

    public int sumNodesLSL() {
        Node p = head;
        int s = 0;
        while (p != null) {
            s += p.info;
            p = p.link;
        }
        return s;
    }

    public void showLSL() {
        Node p = head;
        int i = 0;
        while (p != null) {
            i++;
            System.out.println(
                "Dato " + i + ": " + p.info +
                "Dirección nodo: " + p +
                "Dirección liga: " + p.link 
            );
            p = p.link;
        }
    }

    
}
