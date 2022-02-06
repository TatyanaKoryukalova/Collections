package tkoryukalova;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("unchecked")
public class ArrayListImpl<E> implements List<E> {
    private E[] data;
    private int size;
    private final static int DEFAULT_CAPACITY = 10;

    public ArrayListImpl() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayListImpl(E[] data) {
        this.data = data;
        this.size = data.length;
    }

    @Override
    public boolean add(E newItem) {
        increaseLengthOfFilledArray();
        data[size] = newItem;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object itemToRemove) {
        int index = indexOf(itemToRemove);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public void add(int index, E item) {
        if (index == size) {
            add(item);
            return;
        }
        increaseLengthOfFilledArray();
        elementExistenceCheck(index);
        for (int i = size; i < index; i++) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    @Override
    public E remove(int index) {
        elementExistenceCheck(index);
        E deletedItem = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return deletedItem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        E[] newDataArray = copyOfRange(data, fromIndex, toIndex);
        return new ArrayListImpl<>(newDataArray);
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private void elementExistenceCheck(int index) {
        if (index < 0 && index > (size - 1)) {
            throw new IndexOutOfBoundsException("There is no element with this index");
        }
    }

    private E[] copyOf(E[] sourceArray, int newLength) {
        int counter = newLength > sourceArray.length ? sourceArray.length : newLength;
        E[] newArray = (E[]) new Object[newLength];
        for (int i = 0; i < counter; i++) {
            newArray[i] = sourceArray[i];
        }
        return newArray;
    }

    private E[] copyOfRange(E[] sourceArray, int fromIndex, int toIndex) {
        E[] newArray = (E[]) new Object[toIndex - fromIndex];
        int counter = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            newArray[counter] = sourceArray[i];
            counter++;
        }
        return newArray;
    }

    private void increaseLengthOfFilledArray() {
        if (size == data.length) {
            int newLength = (int) (data.length * 1.5);
            data = copyOf(data, newLength);
        }
    }

    //region заглушки для нереализованных методов
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public void clear() {

    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
    //endregion
}
