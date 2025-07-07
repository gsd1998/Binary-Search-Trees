package interviewQA.Trees.BinarySearchTrees;


class NodeValue{
    int size;
    int maxVal;
    int minVal;

    NodeValue(int size, int maxVal, int minVal){
        this.size = size;
        this.maxVal = maxVal;
        this.minVal = minVal;
    }
}
public class LargestBSTInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(18);
        root.left.left.right = new TreeNode(14);
        root.left.right.left = new TreeNode(16);
        root.left.right.right = new TreeNode(19);
        root.right.left = new TreeNode(30);
        root.right.right= new TreeNode(60);
        root.right.right.left= new TreeNode(50);

        int result = largestBST(root);
        System.out.println(result);//11
    }

    public static int largestBST(TreeNode root){
        return findLargestBst(root).size;
    }

    public static NodeValue findLargestBst(TreeNode root) {
        if(root == null) {
            return new NodeValue(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        NodeValue left = findLargestBst(root.left);
        NodeValue right = findLargestBst(root.right);
        if(left.maxVal < root.val && root.val < right.minVal){
            return new NodeValue(left.size + right.size + 1, Math.max(root.val, right.maxVal), Math.min(root.val,left.minVal));
        }
        return new NodeValue(Math.max(left.size, right.size), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}
