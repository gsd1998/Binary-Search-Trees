package interviewQA.Trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k-1);
    }

    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


    //optimal approach
    public static int kthSmallestOptimal(TreeNode root, int k) {
        int[] small = new int[]{Integer.MIN_VALUE};
        int[] big = new int[]{Integer.MAX_VALUE};
        int[] counter = new int[]{0};
        inOrderSmallest(root, small, counter, k);
        counter[0] = 0;
        inOrderSmallest(root, big, counter, k);
        return small[0];
    }

    public static void inOrderSmallest(TreeNode root, int[] small, int[] counter, int k){
        if (root == null || counter[0] >= k)
            return;
        inOrderSmallest(root.left, small, counter, k);
        counter[0]++;
        if(counter[0] == k){
            small[0] = root.val;
            return;
        }
        inOrderSmallest(root.right, small, counter, k);
    }

    public static void inOrderBiggest(TreeNode root, int[] big, int[] counter, int k){
        if (root == null || counter[0] >= k)
            return;
        inOrderBiggest(root.right, big, counter, k);
        counter[0]++;
        if(counter[0] == k){
            big[0] = root.val;
            return;
        }
        inOrderBiggest(root.left, big, counter, k);
    }
}
