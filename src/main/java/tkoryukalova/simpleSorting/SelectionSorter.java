package tkoryukalova.simpleSorting;

/**
 * Сортировка методом выбора.
 * Алгоритм:
 * Запомнить первое значение как наименьшее и последовательно сравнивать его с каждым
 * значением в массиве. Если очередное значение меньше минимума, то меняем этот
 * элемент с первым, значение запоминаем как минимальное.
 * После первого прохода по массиву отсортированные значения оказываются в начале,
 * при следующих проходах их не трогаем.
 */
public class SelectionSorter extends AbstractSimpleSorter {

    public SelectionSorter(int[] array) {
        super(array);
    }

    @Override
    public int[] sorting() {
        int out, in, min;

        for (out = 0; out < array.length; out++) {
            min = out;
            for (in = out + 1; in < array.length; in++) {
                if (array[in] < array[min]) {
                    min = in;
                }
            }
            swap(out, min);
        }
        return array;
    }
}
