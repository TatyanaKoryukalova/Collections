package tkoryukalova.binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class InitialisationForBenchmark {
    protected ArrayList<Integer> initialisationLists(int count) {
        ArrayList<Integer> randomIntegerList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomIntegerList.add(i);
        }
        Collections.shuffle(randomIntegerList);
        return randomIntegerList;
    }

    protected void fillTree(CustomBinaryTree<Integer> tree, ArrayList<Integer> sourceList, int counter) {
        for (int i = 0; i < counter; i++) {
            tree.insert(sourceList.get(i));
        }
    }

    protected void clearTree(CustomBinaryTree<Integer> tree, int counter) {
        for (int i = 0; i < counter; i++) {
            tree.delete(i);
        }
    }
}
