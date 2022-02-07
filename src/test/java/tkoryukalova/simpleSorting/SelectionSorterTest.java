package tkoryukalova.simpleSorting;

import org.junit.jupiter.api.Test;

class SelectionSorterTest extends SortingTest {
    private int[] array = new int[100];

    @Test
    void sorting() {
        addElementsToArray(array);
        SelectionSorter selectionSorter = new SelectionSorter(array);
        int[] sortedArray = selectionSorter.sorting();
        eachPreviousElementLessThanNext(sortedArray);
    }
}