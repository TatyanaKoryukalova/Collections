package tkoryukalova.linkedlist;

import java.util.Deque;
import java.util.NoSuchElementException;

public interface DoublyLinkedList<T> extends Deque<T> {
    /**
     * Вставляет указанный элемент в список после элемента с заданным ключом.
     * Предполагается, что список не пуст.
     *
     * @param key
     * @param item
     * @throws NoSuchElementException если список пуст или нет элемента с заданным ключом
     */
    void addAfter(T key, T item);

    /**
     * Удаляет элемент с заданным ключом.
     *
     * @param key - ключ удаляемого элемента
     * @return - удаленный элемент
     * @throws NoSuchElementException если список пуст или нет элемента с заданным ключом
     */
    T removeKey(T key);
}
