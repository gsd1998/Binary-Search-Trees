package interviewQA.Trees.BinarySearchTrees;

public class CeilInABinarySearchTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        int ans = ceilInBST(root, 123
        );
        System.out.println(ans);//13
    }

    public static int ceilInBST(TreeNode root, int val){
        int ceil = -1;
        while(root != null){
            if(val == root.val){
                return root.val;
            }else if(val < root.val){
                ceil = root.val;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ceil;
    }
}
