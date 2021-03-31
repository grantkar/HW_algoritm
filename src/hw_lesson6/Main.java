package hw_lesson6;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Random rd = new Random();

        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();

        int countOfTrees = 200000;

        int balanced = 0;
        for (int i = 0; i < countOfTrees; i++) {
            fillTreeMap(map);
            if (map.isBalanced()) {
                balanced++;
            }
        }
        System.out.println("Из " + countOfTrees + " MyTreeMap сбалансированы " + balanced + "\r\nнесбалансированы " + (countOfTrees - balanced) + " деревьев");
        System.out.println("Несбалансированы " + ((((float) (countOfTrees - balanced)) * 100) / (float) countOfTrees) + " %");
    }


    public static void fillTreeMap(MyTreeMap<Integer, Integer> map) {
        while (map.getHeight() < 6) {
            map.put(ThreadLocalRandom.current().nextInt(-100,100), 0);
        }


    }
}
