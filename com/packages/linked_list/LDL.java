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
}
