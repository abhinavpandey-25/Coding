package tree;

import tree.FindMinDistanceBetweenTwoNodes.Node;

public class LargestBinarySubtree {
//	class TreeNode<T> {
//	    public T data;
//	    public TreeNode<T> left;
//	    public TreeNode<T> right;
//
//	    TreeNode(T data) {
//	        this.data = data;
//	        left = null;
//	        right = null;
//	    }
//	}
	   static class OptNode{
	        int leftmax;
	        int rightmin;
	        int maxsize;
	        OptNode(int l1,int r1,int s){
	            this.leftmax=l1;
	            this.rightmin=r1;
	            this.maxsize=s;
	        }
	    }
//	 static boolean checkBST(TreeNode<Integer>root,int max,int min){brute approach
//	        if(root==null)
//	            return true;
//	        if(root.data>=max||root.data<=min)return false;
//	       return checkBST(root.left,root.data,min)&&checkBST(root.right,max,root.data);
//	    }
//	    static int size(TreeNode<Integer>root){
//	        if(root==null)return 0;
//	        int l=size(root.left);
//	        int r=size(root.right);
//	        return l+r+1;
//	    }
//		public static int largestBST(TreeNode<Integer> root) {
//			//toh yha pr har ek node ko as root man kr ke check kro whether
//			//that is a bst or not if not then check for the right and the 
//			//left subtree and after checking that it is bsst then cal max
//			//size of the bst and out of that get the max size
//			if(root==null)return 0;
//			if(checkBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE)){
//	            	return size(root);
//	        }
//		         int left=largestBST(root.left);
//	            int right=largestBST(root.right);
//	            return Math.max(left,right);
//	       
//		}
//		
		static OptNode helper(Node r){
			//optimized approach here we are checking bst from bottom 
	        //here we are using post order traversal to compute for left and for right
	        if(r==null){
	            return new OptNode(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
	        }
	        OptNode n1=helper(r.left);
	        OptNode n2=helper(r.right);
	        if(r.data>n1.leftmax&&r.data<n2.rightmin)  {
	            //every node we need leftmax
	            return new OptNode(Math.max(r.data,n2.leftmax),Math.min(n1.rightmin,r.data),n1.maxsize+n2.maxsize+1);
	        }
	        return new OptNode(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(n1.maxsize,n2.maxsize));
	        
	    }
		static int largestBst(Node root)
	    {      
	        return helper(root).maxsize;
	    }
}
