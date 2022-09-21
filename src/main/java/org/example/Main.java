package org.example;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(5);
        stringList.add("Hello!");
        stringList.add("HI!");
        System.out.println(stringList.size());
        System.out.println(stringList);
        System.out.println(stringList);
        stringList.remove("HI!");
        System.out.println(stringList);
        stringList.add(1, "Second String");
        System.out.println(stringList);
         stringList.add("How are you doing?");
        stringList.add("WHATSAAAAAP");
        stringList.remove(2);
        System.out.println(stringList);
        System.out.println(stringList.size());

        StringList otherList = new StringListImpl(7);
        otherList.add("Hello!");
        otherList.add(1, "Second String");
        System.out.println(stringList);
        System.out.println(otherList);
        System.out.println(stringList.equals(otherList));

    }
}