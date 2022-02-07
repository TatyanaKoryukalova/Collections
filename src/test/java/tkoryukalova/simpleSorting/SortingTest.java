package tkoryukalova.simpleSorting;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingTest {
    public void addElementsToArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    public void eachPreviousElementLessThanNext(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            assertThat(array[i] <= array[i + 1]).isTrue();
        }
    }
}
