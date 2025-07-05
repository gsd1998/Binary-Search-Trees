package interviewQA.Trees.BinarySearchTrees;

import java.util.List;

public class InorderSuccessor_PredecessorInBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right= new TreeNode(9);
        root.right.right.left= new TreeNode(8);
        root.right.right.right= new TreeNode(10);

        int val = 8;
        int result1 = inorderSuccessor(root, val);
        int result2 = inorderPredecessor(root, val);
        System.out.println(result1);
        System.out.println(result2);
    }

    public static int inorderSuccessor(TreeNode root, int val){
        int ceil = -1;
        while(root != null) {
            if(val == root.val){
               break;
            }
            else if(val < root.val) {
                ceil = root.val;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return ceil;
    }

    public static int inorderPredecessor(TreeNode root, int val){
        int floor = -1;
        while(root != null) {
            if(val == root.val){
                break;
            }
            if(val < root.val) {
                root = root.left;
            }
            else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }
}
