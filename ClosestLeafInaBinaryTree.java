package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ClosestLeafInaBinaryTree {
	public class TreeNode {
		      public int val;
		      public TreeNode left, right;
		      public TreeNode(int val) {
		          this.val = val;
		          this.left = this.right = null;
		      }
		  }
	static TreeNode n;
	static void childToParentMapping(HashMap<TreeNode,TreeNode>h,TreeNode node,int t) {
		if(node==null)return;
		if(node.val==t) {
			n=node;
		}
		if(node.left!=null) {
			h.put(node.left, node);
		}
		if(node.right!=null) {
			h.put(node.right, node);
		}
		childToParentMapping(h,node.left,t);
		childToParentMapping(h,node.right,t);
	}
	static public int findClosestLeaf(TreeNode root, int k) {
		//so for finding the closest leaf node start with the node that
		//has the value k and and do a bfs from that node and the nearest
		//leaf is our answer also nodes are unique in the tree
		//below conditions tab jab leaf se distance same ara ho
		//and priority order: 1) leaf in left subtree 2)leaf in the right subtree
		//3) leaf not in the subtree 
		//now for doing the bfs from that node with value k it is necessary to
		//get a mapping of every node with its parent node 
		HashMap<TreeNode,TreeNode>h=new HashMap<TreeNode,TreeNode>();
		childToParentMapping(h,root,k);
		Queue<TreeNode>q=new LinkedList<TreeNode>();
		q.add(n);
		HashSet<Integer>s=new HashSet<Integer>();
		s.add(k);
		while(!q.isEmpty()) {
			TreeNode curr=q.remove();
			if(curr.left==null&&curr.right==null) return curr.val;
			//applyiing bfs and getting the first node ie leaf will be our answer

			if(curr.left!=null&&!s.contains(curr.left.val)) {
				q.add(curr.left);
			    s.add(curr.left.val);
			}
			if(curr.right!=null&&!s.contains(curr.right.val)) {
				q.add(curr.right);
			   s.add(curr.right.val);
					
			}
			if(h.containsKey(curr)&&!s.contains(h.get(curr).val)) {
				q.add(h.get(curr));
                s.add(h.get(curr).val);
			}
		}
		
		return -1;
    }
}
