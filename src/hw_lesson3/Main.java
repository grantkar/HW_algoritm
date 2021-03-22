package hw_lesson3;

public class Main {
    public static void main(String[] args) {


       String str = "asd bjd ckj dsfd esdf fkj";
        System.out.println(revToString(str));
        System.out.println(revToChar(str));

        MyDeque <Integer> myDeque = new MyDeque<>();
        for (int i = 0; i < 3; i++) {
            myDeque.insertLeft(i);
        }
        System.out.println(myDeque.toString());

        for (int i = 5; i < 9; i++) {
            myDeque.insertRight(i);
        }
        System.out.println(myDeque.toString());

        myDeque.removeLeft();
        myDeque.removeRight();
        System.out.println(myDeque.toString());

    }


    /**
     * Метод переворачивания строки
     * только по словам
     * */

    public static String revToString (String str){
        MyStack <String> myStack = new MyStack<>(50);
        String [] strArr = str.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            myStack.push(strArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(myStack.pop() + " ");
        }
        return sb.toString();
    }

    /**
     * Метод переворачивания строки
     * только по символам
     * */

    public static String revToChar (String str){
        MyStack <Character> myStack = new MyStack<>(50);
        char [] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            myStack.push(charArray[i]);
        }

        StringBuilder sbChar = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            sbChar.append(myStack.pop());
        }
        return sbChar.toString();
    }

}
