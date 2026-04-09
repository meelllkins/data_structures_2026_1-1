package com.packages.arrays;

public class Persons 
{
    private int n;
    private final int T = 50;
    private RecordPerson recPer[] = new RecordPerson[T];

    public Persons()
    {
        n = 0;
    }

    public int getT() {
        return T;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void createPerson(String name, byte age)
    {
        recPer[n] = new RecordPerson();
        recPer[n].name = name;
        recPer[n].age = age;
        n++;
    }

    public void showPerson()
    {
        System.out.println("Nombre \t\t Edad");
        for (int i = 0; i < n; i++) {
            System.out.println(recPer[i].name + "\t\t" + recPer[i].age);
        }
    }

    public void youngPerson()
    {
        byte minAge = recPer[0].age;
        String minName = recPer[0].name;
        for (int i = 1; i < n; i++) {
            if (recPer[i].age < minAge) {
                minAge = recPer[i].age;
                minName = recPer[i].name;
            }
        }
        System.out.println("Persona más joven: " + minName + "\nEdad: " + minAge);
    }

    public double percentageMax18()
    {
        int countMaxAge = 0;
        for (int i = 0; i < n; i++) {
            if (recPer[i].age >= 18) {
                countMaxAge++;
            }
        }
        return countMaxAge * (double)100 / n;
    }
}
