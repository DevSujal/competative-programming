import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        public String toString() {
            return this.data + "";
        }
    }

    static class Info {
        int dia, height;

        Info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left != null) {
                q.add(temp.left);
            } else {
                temp.left = new Node(data);
                return root;
            }
            if (temp.right != null) {
                q.add(temp.right);
            } else {
                temp.right = new Node(data);
                return root;
            }
        }

        return root;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(int data) {
        return search(root, data);
    }

    public void printLevelOrder() {
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }

                q.add(null);
                continue;
            }

            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    class Pair {
        Node node; int level;
        Pair(Node root, int level){
            this.node = root;
            this.level = level;
        }
    }

    public int sumOfKthLevel(int level) {
        Queue<Pair> q = new LinkedList<>();
        int sum = 0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair temp = q.poll();

            if(temp.level == level) sum += temp.node.data;
            if (temp.node.left != null) {
                q.add(new Pair(temp.node.left, temp.level + 1));
            }
            if (temp.node.right != null) {
                q.add(new Pair(temp.node.right, temp.level + 1));
            }
        }

        return sum;
    }

    private boolean search(Node root, int data) {
        if (root == null)
            return false;

        if (root.data == data)
            return true;

        if (data < root.data)
            return search(root.left, data);
        else
            return search(root.right, data);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int countNoOfNodes() {
        return countNoOfNodes(root);
    }

    private int countNoOfNodes(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int leftNodes = countNoOfNodes(root.left);
        int rightNodes = countNoOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public int sum() {
        return sum(root);
    }

    private int sum(Node root) {
        if (root == null)
            return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;
    }

    public int diameter() {
        System.out.println(diameter(root));
        return diameterOn(root).dia;
    }

    private int diameter(Node root) {
        if (root == null)
            return 0;

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);

        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(Math.max(diam1, diam2), diam3);
    }

    private Info diameterOn(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info left = diameterOn(root.left);
        Info right = diameterOn(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.dia;
        int diam2 = right.dia;

        int diam3 = left.dia + right.dia + 1;

        int myDiam = (Math.max(diam3, Math.max(diam1, diam2)));
        return new Info(myDiam, myHeight);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // public int sumOfKthLevel(int k)
}

class BinaryTest {
    public static void main(String[] args) {
        BinaryTree bs = new BinaryTree();
        bs.insert(1);
        bs.insert(2);
        bs.insert(3);
        bs.insert(4);
        bs.insert(5);
        bs.insert(6);

        // bs.inorderTraversal();
        // bs.preOrderTraversal();
        // bs.postOrderTraversal();

        // System.out.println(bs.search(30));
        // System.out.println(bs.height());

        // System.out.println(bs.countNoOfNodes());
        // System.out.println(bs.sum());

        // System.out.println(bs.diameter());

        // System.out.println(bs.isBalanced());
        bs.printLevelOrder();
        System.out.println(bs.sumOfKthLevel(2));
    }

}
