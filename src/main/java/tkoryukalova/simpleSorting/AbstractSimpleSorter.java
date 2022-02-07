package tkoryukalova.simpleSorting;

public abstract class AbstractSimpleSorter implements Sorting {
    protected int[] array;

    public AbstractSimpleSorter(int[] array) {
        this.array = copyOf(array);
    }

    /**
     * Метод меняет местами два элемента в массиве
     *
     * @param first  индекс первого элемента
     * @param second индекс второго элемента
     */
    protected void swap(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Возвращает копию переданного в метод массива
     *
     * @param originArray - исходный массив
     * @return - копия массива
     */
    private int[] copyOf(int[] originArray) {
        int[] copiedArray = new int[originArray.length];
        for (int i = 0; i < originArray.length; i++) {
            copiedArray[i] = originArray[i];
        }
        return copiedArray;
    }
}
