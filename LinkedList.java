public class LinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
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
        if(head == null  || head.next == null){
            return head;
        }

        Node newNode = reversLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

}

class Test4 {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.head = list.reversLinkedList(list.head);
        System.out.println(list);
    }
}
