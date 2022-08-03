package tree;

public class MaxPathSumInaBinaryTreeFromAnyNodeToAnyOtherNode {
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
	    static int ans;
	    static int getSum(TreeNode root){
	        if(root==null)
	            return 0;
	        int l=getSum(root.left);
	        int r=getSum(root.right);
	        int max=Math.max(Math.max(l,r)+root.val,root.val);
	        int val2=Math.max(max,l+r+root.val);
	        //val 2 ko ham sidehe global ans k sath compare krenge 
	        //as yadhi wo l+r+rot hua toh wo direct root se hi compare hoga
	        //usme koi parent ki zarurat nhi pdti h
	  
	        ans=Math.max(val2,ans);
	      //  System.out.println(max+" "+ans+" "+val2);
	        return max;
//	         7 7 7
	// 2 7 2
	// 18 20 20
	// 24 24 24
	// 13 24 13
	// 1 24 1
	// 5 24 5
	// 21 26 26
	// 31 55 55
//[5,4,8,11,null,13,4,7,2,null,null,null,1]
	    }
	    //ki ham har node par root ko inclide isliye krrhe h taki hamra continuos path ban sake
	    //isliye har comparison m root ko include kro
	    public int maxPathSum(TreeNode root) {
	        ans=Integer.MIN_VALUE;
	        //here for everynode we need to take 4 cases that are 
	        //if both l and r are - than ans may be root ,
	        //if l - and r+ or vice versa then we need to consider max among l
	        //and r + root val
	        //if both l and r are + then ans will be rot +l +r
	        //now we will do above step for every node and cal the max among //all of them 
	    getSum(root);
	        return ans;
	    }
	}

