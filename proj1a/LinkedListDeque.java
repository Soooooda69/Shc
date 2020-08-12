public class LinkedListDeque <T> {

    /**Creates an empty linked list deque.*/
    public LinkedListDeque() {
        sentinel = new deque(null, null ,null);
        sentinel.back = sentinel;
        sentinel.front = sentinel;
        size =0;
    }

    public LinkedListDeque(T i) {
        sentinel = new deque(null, null, null);
        sentinel.back = new deque(null, i, null);
        sentinel.front = sentinel.back;
        size = 1;
    }

    public class deque {
        public T item;
        public deque front;
        public deque back;

        public deque(deque f, T i, deque b) {
            front = f;
            item = i;
            back = b;
        }
    }

    private deque sentinel;
    private int size;

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        sentinel.back = new deque(sentinel, item, sentinel.back);
        sentinel.back.back.front = sentinel.back;
        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        sentinel.front = new deque(sentinel.front, item, sentinel);
        sentinel.front.front.back = sentinel.front;
        size += 1;
    }

    /**
     * Returns the number of items in the deque
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        T i = sentinel.back.item;
        if (isEmpty() == false) {
            sentinel.back = sentinel.back.back;
            sentinel.back.front = sentinel;
            size -= 1;
            return i;
        } else {
            return null;
        }
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        T i = sentinel.front.item;
        if (isEmpty() == false) {
            sentinel.front = sentinel.front.front;
            sentinel.front.back = sentinel;
            size -= 1;
            return i;
        } else  {
            return null;
        }
    }

    /**Prints the items in the deque from first to last,
     *separated by a space. Once all the items have been printed,
     *  print out a new line.*/
    public void printDeque() {
        deque print = sentinel.back;
        for (int i=0; i<size; i+=1) {
            System.out.print(print.item +" ");
            print = print.back;
        }
        System.out.println();
    }

    /**Gets the item at the given index, where 0 is the front,
     *1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!*/
    public T get(int index) {
        deque get = sentinel.back;
        for (int i=0; i<index; i++) {
            get = get.back;
        }
        return get.item;
    }

    /**Same as get, but uses recursion.*/
    private T getR(int i, deque get){
        if (i == 0){
            return get.item;
        }
        return getR(i-1, get.back);
    }
    public T getRecursive(int index) {
        if (index>size-1){
            return null;
        }
        return getR(index, sentinel.back);
    }

    /**Creates a deep copy.*/
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new deque(null, null, null);
        sentinel.front = sentinel;
        sentinel.back = sentinel;
        size = 0;
        for (int i=0; i<other.size(); i++){
            addLast((T) other.get(i));
        }
    }
}