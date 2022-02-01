package tkoryukalova;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Stack<T> {
    private T[] stackArray;
    private int top;
    private int maxSize;
    private static final String STACK_IS_FULL = "Stack is full";
    private static final String STACK_IS_EMPTY = "Stack is empty";

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = (T[]) new Object[maxSize];
        top = -1;
    }

    @Override
    public void push(T item) {
        if (isFull()) {
            throw new IllegalStateException(STACK_IS_FULL);
        }
        top++;
        stackArray[top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException(STACK_IS_EMPTY);
        }
        return stackArray[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException(STACK_IS_EMPTY);
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public int size(){
        return top+1;
    }
}
