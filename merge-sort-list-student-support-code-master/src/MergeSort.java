import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    static Node merge(Node A, Node B) {
        Node newbie = null;
        if(A == null){
            return B;
        }
        if (B == null){
            return A;
        }
        if(A == null && B == null){
            return null;
        }


        if (A.data <= B.data) {
            newbie = new Node(A.data, null);
            newbie.next = merge(A.next, B);
        } else {
            newbie = new Node(B.data, null);
            newbie.next = merge(A, B.next);
        }
        return newbie;
    }

    static Node sort(Node N) {
        if(N == null){
            return null;
        }

        int length = Utils.length(N);

        if (length<2){
            return Utils.copy(N);
        }

        //make first half
        Node first = Utils.take(N, (length/2));
        //second half
        Node second = Utils.drop(N, (length/2));

        first = sort(first);
        second = sort(second);


        //merge
         Node sorted = merge(first, second);
         return sorted;
    }

    static Node merge_in_place(Node A, Node B) {

        if (A == null){
            return B;
        }
        if (B==null){
            return A;
        }

        Node dummyHead = new Node(0, null);
        Node current = dummyHead;

        while (A != null && B != null) {
            if (A.data <= B.data) {
                current.next = A;
                A = A.next;
            } else {
                current.next = B;
                B = B.next;
            }
            current = current.next;
        }


        current.next = (A != null) ? A : B;

        return dummyHead.next;
    }


    static Node sort_in_place(Node N) {
        if (N == null || N.next == null) {
            return N;
        }

        int length = Utils.length(N);

        int middleIndex = length / 2;

        Node current = N;
        for (int i = 0; i < middleIndex - 1; i++) {
            current = current.next;
        }


        Node middle = current.next;
        current.next = null;


        Node first = sort_in_place(N);
        Node second = sort_in_place(middle);


        Node sorted = merge_in_place(first, second);

        return sorted;
    }

}
