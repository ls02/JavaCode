import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-08
 * Time: 21:36
 */
public class TestDemo {
    public static void main(String[] args) {

    }
}

/**
 * 前序遍历
 */
class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void _preorderTraversal(TreeNode root, List<Integer> l1) {
        if (null == root) {
            return;
        }

        l1.add(root.val);
        _preorderTraversal(root.left, l1);
        _preorderTraversal(root.right, l1);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();

        _preorderTraversal(root, l1);

        return l1;
    }
}
