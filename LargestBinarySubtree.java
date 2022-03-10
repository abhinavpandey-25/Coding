package tree;

public class LargestBinarySubtree {
	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}
	 static boolean checkBST(TreeNode<Integer>root,int max,int min){
	        if(root==null)
	            return true;
	        if(root.data>max||root.data<min)return false;
	       return checkBST(root.left,root.data,min)&&checkBST(root.right,max,root.data);
	    }
	    static int size(TreeNode<Integer>root){
	        if(root==null)return 0;
	        int l=size(root.left);
	        int r=size(root.right);
	        return l+r+1;
	    }
		public static int largestBST(TreeNode<Integer> root) {
			//toh yha pr har ek node ko as root man kr ke check kro whether
			//that is a bst or not if not then check for the right and the 
			//left subtree and after checking that it is bsst then cal max
			//size of the bst and out of that get the max size
			if(checkBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE)){
	            	return size(root);
	        }
	        else{
	            int left=largestBST(root.left);
	            int right=largestBST(root.right);
	            return Math.max(left,right);
	        }
		}

}
