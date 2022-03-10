package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
static int minDepth(TreeNode root) {
	
	//this is a simple fact that while doing the dfs if we get a node whose left and right is equal to null
	//then that first node will be our answer as we need to find the min depth of the binary tree.
	Queue<TreeNode>q=new LinkedList<TreeNode>();
	q.add(root);
	int level=0;
	int size;
	while(!q.isEmpty()) {
		size=q.size();
		level++;
		while(size!=0) {
			TreeNode node=q.poll();
			size--;
			if(node.left==null&&node.right==null) {
				return level;
			}
			if(node.left!=null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}
		}
	}
	return level;
}
}
	