package tkoryukalova;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CustomStackTest {

    @Test
    void pushItemsChangesSize() {
        CustomStack<Integer> stack = new CustomStack<>(10);
        stack.push(1);
        assertThat(stack.size()).isEqualTo(1);
        stack.push(2);
        assertThat(stack.size()).isEqualTo(2);
    }

    @Test
    void popLastAddedItemAndRemoveIt(){
        CustomStack<Integer> stack = new CustomStack<>(10);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }


    @Test
    public void pushThrowsIllegalStateException() {
        CustomStack<Integer> stack = new CustomStack<>(1);
        stack.push(1);
        assertThatIllegalStateException().isThrownBy(() -> {
            stack.push(0);
        }).withMessage("Stack is full");
    }

    @Test
    public void popThrowsNoSuchElementException() {
        CustomStack<Integer> stack = new CustomStack<>(1);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            stack.pop();
        }).withMessage("Stack is empty");
    }

    @Test
    void peekLastAddedItem() {
        CustomStack<Integer> stack = new CustomStack<>(10);
        stack.push(1);
        stack.push(2);
        assertThat(stack.peek()).isEqualTo(2);
        assertThat(stack.peek()).isEqualTo(2);
    }

    @Test
    public void peekThrowsNoSuchElementException() {
        CustomStack<Integer> stack = new CustomStack<>(1);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            stack.peek();
        }).withMessage("Stack is empty");
    }

    @Test
    void isEmptyReturnsTrueIfThereAreNotItemsInQueue() {
        CustomStack<Integer> stack = new CustomStack<>(10);
        assertThat(stack.isEmpty()).isTrue();
        stack.push(1);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void isFullReturnsTrueIfThereAreMaxCountItems() {
        CustomStack<Integer> stack = new CustomStack<>(2);
        assertThat(stack.isFull()).isFalse();
        stack.push(1);
        stack.push(2);
        assertThat(stack.isFull()).isTrue();
    }
}