package tkoryukalova;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CustomQueue<T> implements Queue<T> {
    private T[] queueArray;
    private int top;
    private int front;
    private int rear;
    private int maxSize;
    private int size;
    private static final String QUEUE_IS_FULL = "Queue is full";
    private static final String QUEUE_IS_EMPTY = "Queue is empty";

    public CustomQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean add(T item) {
        if (isFull()) {
            throw new IllegalStateException(QUEUE_IS_FULL);
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        rear++;
        queueArray[rear] = item;
        size++;
        return true;
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException(QUEUE_IS_EMPTY);
        }
        T temporaryItem = queueArray[front];
        front++;
        if (front == maxSize) {
            front = 0;
        }
        size--;
        return temporaryItem;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return queueArray[front];
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    //region not implemented interface methods
    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public T poll() {
        return null;
    }
    //endregion
}
