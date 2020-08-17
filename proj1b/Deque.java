public interface Deque<T> {

    void addFirst(T item);

    void addLast(T item);

    int size();

    boolean isEmpty();

    T removeFirst();

    T removeLast();

    void printDeque();

    T get(int index);
}
