package hw_lesson3;

import java.util.NoSuchElementException;

public class MyDeque <T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;



    public MyDeque(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    /**
     * Метод добавления в начало очереди нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insertLeft(T item) throws IllegalStateException {
        if (isFull()) {
            //реализовать расширение массива
            throw new IllegalStateException("Очередь заполнена");
        }
        begin = previewsIndex(begin);
        list[begin] = item;
        size++;

    }
    /**
     * Метод добавления в конец очереди нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */

    public void insertRight(T item) throws IllegalStateException {
        if (isFull()) {
            //реализовать расширение массива
            throw new IllegalStateException("Очередь заполнена");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }
    public T peekOpposite() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[end];
    }

    /**
     * Метод удаления элемента из начала очереди
     */

    public T removeLeft() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }
    /**
     * Метод удаления элемента из конца очереди
     */

    public T removeRight() {
        T temp = peekOpposite();
        end = previewsIndex(end);
        list[end] = null;
        size--;

        return temp;
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {

        return size;
    }

    private int nextIndex(int index) {

        return (index + 1) % list.length;
    }

    private int previewsIndex(int index) {
        return (list.length + index -1) % list.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        int i = begin;
        while (i != end) {
            sb.append(list[i]).append(", ");
            i = nextIndex(i);
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
