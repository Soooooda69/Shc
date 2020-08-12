public class LinkedListDeque <T> {

    public class deque {
        public deque front;
        public T item;
        public deque back;


        public deque(deque f, T i, deque b) {

            front = f;
            item = i;
            back = b;
        }
    }
/** the 1st item before adding is add.next*/
    private deque add;
    private int size;

    public LinkedListDeque (deque f,T i,deque b){
        add = new deque (null,null, null);
        add.front = add;
        add.back = add;
        size = 0;
    }


    public void addFirst(T item) {
        /*Adds an item of type T to the front of the deque.*/
        /**add and remove operations must not involve any looping or recursion.
         *  A single such operation must take “constant time”,
         *   i.e. execution time should not depend on the size of the deque.
         */
        add.back = new deque(add, item, add.back.back);
        size += 1;



    }



    public void addLast(T t){
        /**Adds an item of type T to the back of the deque.*/
        add.back.item = t;
        size += 1;

    }


    public int size(){
        /**Returns the number of items in the deque.*/
        return size;
    }


    public boolean isEmpty(int size){
        /**Returns true if deque is empty, false otherwise.*/
        if (size == 0 ){
            return true;
        }
        return false;
    }



    public void printDeque(){
        /**
         * Prints the items in the deque from first to last, separated by a space.
         * Once all the items have been printed, print out a new line.
         */
        if (size == 0){
            System.out.println("Deque is empty.");
        }
        System.out.print(add.item);
    }


    public T removeFirst(){
        /**
         * Removes and returns the item at the front of the deque. If no such item exists, returns null.
         */
        if (add.front.item != null){
            return null;
        }
        add.front.item = null;
        return null;

    }


    public T removeLast(){
        /**
         * Removes and returns the item at the back of the deque. If no such item exists, returns null.
         */
        if (add.back.item != null){
            return null;
        }
        add.back.item = null;
        return null;

    }


    public T get(int index){
        /**
         * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
         * If no such item exists, returns null. Must not alter the deque!
         */
        if (size == 0){
            return null;
        }
        return add.item;

    }
}
