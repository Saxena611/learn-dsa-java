package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryLevelTraversal {

    public static void main(String[] args) {
        TreeConcept.Node root = new TreeConcept.Node(1);
        root.left = new TreeConcept.Node(2);
        root.left.left = new TreeConcept.Node(3);
        root.left.left.right = new TreeConcept.Node(4);
        root.left.left.right.left = new  TreeConcept.Node(5);
        root.left.left.right.right = new  TreeConcept.Node(6);
        root.right = new  TreeConcept.Node(7);
        root.right.right = new  TreeConcept.Node(8);
        root.right.right.left = new  TreeConcept.Node(9);
        root.right.right.left.left = new  TreeConcept.Node(10);
        root.right.right.left.right = new  TreeConcept.Node(11);

        List<Integer> boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
    }

    static List < Integer > printBoundary(TreeConcept.Node node) {
        List <Integer> ans = new ArrayList<Integer>();
        if (node == null) {
            return Collections.emptyList();
        }
        if (isLeaf(node) == false) ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }

    public static void addRightBoundary(TreeConcept.Node root, List<Integer> boundaryList) {
        TreeConcept.Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        int i;
        for (i = temp.size() - 1; i >= 0; --i) {
            boundaryList.add(temp.get(i));
        }
    }

    public static void addLeaves(TreeConcept.Node root, List<Integer> boundaryList) {
        // simple pre-order traversal to add only leaf nodes.
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            boundaryList.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, boundaryList);
        }
        if (root.right != null) {
            addLeaves(root.right, boundaryList);
        }
    }

    public static void addLeftBoundary (TreeConcept.Node root, List<Integer> boundaryList) {
        TreeConcept.Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                boundaryList.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static boolean isLeaf(TreeConcept.Node root) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        return false;
    }
}
