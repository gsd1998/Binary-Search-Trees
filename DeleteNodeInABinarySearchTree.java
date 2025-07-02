package interviewQA.Trees.BinarySearchTrees;

public class DeleteNodeInABinarySearchTree {
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return helper(root);
        }
        TreeNode curr = root;
        while(curr != null){
            if(val < curr.val){
                if(curr.left != null && curr.left.val == val){
                    curr.left = helper(curr.left);
                }else{
                    curr = curr.left;
                }
            }else{
                if(curr.right != null && curr.right.val == val){
                    curr.right = helper(curr.right);
                }else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    public TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode leftSubTreeRightMostChild = findLastRightMostNode(root.left);
        leftSubTreeRightMostChild.right = rightChild;
        return root.left;
    }

    public TreeNode findLastRightMostNode(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}
