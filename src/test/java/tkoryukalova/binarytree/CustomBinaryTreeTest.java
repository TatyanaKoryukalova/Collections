package tkoryukalova.binarytree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class CustomBinaryTreeTest {
    @Test
    public void isEmptyChangedByInsertion() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        assertThat(binaryTree.isEmpty()).isTrue();
        binaryTree.insert("Hello");
        assertThat(binaryTree.isEmpty()).isFalse();
    }

    @Test
    public void insertionExistingItemThrowsIllegalArgumentException() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        binaryTree.insert("Hello");
        assertThatIllegalArgumentException().isThrownBy(() ->
                binaryTree.insert("Hello")).withMessage("Узел с таким ключом уже существует");
    }

    @Test
    public void findNonExistentItemThrowsNoSuchElementException() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() ->
                binaryTree.find("Hello")).withMessage("Узел с ключевым значением не найден");
    }

    @Test
    public void deleteNonExistentItemThrowsNoSuchElementException() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        CustomBinaryTree<String> tree = new CustomBinaryTree<>();
        binaryTree.insert("Hi");
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() ->
                tree.delete("Hello")).withMessage("Узел с ключевым значением не найден");
    }

    @Test
    public void searchReturnsKeyValue() {
        CustomBinaryTree<Integer> tree = initialisationRandomValuesTo20();
        int checkedValue = new Random().nextInt(20);
        assertThat(tree.find(checkedValue)).isEqualTo(checkedValue);
    }

    @Test
    public void deleteSingleNode() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        tree.insert(7);
        assertThat(tree.delete(7)).isTrue();
    }

    @Test
    public void deleteLeafNode() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        tree.insert(5);
        tree.insert(0);
        assertThat(tree.delete(0)).isTrue();
    }

    @Test
    public void deleteNodeWithOnlyLeftChild() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        assertThat(tree.delete(4)).isTrue();
    }

    @Test
    public void deleteNodeWithOnlyRightChild() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        assertThat(tree.delete(1)).isTrue();
    }

    @Test
    public void deleteNodeWithTwoChildren() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(9);
        assertThat(tree.delete(5)).isTrue();
    }

    @Test
    public void fillsQueueInAscendingOrder() {
        CustomBinaryTree<Integer> tree = initialisationRandomValuesTo20();
        Queue<Integer> queue = new LinkedList<>();
        tree.inOrder(queue, tree.getRoot());
        for (int i = 0; i < 20; i++) {
            assertThat(queue.remove()).isEqualTo(i);
        }
    }

    private CustomBinaryTree<Integer> initialisationRandomValuesTo20() {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        ArrayList<Integer> randomIntegerList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            randomIntegerList.add(i);
        }
        Collections.shuffle(randomIntegerList);

        int counter = randomIntegerList.size();
        for (int i = 0; i < counter; i++) {
            tree.insert(randomIntegerList.get(i));
        }
        return tree;
    }
}