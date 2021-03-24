package hw_lesson4;

import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        MyLinkedList <Integer> ml = new MyLinkedList<>();

        ml.insertFirst(1);
        ml.insertFirst(2);
        ml.insertFirst(3);
        ml.insertFirst(4);

        for (Integer i : ml) {
            System.out.println(i);
        }

        ListIterator<Integer> li = ml.listiterator();
        while(li.hasNext()){
            System.out.println(li.next());
        }
    }
}
