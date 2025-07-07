package interviewQA.Trees.BinarySearchTrees;

public class RecoverBinarySearchTree {
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inOrder(root);
        if(first != null && last != null){
            int x = first.val;
            first.val = last.val;
            last.val = x;
        }else if(first != null && middle != null){
            int x = first.val;
            first.val = middle.val;
            middle.val = x;
        }
    }

    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        if(root.val < prev.val){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
}
