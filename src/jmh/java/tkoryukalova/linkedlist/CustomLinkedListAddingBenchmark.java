package tkoryukalova.linkedlist;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 50, time = 10, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class CustomLinkedListAddingBenchmark extends BenchmarkListInitialisation {
    @Benchmark
    public void addFirst100() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillFirst(linkedList, 100);
    }

    @Benchmark
    public void addFirst1000() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillFirst(linkedList, 1000);
    }

    @Benchmark
    public void addFirst10000() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillFirst(linkedList, 10000);
    }

    @Benchmark
    public void addLast100() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillLast(linkedList, 100);
    }

    @Benchmark
    public void addLast1000() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillLast(linkedList, 1000);
    }

    @Benchmark
    public void addLast10000() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillLast(linkedList, 10000);
    }

    @Benchmark
    public void addAfter100() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillAfter(linkedList, 100);
    }

    @Benchmark
    public void addAfter1000() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillAfter(linkedList, 1000);
    }

    @Benchmark
    public void addAfter10000() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        fillAfter(linkedList, 10000);
    }
}
