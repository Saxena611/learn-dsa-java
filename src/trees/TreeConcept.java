package trees;

import java.util.*;

public class TreeConcept {

    static class Node {

        private Node left;
        private Node right;
        private int data;


        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        root.left = n1;
        root.right = n2;
        Node n3  = new Node(4);
        Node n4 = new Node(5);
        n1.left = n3;
        n1.right = n4;
//        Un-comment to unbalance the tree.
//        Node n5 = new Node(6);
//        n3.left = n5;

        System.out.println("Executing for pre-order traversal...");
        preOrderTraversal(root);

        System.out.println("Executing for post-order traversal...");
        postOrderTraversal(root);

        System.out.println("Executing for in-order traversal...");
        inOrderTraversal(root);

        System.out.println("Executing level wise traversal...");
        levelOrderTraversal(root);

        System.out.println("Calculating height of binary tree");
        System.out.println(maxHeightOfBinaryTree(root));

        System.out.println("Peforming isBalanced tree check");
        System.out.println(isBalancedTree(root));
    }


    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public static void levelOrderTraversal(Node root) {
        List<List<Integer>> levelWise = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();


        if (root == null) {
            return;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (level > 0) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }

                levelList.add(queue.poll().data);
                level--;
            }
            levelWise.add(levelList);
        }

        System.out.println(levelWise);
    }

    public static int maxHeightOfBinaryTree(Node root) {
        if (root ==  null) {
            return 0;
        }

        int leftHeight = maxHeightOfBinaryTree(root.left);
        int rightHeight = maxHeightOfBinaryTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalancedTree(Node root) {
        return checkForBalancedBinaryTree(root) != -1;
    }

    public static int checkForBalancedBinaryTree(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = checkForBalancedBinaryTree(root.left);
        int rightHeight = checkForBalancedBinaryTree(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);

    }

    


}
