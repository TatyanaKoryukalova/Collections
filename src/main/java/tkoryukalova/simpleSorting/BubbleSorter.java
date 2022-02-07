package tkoryukalova.simpleSorting;

/**
 * Пузырьковая сортировка - самый медленный, но концептуально простой алгоритм.
 * Алгоритм:
 * В один момент времени сравниваются два соседних значения. Если первое больше второго, они
 * меняются местами, в противном случае остаются на своих местах. Алготирм смещается на шаг вперед.
 * Таким образом за первый проход по массиву самый большой элемент гарантированно находится последним.
 * При следующем проходе его рассматривать смысла уже нет.
 */
public class BubbleSorter extends AbstractSimpleSorter {

    public BubbleSorter(int[] array) {
        super(array);
    }

    @Override
    public int[] sorting() {
        int out, in;

        for (out = array.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
        return array;
    }
}
