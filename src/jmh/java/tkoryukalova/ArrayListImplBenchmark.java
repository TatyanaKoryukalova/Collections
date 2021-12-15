package tkoryukalova;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ArrayListImplBenchmark {
    ArrayListImpl<String> arrayList = new ArrayListImpl<>();

    @Setup(Level.Trial)
    public void setUp() {
        for (int i = 0; i < 100; i++) {
            arrayList.add(Integer.toString(i));
        }
    }

    @Benchmark
    public void addLast() {
        arrayList.add("100");
    }

    @Benchmark
    public void addFirst() {
        arrayList.add(0, "0");
    }

    @Benchmark
    public void get() {
        arrayList.get(5);
    }

    @Benchmark
    public void indexOf() {
        arrayList.indexOf("50");
    }

    @Benchmark
    public void remove() {
        arrayList.remove("51");
    }

    @Benchmark
    public void removeAt() {
        arrayList.remove(50);
    }
}
