package tkoryukalova;

import org.junit.jupiter.api.Test;
import tkoryukalova.CustomQueue;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CustomQueueTest {

    @Test
    void addingItemsChangesSize() {
        CustomQueue<Integer> queue = new CustomQueue<>(10);
        assertThat(queue.size()).isEqualTo(0);
        queue.add(20);
        assertThat(queue.size()).isEqualTo(1);
        queue.add(10);
        assertThat(queue.size()).isEqualTo(2);
    }

    @Test
    void removingItemsChangesSize(){
        CustomQueue<Integer> queue = new CustomQueue<>(10);
        queue.add(20);
        assertThat(queue.size()).isEqualTo(1);
        queue.remove();
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    void removingFirstAddedItem(){
        CustomQueue<Integer> queue = new CustomQueue<>(10);
        queue.add(20);
        queue.add(10);
        assertThat(queue.remove()).isEqualTo(20);
    }

    @Test
    void addThrowsIllegalStateException() {
        CustomQueue<Integer> queue = new CustomQueue<>(2);
        queue.add(20);
        queue.add(10);
        assertThatIllegalStateException().isThrownBy(() -> {
            queue.add(0);
        }).withMessage("Queue is full");
    }

    @Test
    void removeThrowsNoSuchElementException() {
        CustomQueue<Integer> queue = new CustomQueue<>(10);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            queue.remove();
        }).withMessage("Queue is empty");
    }

    @Test
    void peekFirstAddedItem() {
        CustomQueue<Integer> queue = new CustomQueue<>(10);
        queue.add(20);
        queue.add(10);
        assertThat(queue.peek()).isEqualTo(20);
    }

    @Test
    public void peekEmptyQueueReturnsNull() {
        CustomQueue<Integer> queue = new CustomQueue<>(10);
        assertThat(queue.peek()).isNull();
    }

    @Test
    void isEmptyReturnsTrueIfThereAreNotItemsInQueue() {
        CustomQueue<Integer> test = new CustomQueue<>(10);
        assertThat(test.isEmpty()).isTrue();
        test.add(10);
        assertThat(test.isEmpty()).isFalse();
    }

    @Test
    void isFullReturnsTrueIfThereAreMaxCountItems() {
        CustomQueue<Integer> test = new CustomQueue<>(10);
        assertThat(test.isFull()).isFalse();
        for (int i = 0; i < 10; i++) {
            test.add(i);
        }
        assertThat(test.isFull()).isTrue();
    }

    @Test
    void sizeChangesWithAddingItems() {
        CustomQueue<Integer> test = new CustomQueue<>(10);
        assertThat(test.size()).isEqualTo(0);
        test.add(1);
        assertThat(test.size()).isEqualTo(1);
    }
}