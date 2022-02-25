package tkoryukalova.hashtable;

import java.util.NoSuchElementException;

public class CustomHashTable<T> implements HashTable<T> {
    private Node<T>[] hashTable;
    private int numberOfItems;
    private Node<T> nonItem;
    private static final String NEGATIVE_KEY_MESSAGE = "Ключ может быть только положительным числом";
    private static final String NON_EXISTENT_ELEMENT_MESSAGE = "Элемент не найден";
    private static final String EXISTENT_ELEMENT_MESSAGE = "Элемент с таким ключом уже существует";

    private class Node<T> {
        int key;
        T data;

        Node(int key, T data) {
            this.key = key;
            this.data = data;
        }
    }

    public CustomHashTable(int size) {
        int arrayLength = getPrime(size * 2);
        hashTable = new Node[arrayLength];
        numberOfItems = 0;
        nonItem = new Node<>(-1, null);
    }

    @Override
    public int size() {
        return numberOfItems;
    }

    @Override
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    @Override
    public void insert(int key, T value) {
        if (isFull()) {
            increaseTableLength();
        }
        keyValidate(key);

        int hashValue = hashFunction(key);
        int stepSize = hashFunctionForStep(key);
        while (isFilledCell(hashTable[hashValue])) {
            if (hashTable[hashValue].key == key) {
                throw new IllegalArgumentException("Элемент с таким ключом уже существует");
            }
            hashValue += stepSize;
            hashValue %= hashTable.length;
        }
        Node<T> newNode = new Node<>(key, value);
        hashTable[hashValue] = newNode;
        numberOfItems++;
    }

    @Override
    public T delete(int key) {
        keyValidate(key);
        int hashValue = hashFunction(key);
        int stepSize = hashFunctionForStep(key);
        while (hashTable[hashValue] != null) {
            if (hashTable[hashValue].key == key) {
                Node<T> temporary = hashTable[hashValue];
                hashTable[hashValue] = nonItem;
                numberOfItems--;
                return temporary.data;
            }
            hashValue += stepSize;
            hashValue %= hashTable.length;
        }
        throw new NoSuchElementException("Элемент не найден");
    }

    @Override
    public T find(int key) {
        keyValidate(key);
        int hashValue = hashFunction(key);
        int stepSize = hashFunctionForStep(key);
        while (hashTable[hashValue] != null) {
            if (hashTable[hashValue].key == key) {
                return hashTable[hashValue].data;
            }
            hashValue += stepSize;
            hashValue %= hashTable.length;
        }
        throw new NoSuchElementException("Элемент не найден");
    }

    private int getPrime(int length) {
        while (true) {
            if ((isPrime(length))) {
                return length;
            }
            length++;
        }
    }

    private boolean isPrime(int length) {
        for (int i = 2; i * i <= length; i++) {
            if (length % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int hashFunction(int key) {
        return key % hashTable.length;
    }

    private int hashFunctionForStep(int key) {
        return 5 - (key % 5);
    }

    private boolean isFull() {
        return numberOfItems == hashTable.length;
    }

    private void keyValidate(int key) {
        if (key < 0) {
            throw new IllegalArgumentException("Ключ может быть только положительным числом");
        }
    }

    private void increaseTableLength() {
        CustomHashTable<T> newTable = new CustomHashTable<>(numberOfItems);
        for (int i = 0; i < numberOfItems; i++) {
            if (isFilledCell(hashTable[i])) {
                newTable.insert(hashTable[i].key, hashTable[i].data);
            }
        }
        this.hashTable = newTable.hashTable;
        this.numberOfItems = newTable.numberOfItems;
    }

    private boolean isFilledCell(Node<T> tNode) {
        return tNode != null && tNode.key != -1;
    }
}
