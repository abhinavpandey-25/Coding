package tree;

public class SubtreeOfAnothertree {
	public class TreeNode {
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
	static boolean compare(TreeNode s,TreeNode t) {
		if(s==null&&t==null)
			return true;
		else if(s==null||t==null)
			return false;
		else if(s.val!=t.val)
			return false;
		else
			return compare(s.left,t.left)&&compare(s.right,t.right);
					
	}
	static public boolean isSubtree(TreeNode s, TreeNode t) {
		//here we are been given two trees and we need to find out whther the tree t is a subtree of the
		//tree s so here we need to check for every node and once value is equal then uske badd every left nad
		//right should be identical
		if(compare(s,t))
			return true;
		if(s==null)
			return false;
		return isSubtree(s.left, t)||isSubtree(s.right, t);
	}
}
