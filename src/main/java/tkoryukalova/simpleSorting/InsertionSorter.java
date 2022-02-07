package tkoryukalova.simpleSorting;

/**
 * Сортировка методом вставки.
 * Алгоритм:
 * В начале массива находятся частично отсортированные элементы,
 * т.е. каждый последующий больше предыдущего. Эти две части разделены
 * "меткой" out - первый неотсортированный элемент.
 * Помеченный элемент запоминается, отсортированные элементы с последнего сдвигаются
 * на одну позицию до тех пор, пока не найден элемент меньше помеченного.
 * Помеченный элемент вставляется на освободившееся место.
 * Таким образом за один проход по массиву частично отсортированных элементов становится
 * на один больше.
 */
public class InsertionSorter extends AbstractSimpleSorter {

    public InsertionSorter(int[] array) {
        super(array);
    }

    @Override
    public int[] sorting() {
        int in, out;

        for (out = 1; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
        return array;
    }
}
