public class ArrayDeque <T> {
    private int size;
    private T[] Adeque;

    /**create an empty list.*/
    public ArrayDeque() {
        Adeque = (T[]) new Object[8];
        size = 0;
    }

    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        Adeque [size] = item;
        size += 1;
    }

    /**Adds an item of type T to the front of the deque.*/
    public  void  addFirst(T item) {

    }

    /**Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

}

