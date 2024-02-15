import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    public void test() {
        sortTests();
        mergeTests();
        merge_in_place_tests();
        sort_in_place_tests();
        testMergeAgain();
        testSortAgain();
        testSortSmall();
        moreTests();
        testSortAgain();
        testingSortingArrays();
    }


    @Test
    public void sortTests(){
        //example list
        Node node1 = new Node(5, new Node(2, new Node(7, new Node(1, null))));
        Node goal1 = new Node(1, new Node(2, new Node(5, new Node(7, null))));
        Node result1 = MergeSort.sort(node1);
        assertEquals("1, 2, 5, 7", result1.toString());
       //assertNotSame(node1, result1);
        assertTrue(Utils.is_permutation(node1, result1));
        assertTrue(Utils.is_sorted(result1));

        //null list
        Node node2 = null;
        Node goal2 = null;
        Node result2 = MergeSort.sort(node2);
        assertEquals(null, result2);
        assertTrue(Utils.is_sorted(result2));

        //length 1 list
        Node node3 = new Node(1, null);
        Node goal3 = new Node(1, null);
        Node result3 = MergeSort.sort(node3);
        assertEquals("1", result3.toString());
       // assertNotSame(node3, result3);
        assertTrue(Utils.is_sorted(result3));

    }

    @Test
    public void testSortSmall() {
        Node list = new Node(5, null);
        Node sorted = MergeSort.sort(list);
        assertEquals(list.data, sorted.data);
        assertNull(sorted.next);

        Node sortedInPlace = MergeSort.sort_in_place(list);
        assertEquals(list.data, sortedInPlace.data);
        assertNull(sortedInPlace.next);
    }

    @Test
    public void mergeTests() {
        Node node1 = new Node(1, new Node(3, null));
        Node node11 = new Node(2, new Node(6, null));
        Node goal1 = new Node(1, new Node(2, new Node(3, new Node(6, null))));
        Node result1 = MergeSort.merge(node1, node11);
        Node pre1node = Utils.nth_node(node1, 1);
        Node post1node = Utils.nth_node(result1, 1);

        assertEquals("1, 2, 3, 6", result1.toString());
        //assertNotSame(pre1node, post1node);
        assertTrue(Utils.is_sorted(result1));

        Node node2 = null;
        Node node22 = null;
        Node result2 = MergeSort.merge(node2,node22);

        assertNull(result2);
        assertTrue(Utils.is_sorted(result2));

        Node node31 = new Node(1, null);
        Node node32 = null;
        Node result3 = MergeSort.merge(node31, node32);

        assertEquals("1", result3.toString());
        assertTrue(Utils.is_sorted(result3));

    }

    @Test
    public void merge_in_place_tests(){
        Node node1A = new Node(1, new Node(3, null));
        Node node1B = new Node(2, new Node(4, null));
        Node result1 = MergeSort.merge_in_place(node1A, node1B);

        assertEquals("1, 2, 3, 4", result1.toString());
       // assertSame(node1A.data, result1.data);
        assertTrue(Utils.is_permutation(node1A, result1));
        assertTrue(Utils.is_sorted(result1));

        Node node2A = null;
        Node node2B = null;
        Node result2 = MergeSort.merge_in_place(node2A, node2B);

        assertEquals(null, result2);
        assertTrue(Utils.is_sorted(result2));

        Node node3A = new Node(2, new Node(4, null));
        Node node3B = null;
        Node result3 = MergeSort.merge_in_place(node3A, node3B);

        assertEquals("2, 4", result3.toString());
        assertTrue(Utils.is_sorted(result3));

    }

    @Test
    public void testingSortingArrays() {
        int[] array1 = {5, 1, 4, 2, 3, 6};
        Node originalList = Utils.array_to_list(array1);

        Node sorted = MergeSort.sort(Utils.copy(originalList));
        Node sortedInPlace = MergeSort.sort_in_place(Utils.copy(originalList));

        int[] sortedArray = Utils.list_to_array(sorted);
        int[] sortedInPlaceArray = Utils.list_to_array(sortedInPlace);

        Arrays.sort(array1);

        assertArrayEquals(array1, sortedArray);
        assertArrayEquals(array1, sortedInPlaceArray);
    }

    @Test
    public void sort_in_place_tests(){
        //example list
        Node node1 = new Node(5, new Node(2, new Node(7, new Node(1, null))));
        Node goal1 = new Node(1, new Node(2, new Node(5, new Node(7, null))));
        Node result1 = MergeSort.sort_in_place(node1);
        assertEquals("1, 2, 5, 7", result1.toString());
        assertTrue(Utils.is_sorted(result1));

        //null list
        Node node2 = null;
        Node goal2 = null;
        Node result2 = MergeSort.sort_in_place(node2);
        assertEquals(null, result2);
        assertTrue(Utils.is_sorted(result2));

        //length 1 list
        Node node3 = new Node(1, null);
        Node goal3 = new Node(1, null);
        Node result3 = MergeSort.sort_in_place(node3);
        assertEquals("1", result3.toString());
       // assertSame(node3, result3);
        assertTrue(Utils.is_sorted(result3));

    }

    @Test
    public void moreTests() {
        Node list = new Node(5, null);
        Node sorted = MergeSort.sort_in_place(list);
        assertEquals(list.data, sorted.data);
        assertNull(sorted.next);
    }

    @Test
    public void testMergeAgain() {
        Node list1 = Utils.array_to_list(new int[]{1, 3, 5, 7, 9});
        Node list2 = Utils.array_to_list(new int[]{2, 4, 6, 8, 10});
        Node merged = MergeSort.merge(list1, list2);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = Utils.list_to_array(merged);
        assertTrue(Utils.is_sorted(merged));
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortAgain() {
        Node list1 = Utils.array_to_list(new int[]{4, 1, 5, 2, 3, 6});
        Node sorted = MergeSort.sort(list1);
        assertTrue(Utils.is_sorted(sorted));
    }




    
}
