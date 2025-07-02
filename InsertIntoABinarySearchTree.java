package interviewQA.Trees.BinarySearchTrees;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode prev = null;
        TreeNode node = root;
        while(node != null){
            prev = node;
            if(val < node.val){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        TreeNode treeNode = new TreeNode(val);
        if(val < prev.val){
            prev.left = treeNode;
        }else{
            prev.right = treeNode;
        }

        return root;
    }
}
