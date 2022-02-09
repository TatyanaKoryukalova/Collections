package tkoryukalova.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CustomLinkedListTest {
    CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

    @Test
    public void addingItemChangesFullness(){
        assertThat(linkedList.isEmpty()).isTrue();
        linkedList.addFirst(5);
        assertThat(linkedList.isEmpty()).isFalse();
    }

    @Test
    public void removingItemChangesFullness(){
        linkedList.addFirst(5);
        assertThat(linkedList.isEmpty()).isFalse();
        linkedList.removeFirst();
        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    public void firstAddedItemGettingFirst(){
        linkedList.addFirst(10);
        assertThat(linkedList.getFirst()).isEqualTo(10);
    }

    @Test
    public void lastAddedItemGettingLast(){
        linkedList.addLast(10);
        assertThat(linkedList.getLast()).isEqualTo(10);
    }

    @Test
    public void removeFirstInEmptyListThrowsNoSuchElementException(){
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() ->
                linkedList.removeFirst()).withMessage("Список пуст");
    }

    @Test
    public void removeLastInEmptyListThrowsNoSuchElementException(){
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() ->
                linkedList.removeLast()).withMessage("Список пуст");
    }

    @Test
    public void addAfterInEmptyListThrowsNoSuchElementException(){
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() ->
                linkedList.addAfter(5,5)).withMessage("Список пуст");
    }

    @Test
    public void addAfterNonExistentKeyThrowsNoSuchElementException(){
        linkedList.addFirst(1);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() ->
                linkedList.addAfter(5,5)).withMessage("Нет элемента с заданным ключом");
    }

    @Test
    public void removeNonExistentKeyThrowsNoSuchElementException(){
        linkedList.addFirst(1);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() ->
                linkedList.removeKey(5)).withMessage("Нет элемента с заданным ключом");
    }
}