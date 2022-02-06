package tkoryukalova;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ArrayListImplBenchmark {

    @Benchmark
    public void addLast1000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(String.valueOf(i));
        }
    }

    @Benchmark
    public void addLast10000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(String.valueOf(i));
        }
    }

    @Benchmark
    public void addLast100000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(String.valueOf(i));
        }
    }

    @Benchmark
    public void addFirst1000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, String.valueOf(i));
        }
    }

    @Benchmark
    public void addFirst10000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, String.valueOf(i));
        }
    }

    @Benchmark
    public void addFirst100000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, String.valueOf(i));
        }
    }

    @Benchmark
    public void removeFirst1000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(String.valueOf(i));
        }
        for (int i = 0; i < 1000; i++) {
            arrayList.remove(0);
        }
    }

    @Benchmark
    public void removeFirst10000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(String.valueOf(i));
        }
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(0);
        }
    }

    @Benchmark
    public void removeFirst100000() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(String.valueOf(i));
        }
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(0);
        }
    }
}
