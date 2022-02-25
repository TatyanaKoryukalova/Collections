package tkoryukalova.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitialisationBenchmark {
    protected static List<Integer> sourceList;

    protected void listInitialisation() {
        sourceList = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            sourceList.add(i);
        }
        Collections.shuffle(sourceList);
    }

    protected void fillTable(CustomHashTable<Integer> table, int counter) {
        int value;
        for (int i = 0; i < counter; i++) {
            value = sourceList.get(i);
            table.insert(value, value);
        }
    }

    protected void clearTable(CustomHashTable<Integer> table, int counter) {
        int value;
        for (int i = 0; i < counter; i++) {
            value = sourceList.get(i);
            table.delete(value);
        }
    }

}
