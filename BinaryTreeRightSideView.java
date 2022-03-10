package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	    public List<Integer> rightSideView(TreeNode root) {
	    	//har bar jitne element ek level m insert kerenge usme se last element of that
	    	//level should be stored and wo element milega with the help of sz (look at implementation)
	        ArrayList<TreeNode>node=new ArrayList<>();
	        ArrayList<Integer>ans=new ArrayList<>();
	        if(root==null)
	            return ans;
	        node.add(root);
	        while(!node.isEmpty()){
	            int sz=node.size(); 
	            while(sz>0){
	            TreeNode n=node.remove(0);
	            if(sz==1)
	                    ans.add(n.val);
	            if(n.left!=null){
	                node.add(n.left);
	            }
	            if(n.right!=null){
	                node.add(n.right);
	            }
	                sz--;
	            }  
	        }
	        return ans;  
	    }
	
}
