package tkoryukalova.binarytree;

public class Node<T extends Comparable<T>> {
    protected T data;
    protected Node<T> leftChild;
    protected Node<T> rightChild;

    protected Node(T data) {
        this.data = data;
    }

    protected boolean hasNotLeftChild() {
        return leftChild == null;
    }

    protected boolean hasNotRightChild() {
        return rightChild == null;
    }
}
