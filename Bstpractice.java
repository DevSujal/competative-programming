import java.util.*;
public class Bstpractice {
    Node root = null;

    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return data + "";
        }
    }

    public Node buildTree(int arr[]) {
        for (int j : arr) {
            root = insert(root, j);
        }

        return root;
    }

    public Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // public void inorderTraversal() {
    // inorderTraversal(root);
    // System.out.println();
    // }

    public void rangeTraversal(Node root, int x, int y) {
        if (root != null) {

            if (root.data >= x && root.data <= y) {
                System.out.print(root.data + " ");
            }
            if (root.data < x) {
                rangeTraversal(root.right, x, y);
            } else if (root.data > y)
                rangeTraversal(root.left, x, y);
            else {
                rangeTraversal(root.left, x, y);
                rangeTraversal(root.right, x, y);
            }
        }
    }
    ArrayList<Node> path = new ArrayList<>();
    public void rootToLeafPaths(Node root) {
        if(root == null) return;
        path.add(root);
        if(root.left == null && root.right == null) {
            System.out.println(path);
        }else {
            rootToLeafPaths(root.left);
            rootToLeafPaths(root.right);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        Bstpractice bst = new Bstpractice();
        bst.buildTree(new int[] { 5, 1, 3, 4, 2, 7 });
        // bst.rangeTraversal(bst.root, 4, 7);
        bst.rootToLeafPaths(bst.root);
    }
}
