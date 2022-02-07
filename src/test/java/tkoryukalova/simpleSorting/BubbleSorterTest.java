package tkoryukalova.simpleSorting;

import org.junit.jupiter.api.Test;

class BubbleSorterTest extends SortingTest {
    private int[] array = new int[100];

    @Test
    void sorting() {
        addElementsToArray(array);
        BubbleSorter bubbleSorter = new BubbleSorter(array);
        int[] sortedArray = bubbleSorter.sorting();
        eachPreviousElementLessThanNext(sortedArray);
    }
}