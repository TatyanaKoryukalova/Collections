package tkoryukalova;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)

public class CustomStackBenchmark {

    @Benchmark
    public void pushHundred(){
        CustomStack<Integer> stack = new CustomStack<>(100);
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
    }

    @Benchmark
    public void pushThousand(){
        CustomStack<Integer> stack = new CustomStack<>(1000);
        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
    }

    @Benchmark
    public void pushTenThousand(){
        CustomStack<Integer> stack = new CustomStack<>(10000);
        for (int i = 0; i < 10000; i++) {
            stack.push(i);
        }
    }


    @Benchmark
    public void popHundred(){
        CustomStack<Integer> stack = new CustomStack<>(100);
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 100; i++) {
            stack.pop();
        }
    }


    @Benchmark
    public void popThousand(){
        CustomStack<Integer> stack = new CustomStack<>(1000);
        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 1000; i++) {
            stack.pop();
        }
    }


    @Benchmark
    public void popTenThousand(){
        CustomStack<Integer> stack = new CustomStack<>(10000);
        for (int i = 0; i < 10000; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10000; i++) {
            stack.pop();
        }
    }
}
