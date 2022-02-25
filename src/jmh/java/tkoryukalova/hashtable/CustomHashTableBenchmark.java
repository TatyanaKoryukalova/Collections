package tkoryukalova.hashtable;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 2)
@Measurement(iterations = 50, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class CustomHashTableBenchmark extends InitialisationBenchmark {
    @Setup(Level.Invocation)
    public void setupList() {
        listInitialisation();
    }

    @Benchmark
    public void insert100Elements() {
        CustomHashTable<Integer> hashTable = new CustomHashTable<>(100);
        fillTable(hashTable, 100);
    }

    @Benchmark
    public void insert1000Elements() {
        CustomHashTable<Integer> hashTable = new CustomHashTable<>(1000);
        fillTable(hashTable, 1000);
    }

    @Benchmark
    public void insert10000Elements() {
        CustomHashTable<Integer> hashTable = new CustomHashTable<>(10000);
        fillTable(hashTable, 10000);
    }

    @Benchmark
    public void insertAndDelete100Elements() {
        CustomHashTable<Integer> hashTable = new CustomHashTable<>(100);
        fillTable(hashTable, 100);
        clearTable(hashTable, 100);
    }

    @Benchmark
    public void insertAndDelete1000Elements() {
        CustomHashTable<Integer> hashTable = new CustomHashTable<>(1000);
        fillTable(hashTable, 1000);
        clearTable(hashTable, 1000);
    }

    @Benchmark
    public void insertAndDelete10000Elements() {
        CustomHashTable<Integer> hashTable = new CustomHashTable<>(10000);
        fillTable(hashTable, 10000);
        clearTable(hashTable, 10000);
    }

}
