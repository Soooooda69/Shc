import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    public T[] Adeque;
    private int head;
    private int tail;

    /**create an empty list.*/
    public ArrayDeque() {
        Adeque = (T[]) new Object[8];
        head = 0;
        tail = 1;
        size = 0;
    }

    /**move the index to the back.*/
    public int moveback (int index) {
        index = (index + 1) % (Adeque.length);
        return index;
    }

    /**move the index to the forth.*/
    public int moveforth (int index) {
        index = (index + Adeque.length-1) % (Adeque.length);
        return index;
    }

    /**resize.*/
    private void resize (int capacity) {
        T [] a = (T[])new Object [capacity];
        System.arraycopy(Adeque,head,a,0,size);
        Adeque = a;
    }

    /**up size and down size.*/
    private void ifUpsize () {
        if (size == Adeque.length) {
            resize(Adeque.length * 2);
        }
    }

    private void ifDownsize () {
        if (size <= 0.25 * Adeque.length && Adeque.length >= 16) {
            resize(Adeque.length / 2);
        }
    }


    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        ifUpsize();
        if (Adeque[head] == null) {
            tail = tail - 1;
        }
        Adeque [tail] = item;
        tail = moveback(tail);
        size += 1;
    }

    /**Adds an item of type T to the front of the deque.*/
    public  void  addFirst(T item) {
        ifUpsize();
        Adeque [head] = item;
        head = moveforth(head);
        size += 1;
    }

    /**Removes and returns the item at the front of the deque.
     *If no such item exists, returns null.*/
    public T removeFirst() {
        ifDownsize();
        T rmf = Adeque [head];
        Adeque [head] = null;
        head = moveback(head);
        if (!isEmpty()) {
            size -= 1;
            return rmf;
        }
        return null;
    }

    /**Removes and returns the item at the back of the deque.
     *If no such item exists, returns null.*/
    public T removeLast() {
        ifDownsize();
        T rml = Adeque [moveforth(tail)];
        Adeque [moveforth(tail)] = null;
        tail = moveforth(tail);
        if (!isEmpty()) {
            size -= 1;
            return rml;
        }
        return null;
    }



    /**Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /**Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**Gets the item at the given index, where 0 is the front,
     *1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!*/
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index >= size) {
            return null;
        }
        return Adeque [index];
    }

    /**Prints the items in the deque from first to last.*/
    public void printDeque() {
        for (int i=head; i!=tail; moveback(i)) {
            System.out.print(Adeque[i]+" ");
        }
        System.out.println();
    }

    /**Creates a deep copy of other. */
    public ArrayDeque(ArrayDeque other) {
        T [] copy = (T[]) new Object [other.size];
        head = other.head;
        tail = other.tail;
        System.arraycopy(other.Adeque,0,copy,0,other.size);
    }
}

