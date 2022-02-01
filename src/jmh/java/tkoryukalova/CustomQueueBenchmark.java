package tkoryukalova;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)

public class CustomQueueBenchmark {

    @Benchmark
    public void addHundred() {
        CustomQueue<Integer> queue = new CustomQueue<>(100);
        for (int i = 0; i < 100; i++) {
            queue.add(i);
        }
    }

    @Benchmark
    public void addThousand() {
        CustomQueue<Integer> queue = new CustomQueue<>(1000);
        for (int i = 0; i < 1000; i++) {
            queue.add(i);
        }
    }

    @Benchmark
    public void addTenThousand() {
        CustomQueue<Integer> queue = new CustomQueue<>(10000);
        for (int i = 0; i < 10000; i++) {
            queue.add(i);
        }
    }

    @Benchmark
    public void removeHundred() {
        CustomQueue<Integer> queue = new CustomQueue<>(100);
        for (int i = 0; i < 100; i++) {
            queue.add(i);
        }
        for (int i = 0; i < 100; i++) {
            queue.remove();
        }
    }

    @Benchmark
    public void removeThousand() {
        CustomQueue<Integer> queue = new CustomQueue<>(1000);
        for (int i = 0; i < 1000; i++) {
            queue.add(i);
        }
        for (int i = 0; i < 1000; i++) {
            queue.remove();
        }
    }

    @Benchmark
    public void removeTenThousand() {
        CustomQueue<Integer> queue = new CustomQueue<>(10000);
        for (int i = 0; i < 10000; i++) {
            queue.add(i);
        }
        for (int i = 0; i < 10000; i++) {
            queue.remove();
        }
    }
}
