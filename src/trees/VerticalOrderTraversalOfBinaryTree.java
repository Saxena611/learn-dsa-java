package trees;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public int data;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tuple {
        public TreeNode node;
        public int vertical;
        public int level;

        public Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List <List<Integer>> list = new ArrayList< >();
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> findVertical(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
                new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            TreeMap<Integer, PriorityQueue<Integer>> levelToPQ = map.computeIfAbsent(tuple.vertical, s -> new TreeMap<>());
            PriorityQueue<Integer> pq = levelToPQ.computeIfAbsent(tuple.level, s -> new PriorityQueue<>());
            pq.offer(tuple.node.data);

            if (tuple.node.left != null) {
                queue.offer(new Tuple(tuple.node.left, tuple.vertical - 1,  tuple.level + 1));
            }

            if (tuple.node.right != null) {
                queue.offer(new Tuple(tuple.node.right, tuple.vertical + 1, tuple.level + 1));
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levelToPq: map.values()) {
            List<Integer> levelList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes: levelToPq.values()) {
                while (!nodes.isEmpty()) {
                    levelList.add(nodes.poll());
                }
            }
            output.add(levelList);
        }
        return output;
    }
}
