package com.company;

import java.util.*;
import java.lang.Object;

public class Students implements Comparator<StudentInt> {

    static ArrayList<StudentInt> iDNumber=new ArrayList<>();

    static String[] names = new String[] { "Nikita", "Ivan", "Pasha", "Igor", "Sasha", "Ilya" };

    public Students() {
        for (int i = 0; i < 5; i++) {
            int a = (int) (Math.random() * 40 + 20);
            int b = (int) (Math.random() * 40 + 10);
            int c=(int) (Math.random()*40+1);
            iDNumber.add(i,new Student(names[i % names.length], a, b, c));
        }
    }

    public void outArray(){
        System.out.println("Name"+"\t"+"Age"+"\t"+"Group"+" "+"Res");
        iDNumber.stream().forEach(el ->{ // StreamAPI
            System.out.print(el.getName()+ "\t"+el.getRes()+"\n");
        });

    }

    @Override
    public int compare(StudentInt o1, StudentInt o2) {return Integer.compare(o1.getRes(), o2.getRes());}






    public void quicksort(ArrayList<StudentInt> iDNumber,int low,int high){
        if (iDNumber.size() == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        StudentInt opora=iDNumber.get(middle);
        int i = low, j = high;
        while (i <= j) {
            while (compare(iDNumber.get(i), opora) > 0)
                i++;
            while (compare(iDNumber.get(j), opora) < 0)
                j--;
            if (i <= j) {

                Collections.swap(iDNumber,i,j);

                i++;
                j--;}}
        if (low < j)
            quicksort(iDNumber,low, j);
        if (high > i)
            quicksort(iDNumber,i, high);
    }


    public static StudentInt findLiniary(int res){
        for (StudentInt p: iDNumber)
            if (((Student)p).equals(res))
                return p;
        return null;
    }

    public static StudentInt findBiniary(int res, int i){
        if (iDNumber.get(i) != null && (((Student)iDNumber.get(i)).equals(res)))
            return iDNumber.get(i);
        else if(iDNumber.get(i+i/2) != null && iDNumber.get(i+i/2).getRes() >= res)
            return findBiniary(res, i + i / 2);
        else if (iDNumber.get(i-i/2)!= null && iDNumber.get(i-i/2).getRes() <= res)
            return findBiniary(res, i - i / 2);
        else
            return null;
    }


    public static void main(String[] args){
        Students students=new Students();

        System.out.println("Quick sort : ");
        students.quicksort(iDNumber, 0,4);
        students.outArray();


        System.out.print("\nНайти элемент c помощью линейного поиска - ");
        Scanner sc=new Scanner(System.in);
        Integer find = sc.nextInt();
        if (findLiniary(find) != null)
            System.out.println(findLiniary(find).getName()+" "+findLiniary(find).getRes());
        else
            System.out.println("Такого элемента нет");




        System.out.print("\nНайти элемент с помощью бинарного поиска - ");
        Integer find2 = sc.nextInt();
        if (findBiniary(find2, iDNumber.size() / 2) != null)
            System.out.println(findBiniary(find2, iDNumber.size() / 2).getName()+" "
                  +  findBiniary(find2, iDNumber.size() / 2).getRes());
        else
            System.out.println("Такого элемента нет");
    }



}
