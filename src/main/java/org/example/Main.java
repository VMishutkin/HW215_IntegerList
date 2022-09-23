package org.example;

public class Main {
    public static void main(String[] args) {
        IntegerList intList = new IntegerListImpl(10);

        for (int i = 0; i < 100; i++) {
            intList.add(i*2);
        }
        //System.out.println(intList);
        System.out.println(intList.contains(60));
/*        IntegerList secondList = intList.copyOf();
        IntegerList thirdList = intList.copyOf();

        Long start = System.currentTimeMillis();
        intList.qsort();
        //System.out.println(intList.qsort());
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        secondList.csort();
        //System.out.println(secondList.csort());
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        //System.out.println(thirdList.isort());
        thirdList.isort();
        System.out.println(System.currentTimeMillis() - start);

        //System.out.println(intList.csort());*/

    }
}