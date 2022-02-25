package tkoryukalova.binarytree;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BinaryTreeDeletingBenchmark extends InitialisationForBenchmark {
    ArrayList<Integer> randomHundredIntegers;
    ArrayList<Integer> randomThousandIntegers;
    ArrayList<Integer> randomTenThousandIntegers;

    @Setup(Level.Invocation)
    public void startInitialisation() {
        randomHundredIntegers = initialisationLists(100);
        randomThousandIntegers = initialisationLists(1000);
        randomTenThousandIntegers = initialisationLists(10000);
    }

    @Benchmark
    public void fillAndClear100() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        fillTree(tree, randomHundredIntegers, 100);
        clearTree(tree, 100);
    }

    @Benchmark
    public void fillAndClear1000() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        fillTree(tree, randomThousandIntegers, 1000);
        clearTree(tree, 1000);
    }

    @Benchmark
    public void fillAndClear10000() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        fillTree(tree, randomTenThousandIntegers, 10000);
        clearTree(tree, 10000);
    }
}
