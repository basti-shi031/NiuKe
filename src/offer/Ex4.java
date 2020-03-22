package offer;

import javax.swing.tree.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Ex4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        TreeNode root = new TreeNode(pre[0]);

        int preIndex = 0;
        int inIndex = find(pre[0], in);

        root.left = constructLeft(preIndex, inIndex, pre, in);


        return root;
    }

    private int find(int i, int[] in) {
        for (int j = 0; j < in.length; j++) {
            if (i == in[j]) {
                return j;
            }
        }

        return 0;
    }

    /**
     * 找左节点
     *
     * @param preIndex
     * @param inIndex
     * @param pre
     * @param in
     * @return
     */
    private TreeNode constructLeft(int preIndex, int inIndex, int[] pre, int[] in) {
        //当前root的前序index为preIndex,
        return null;

    }
}
