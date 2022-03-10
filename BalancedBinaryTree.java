package tree;

public class BalancedBinaryTree {
	//balanced biinary tree neans that a tree whose height of any left and right subtree not defer more than
	//1
	    static int height(TreeNode root){
	        if(root==null)
	            return 0;
	        int h1=height(root.left);
	        int h2=height(root.right);
	    
	        if(h1==-1||h2==-1)
	            return -1;
	        if(Math.abs(h1-h2)>1)
	        return -1;
	        return Math.max(h1,h2)+1; 
	    }
	    public boolean isBalanced(TreeNode root) {
	        if(root==null)
	            return true;
	        else if(height(root)!=-1)
	              return  true;
	        return false;
	        
	    }
	}

