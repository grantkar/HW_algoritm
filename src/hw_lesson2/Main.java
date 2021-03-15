package hw_lesson2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            mal.add(r.nextInt(1000));
        }

        int start = (int) System.currentTimeMillis();
        //     mal.selectionSort();  // Примерно 9,5 секунды
       //    mal.insertionSort();    // Примерно 3,5 секунды
      //     mal.bubbleSort();      // Примерно 24,5 секунды

     int finish = (int) System.currentTimeMillis();
     int time = finish - start;
     System.out.println(time);
    }
}
