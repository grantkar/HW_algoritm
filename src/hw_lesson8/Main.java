package hw_lesson8;

import java.util.Random;

public class Main {
    static Random random;

    public static void main(String[] args) {
        random = new Random();

//        ChainingHashMap<Integer, String> chm= new ChainingHashMap<>(7);

//        chm.put(1, "one");
//        chm.put(2, "two");
//        chm.put(3, "three");
//        System.out.println(chm.get(2));

//        for (int i = 0; i < 12; i++) {
//            chm.put(random.nextInt(100), "");
//        }

//        System.out.println(chm.delete(2,"two"));
//        System.out.println(chm);

        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>(10);
        lphm.put(1, "one");
        lphm.put(2, "two");
        lphm.put(3, "three");
        lphm.put(2, "twosdfsdf");

        System.out.println(lphm.get(2));

    }
}
