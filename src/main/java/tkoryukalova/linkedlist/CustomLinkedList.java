package tkoryukalova.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements DoublyLinkedList<T> {
    private Link<T> first;
    private Link<T> last;
    private static final String EMPTY_LIST_MASSAGE = "Список пуст";
    private static final String NO_SUCH_ELEMENT_MASSAGE = "Нет элемента с заданным ключом";

    public CustomLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public void addFirst(T data) {
        Link<T> item = new Link<>(data);
        if (isEmpty()) {
            last = item;
        } else {
            first.previous = item;
            item.next = first;
        }
        first = item;
    }

    @Override
    public void addLast(T data) {
        Link<T> item = new Link<>(data);
        if (isEmpty()) {
            first = item;
        } else {
            last.next = item;
            item.previous = last;
        }
        last = item;
    }

    @Override
    public void addAfter(T key, T data) {
        fullnessListValidate();
        Link<T> current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException(NO_SUCH_ELEMENT_MASSAGE);
            }
        }
        Link<T> newItem = new Link<>(data);
        if (current == last) {
            newItem.next = null;
            last = newItem;
        } else {
            newItem.next = current.next;
            current.next.previous = newItem;
        }
        newItem.previous = current;
        current.next = newItem;
    }

    @Override
    public T removeFirst() {
        fullnessListValidate();
        Link<T> temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp.data;
    }

    @Override
    public T removeLast() {
        fullnessListValidate();
        Link<T> temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp.data;
    }

    @Override
    public T removeKey(T key) {
        fullnessListValidate();
        Link<T> current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException(NO_SUCH_ELEMENT_MASSAGE);
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    private void fullnessListValidate() {
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_MASSAGE);
        }
    }

    private class Link<T> {
        T data;
        Link<T> next;
        Link<T> previous;

        Link(T data) {
            this.data = data;
        }
    }

    //region методы интерфейсов использующие основную логику
    @Override
    public T getFirst() {
        fullnessListValidate();
        return first.data;
    }

    @Override
    public T getLast() {
        fullnessListValidate();
        return last.data;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.data;
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            return null;
        }
        return last.data;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public void push(T t) {
        addFirst(t);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }
    //endregion

    //region заглушки для нереализованных методов
    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
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
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
    public Iterator<T> descendingIterator() {
        return null;
    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return false;
    }
    //endregion
}
