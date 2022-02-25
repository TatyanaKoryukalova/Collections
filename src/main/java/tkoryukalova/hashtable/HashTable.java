package tkoryukalova.hashtable;

import java.util.NoSuchElementException;

public interface HashTable<T> {
    /**
     * Вставляет указанный элемент в таблицу
     *
     * @param key   - ключ элемента, не может быть отрицательным
     * @param value - значение элемента
     * @throws IllegalArgumentException - в случае, если переданный ключ отрицательный,
     *                                  или же если существует элемент с заданным ключом
     */
    void insert(int key, T value);

    /**
     * Удаляет элемент таблицы с указанным ключом
     *
     * @param key - ключ удаляемого элемента
     * @return - удаленный элемент
     * @throws IllegalArgumentException - в случае, если переданный ключ отрицательный
     * @throws NoSuchElementException   - в случае, когда элемент с таким ключом не найден
     */
    T delete(int key);

    /**
     * Ищет в таблице элемент с заданным ключом и возвращает его значение
     *
     * @param key - ключ искомого элемента
     * @return - значение элемента с указанным ключом
     * @throws IllegalArgumentException - в случае, если переданный ключ отрицательный
     * @throws NoSuchElementException   - в случае, когда элемент с таким ключом не найден
     */
    T find(int key);

    /**
     * Возвращает количество элементов таблицы
     *
     * @return - количество элементов таблицы
     */
    int size();

    /**
     * Возвращает true, в случае если в таблице нет элементов и false, если есть хотя бы один
     *
     * @return - true, в случае если в таблице нет элементов
     */
    boolean isEmpty();
}
