package tkoryukalova.hashtable;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CustomHashTableTest {
    CustomHashTable<Integer> table = new CustomHashTable<>(10);
    private static final String NEGATIVE_KEY_MESSAGE = "Ключ может быть только положительным числом";
    private static final String NON_EXISTENT_ELEMENT_MESSAGE = "Элемент не найден";
    private static final String EXISTENT_ELEMENT_MESSAGE = "Элемент с таким ключом уже существует";

    @Test
    void sizeIsChangedByInsertionAndDeleting() {
        assertThat(table.size()).isEqualTo(0);
        for (int i = 0; i < 10; i++) {
            table.insert(i, i);
        }
        assertThat(table.size()).isEqualTo(10);
        table.delete(0);
        assertThat(table.size()).isEqualTo(9);
    }

    @Test
    void isEmptyIsChangedByInsertion() {
        assertThat(table.isEmpty()).isTrue();
        table.insert(0, 0);
        assertThat(table.isEmpty()).isFalse();
    }

    @Test
    void insertedElementSuccessfullyFound() {
        table.insert(0, 5);
        table.insert(12, 9);
        assertThat(table.find(0)).isEqualTo(5);
        assertThat(table.find(12)).isEqualTo(9);
    }

    @Test
    void insertExistentElementThrowsException() {
        table.insert(0, 1);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> table.insert(0, 8))
                .withMessage(EXISTENT_ELEMENT_MESSAGE);
    }

    @Test
    void insertionByNegativeKeyThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> table.insert(-1, 0))
                .withMessage(NEGATIVE_KEY_MESSAGE);
    }

    @Test
    void successfulDeletedElementReturnValue() {
        table.insert(78, 96);
        assertThat(table.delete(78)).isEqualTo(96);

    }

    @Test
    void deletingByNegativeKeyThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> table.delete(-1))
                .withMessage(NEGATIVE_KEY_MESSAGE);
    }

    @Test
    void deleteNonExistentElementThrowsException() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> table.delete(5))
                .withMessage(NON_EXISTENT_ELEMENT_MESSAGE);
    }

    @Test
    void findNonExistentElementThrowsException() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> table.find(5))
                .withMessage(NON_EXISTENT_ELEMENT_MESSAGE);
    }

    @Test
    void searchByNegativeKeyThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> table.find(-1))
                .withMessage(NEGATIVE_KEY_MESSAGE);
    }
}