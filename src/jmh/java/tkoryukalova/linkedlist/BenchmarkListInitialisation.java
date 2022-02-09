package tkoryukalova.linkedlist;

public class BenchmarkListInitialisation {
    public void fillFirst(CustomLinkedList<Integer> linkedList, int counter) {
        for (int i = 0; i < counter; i++) {
            linkedList.addFirst(i);
        }
    }

    public void fillLast(CustomLinkedList<Integer> linkedList, int counter) {
        for (int i = 0; i < counter; i++) {
            linkedList.addLast(i);
        }
    }

    public void fillAfter(CustomLinkedList<Integer> linkedList, int counter) {
        linkedList.addFirst(0);
        for (int i = 1; i < counter; i++) {
            linkedList.addAfter(i - 1, i);
        }
    }

    public void clearFirst(CustomLinkedList<Integer> linkedList, int counter){
        for (int i = 0; i < counter; i++) {
            linkedList.removeFirst();
        }
    }

    public void clearLast(CustomLinkedList<Integer> linkedList, int counter){
        for (int i = 0; i < counter; i++) {
            linkedList.removeLast();
        }
    }

    public void clearByKey(CustomLinkedList<Integer> linkedList, int counter){
        int counterKey = counter;
        for (int i = 0; i < counter; i++) {
            linkedList.removeKey(counterKey);
            counterKey--;
        }
    }
}
