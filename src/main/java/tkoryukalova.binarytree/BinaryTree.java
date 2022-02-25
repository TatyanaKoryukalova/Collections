package tkoryukalova.binarytree;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Двоичное дерево поиска - структура, имеющая один "корень". Каждый узел имеет не более двух потомков
 * При этом левый будет меньше родителя, правый больше
 * Не допускает существование одинаковых значений
 *
 * @param <T>
 */
public interface BinaryTree<T extends Comparable<T>> {
    /**
     * Находит и возвращает значение по заданному ключу
     *
     * @param value - ключевое значение
     * @return - искомое значение
     * @throws NoSuchElementException   - если не найден узел с ключом value
     * @throws IllegalArgumentException - если узел с заданным ключом уже существует
     */
    T find(T value);

    /**
     * Вставляет в двоичное дерево поиска элемент на подходящее ему место,
     * изначально проводится поиск узла родителя, после которого можно вставить
     * переданное значение
     *
     * @param data - значение нового узла
     * @throws IllegalArgumentException - если узел с заданным ключом уже существует
     */
    void insert(T data);

    /**
     * Удаляет узел с заданным ключом.
     * Позже напишу подробнее
     *
     * @param key - ключевое значение удаляемого узла
     * @return - удаленный узел
     * @throws NoSuchElementException - если не найден узел с ключом key
     */
    boolean delete(T key);

    /**
     * Добавляет в переданную коллекцию элементы дерева в порядке прямого обхода.
     *
     * @param collection
     * @param localRoot
     */
    void preOrder(Collection<T> collection, Node<T> localRoot);

    /**
     * Добавляет в переданную коллекцию элементы дерева в порядке симметричного обхода.
     *
     * @param collection
     * @param localRoot
     */
    void inOrder(Collection<T> collection, Node<T> localRoot);

    /**
     * Добавляет в переданную коллекцию элементы дерева в порядке обратного обхода.
     *
     * @param collection
     * @param localRoot
     */
    void postOrder(Collection<T> collection, Node<T> localRoot);

    /**
     * Возвращает true, если дерево не содержит элементов
     *
     * @return true, если дерево не содержит элементов
     */
    boolean isEmpty();
}
