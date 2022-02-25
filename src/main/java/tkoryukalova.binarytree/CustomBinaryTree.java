package tkoryukalova.binarytree;

import java.util.Collection;
import java.util.NoSuchElementException;

public class CustomBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {
    private static final String EXISTING_KEY_MASSAGE = "Узел с таким ключом уже существует";
    private static final String NOT_FIND_KEY_MASSAGE = "Узел с ключевым значением не найден";
    private Node<T> root;
    private boolean isLeftChild;

    @Override
    public T find(T key) {
        if (isEmpty()) {
            throw new NoSuchElementException(NOT_FIND_KEY_MASSAGE);
        }
        Node<T> current = root;
        while (!current.data.equals(key)) {
            if (current == null) {
                throw new NoSuchElementException(NOT_FIND_KEY_MASSAGE);
            }
            int compareResult = key.compareTo(current.data);
            if (compareResult < 0) {
                current = current.leftChild;
                continue;
            }
            current = current.rightChild;
        }
        return current.data;
    }

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            root = newNode;
            return;
        }
        Node<T> current = root;
        while (true) {
            int compareResult = data.compareTo(current.data);
            if (compareResult == 0) {
                throw new IllegalArgumentException(EXISTING_KEY_MASSAGE);
            }
            if (compareResult < 0) {
                if (current.hasNotLeftChild()) {
                    current.leftChild = newNode;
                    return;
                }
                current = current.leftChild;
                continue;
            }
            if (current.hasNotRightChild()) {
                current.rightChild = newNode;
                return;
            }
            current = current.rightChild;
        }
    }

    @Override
    public boolean delete(T key) {
        if (isEmpty()) {
            throw new NoSuchElementException(NOT_FIND_KEY_MASSAGE);
        }

        Node<T> parent = root;
        Node<T> current = root;
        while (!current.data.equals(key)) {
            parent = current;
            if (current == null) {
                throw new NoSuchElementException(NOT_FIND_KEY_MASSAGE);
            }
            int compareResult = key.compareTo(current.data);
            if (compareResult < 0) {
                isLeftChild = true;
                current = current.leftChild;
                continue;
            }
            isLeftChild = false;
            current = current.rightChild;
        }

        if (isNodeALeaf(current)) {
            swapNodes(null, current, parent);
            return true;
        }
        if (current.hasNotRightChild()) {
            swapNodes(current.leftChild, current, parent);
            return true;
        }
        if (current.hasNotLeftChild()) {
            swapNodes(current.rightChild, current, parent);
            return true;
        }
        Node<T> successor = getSuccessor(current);
        swapNodes(successor, current, parent);
        successor.leftChild = current.leftChild;
        return true;
    }

    private void swapNodes(Node<T> child, Node<T> current, Node<T> parent) {
        if (current == root) {
            root = child;
            return;
        }
        if (isLeftChild) {
            parent.leftChild = child;
            return;
        }
        parent.rightChild = child;
    }

    private Node<T> getSuccessor(Node<T> delNode) {
        Node<T> successorParent = delNode;
        Node<T> successor = delNode;
        Node<T> current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (!successor.equals(delNode.rightChild)) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    private boolean isNodeALeaf(Node<T> current) {
        return current.hasNotLeftChild() && current.hasNotRightChild();
    }

    @Override
    public void preOrder(Collection<T> collection, Node<T> localRoot) {
        if (localRoot != null) {
            collection.add(localRoot.data);
            preOrder(collection, localRoot.leftChild);
            preOrder(collection, localRoot.rightChild);
        }
    }

    @Override
    public void inOrder(Collection<T> collection, Node<T> localRoot) {
        if (localRoot != null) {
            inOrder(collection, localRoot.leftChild);
            collection.add(localRoot.data);
            inOrder(collection, localRoot.rightChild);
        }
    }

    @Override
    public void postOrder(Collection<T> collection, Node<T> localRoot) {
        postOrder(collection, localRoot.leftChild);
        postOrder(collection, localRoot.rightChild);
        collection.add(localRoot.data);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public Node<T> getRoot() {
        return root;
    }
}
