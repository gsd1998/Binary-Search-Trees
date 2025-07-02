package interviewQA.Trees.BinarySearchTrees;

public class ValidateBinarySearchTree {
    boolean flag = true;
    long var = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }
    //Here we use inorder traversal and binary search tree property that inorder traversal of a BST is always sorted
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(var >= root.val){
            flag = false;
            return;
        }else{
            var = root.val;
        }
        inorder(root.right);
    }
}
