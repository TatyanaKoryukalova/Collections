package tkoryukalova.simpleSorting;

import org.junit.jupiter.api.Test;

class InsertionSorterTest extends SortingTest {
    private int[] array = new int[100];

    @Test
    void sorting() {
        addElementsToArray(array);
        InsertionSorter insertionSorter = new InsertionSorter(array);
        int[] sortedArray = insertionSorter.sorting();
        eachPreviousElementLessThanNext(sortedArray);
    }
}