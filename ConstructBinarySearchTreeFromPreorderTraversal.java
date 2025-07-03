package interviewQA.Trees.BinarySearchTrees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] inorder) {
        int[] preorder = new int[inorder.length];
        for(int i = 0; i < preorder.length; i++){
            preorder[i] = inorder[i];
        }
        Arrays.sort(inorder);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return func(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode func(int[] preorder, int ps, int pe, int[] inorder, int ins, int ine, Map<Integer,Integer> map){
        if(ps > pe || ins > ine){
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int inRoot = map.get(root.val);
        int inLeftEle = inRoot - ins;

        root.left = func(preorder, ps+1, ps+inLeftEle, inorder, ins, inRoot - 1, map);
        root.right = func(preorder, ps+1+inLeftEle, pe, inorder, inRoot + 1, ine, map);

        return root;
    }
}
