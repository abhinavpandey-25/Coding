package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfDeepestNodeOfTree {
//get the sum of the depest node of a tree
//logic is that just find the h of tree and do bfs and at that level
//just do the sum of nodes to get the answer
	  static int height(TreeNode root){
	        if(root==null)
	            return 0;
	        int l=height(root.left);
	        int r=height(root.right);
	        return Math.max(l,r)+1;
	    }
	    public int deepestLeavesSum(TreeNode root) {
	        int h=height(root);
	        Queue<TreeNode>q=new LinkedList<>();
	        q.add(root);
	        int level=1;
	        int sum=0;
	        while(!q.isEmpty()){
	            int s=q.size();
	            while(s-->0){
	                TreeNode n=q.remove();
	                if(n.left!=null)
	                    q.add(n.left);
	                if(n.right!=null)
	                    q.add(n.right);
	                if(level==h)
	                    sum+=n.val;
	            }
	            level++;
	        }
	        return sum;
	    }
}
