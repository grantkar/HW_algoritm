package hw_lesson4;

public class MyLinkedStack <T> {
    private MyLinkedList<T> ll = new MyLinkedList<>();

    /**
     * Метод вставки в конец стека
     * */
    public void push(T item){
        ll.insertLast(item);
    }

    /**
     * Метод извлечения элемента с конца стека
     * */
    public T peek(){
        return ll.getLast();
    }
    /**
     * Метод удаления последнего элемента стека
     * */
    public T pop(){

        return ll.removeLast();
    }
    /**
     * Метод получения количества элементов в стеке
     * */
    public int size(){
        return ll.size();
    }
    /**
     * Метод проверки на пустой стек
     * */
    public boolean isEmpty(){
        return ll.isEmpty();
    }
}
