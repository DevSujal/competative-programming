import javax.naming.LinkException;

public class LinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public String toString() {
            return this.data + "\n";
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addLast(int data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
    }

    public void addFirst(int data) {
        if (head == null) {
            head = tail = new Node(data);
            return;
        }

        head.next = new Node(data);
    }

    public Node delete(int data) {
        if (head == null) {
            System.out.println("linked list is empty");
            return null;
        }

        if (head.data == data) {
            Node ptr = head;
            head = head.next;
            return ptr;
        }

        Node ptr = head.next;
        Node prev = head;
        while (ptr != null) {

            if (ptr.data == data) {
                prev.next = prev.next.next;
                return ptr;
            }
            prev = ptr;
            ptr = ptr.next;
        }

        return null;
    }

    public String toString() {

        if (head == null)
            return "[]";

        Node ptr = head;

        String s = "";
        while (ptr.next != null) {
            s += ptr.data + " -> ";
            ptr = ptr.next;
        }

        s += ptr.data;

        return s;
    }

    public Node reversLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newNode = reversLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public Node findMidOfLinkedList(Node head) {
        if(head == null) return null;
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrom() {
        Node mid = findMidOfLinkedList(head);
        Node left = head;
        Node right = reversLinkedList(mid);

        while (left != null && right != null) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public Node isCycleExist() {
        if (head == null)
            return null;
        if (head.next == null)
            return null;
        Node ptr = head.next;
        Node prev = head;

        while (ptr != null && ptr.next != null) {
            if (ptr == prev)
                return ptr;
            ptr = ptr.next.next;
            prev = prev.next;
        }
        return null;
    }

    public Node removeLinkedList() {
        Node slow = head, fast = this.isCycleExist();

        if (fast == null)
            return null;

        Node prev = fast;
        while (slow != fast && fast.next != slow) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        return prev;
    }

    // public static Node intersection(Node head1, Node head2, Node prev) {
    // if(head1 == null || head2 == null) return null;
    // prev = head1;
    // Node node = intersection(head1.next, head2.next, prev);

    // if(node == null && head1 != head2) return prev;
    // else return node;
    // }
    public static Node intersection(Node head1, Node head2) {
        Node carA = head1, carB = head2;

        while (carA != carB) {
            if (carA == null)
                carA = head2;
            if (carB == null)
                carB = head1;

            carA = carA.next;
            carB = carB.next;
        }

        return carA;
    }

    public static Node mergeTwoLinkedList(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node top = merged;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                merged.next = head1;
                merged = merged.next;
                head1 = head1.next;
            } else {
                merged.next = head2;
                merged = merged.next;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            merged.next = head1;
        }
        if (head2 != null) {
            merged.next = head2;
        }

        return top.next;
    }

    public Node mergeSortForLinkedList(Node head) {

        if (head == null || head.next == null)
            return head;
        
        Node mid = findMidOfLinkedList(head);

        Node leftHead = head, rightHead = mid.next;
        mid.next = null;

        leftHead = mergeSortForLinkedList(leftHead);
        rightHead = mergeSortForLinkedList(rightHead);
        return mergeTwoLinkedList(leftHead, rightHead);

    }
}

class Test4 {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        LinkedList newList = new LinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(8);
        list.addLast(9);
        // list.addLast(1);
        // LinkedList.Node node = list.tail;
        // LinkedList.Node newnode = newList.tail;
        list.addLast(4);
        list.addLast(5);

        // newnode.next = node.next;
        // newnode.next.next = node.next.next;
        // list.addLast(5);
        // list.head = list.reversLinkedList(list.head);
        // System.out.println(list.isPalindrom());
        // System.out.println(list.isCycleExist());
        // System.out.println(list.removeLinkedList());
        // System.out.println(list);
        // System.out.println(newList);

        // System.out.println(LinkedList.intersection(list.head, newList.head));
        // System.out.println(list);
        // System.out.println(newList);

        // LinkedList mergedList = new LinkedList();
        // mergedList.head = LinkedList.mergeTwoLinkedList(list.head, newList.head);
        // System.out.println(mergedList);

        list.head = list.mergeSortForLinkedList(list.head);

        System.out.println(list);
    }
}
