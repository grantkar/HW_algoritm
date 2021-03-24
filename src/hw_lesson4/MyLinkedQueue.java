package hw_lesson4;

public class MyLinkedQueue <T>{
    private MyLinkedList<T> ll = new MyLinkedList<>();

    /**
     * Метод вставки в начало очереди
     * */
    public void insert (T item) {
        ll.insertFirst(item);
    }

    /**
     * Метод удаления элемента с конца очереди
     * */

    public T remove () {
        return ll.removeLast();
    }
    /**
     * Метод получения последнего элемента из очереде
     * */
    public void peek(T item) {
        ll.getLast();
    }

    /**
     * Метод получения размера очереди
     * */

    public int size () {
        return ll.size();
    }

    /**
     * Метод проверки на пустую очередь
     * */
    public boolean isEmpty(){
        return ll.isEmpty();
    }
}
