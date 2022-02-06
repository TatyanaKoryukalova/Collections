package tkoryukalova;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayListImplTest {

    @Test
    void add() {
        ArrayListImpl<String> test = new ArrayListImpl<>();
        assertThat(test.add("Hello"));
        assertThat(test.get(0)).isEqualTo("Hello");
        assertThat(test.size()).isEqualTo(1);
    }

    @Test
    void addAt() {
        Integer[] intArray = new Integer[]{0,1,2,3,4,5,6,7,8,9,10};
        ArrayListImpl<Integer> test = new ArrayListImpl<Integer>(intArray);
        test.add(2,1);
    }

    @Test
    void addThrowsIndexOutOfBoundsException() {
        ArrayListImpl<String> test = new ArrayListImpl<>();
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() ->
                test.add(2, "Some string"));
    }

    @Test
    void remove() {
        ArrayListImpl<String> test = new ArrayListImpl<>(new String[]
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
        assertTrue(test.remove("5"));
        assertFalse(test.remove("5"));
    }

    @Test
    void removeReturnsDeletedItem() {
        ArrayListImpl<String> test = new ArrayListImpl<>(new String[]
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
        assertThat(test.remove(2)).isEqualTo("3");
        assertFalse(test.contains("3"));
    }

    @Test
    void isEmpty() {
        ArrayListImpl<String> test = new ArrayListImpl<>();
        assertTrue(test.isEmpty());
        test.add("1");
        assertFalse(test.isEmpty());
    }

    @Test
    void addingItemsChangesSize() {
        ArrayListImpl<String> test = new ArrayListImpl<>();
        assertThat(test.size()).isEqualTo(0);
        test.add("1");
        assertThat(test.size()).isEqualTo(1);
    }

    @Test
    void contains() {
        ArrayListImpl<String> test = new ArrayListImpl<>(new String[]
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
        assertTrue(test.contains("5"));
        assertFalse(test.contains("10"));
    }

    @Test
    void subList() {
        ArrayListImpl<String> test = new ArrayListImpl<>(new String[]
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
        List<String> subList = test.subList(1,5);
        assertThat(subList.get(0)).isEqualTo("2");
        assertThat(subList.size()).isEqualTo(4);
    }

    @Test
    void indexOf() {
        ArrayListImpl<String> test = new ArrayListImpl<>(new String[]
                {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
        assertThat(test.indexOf("1")).isEqualTo(0);
        assertThat(test.indexOf("55")).isEqualTo(-1);
    }
}