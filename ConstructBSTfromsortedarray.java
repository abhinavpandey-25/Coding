package tree;

public class ConstructBSTfromsortedarray {
	//here har node p mid ka node create krenge and uske left k liye
	//bhi same kam find the mid and create a node and move to its lefta
	//similarly on rhs also just we need is l and r as index
	 static TreeNode create(int n[],int l, int r){
	        if(l>r)
	        return null;
	        int mid=(l+r)/2;
	        TreeNode t=new TreeNode(n[mid]);
	        t.left=create(n,l,mid-1);
	        t.right=create(n,mid+1,r);
	        return t;
	    }
	    public TreeNode sortedArrayToBST(int[] nums) {
	        int l=0;
	        int r=nums.length-1;
	       return create(nums,l,r);
	        
	    }
}
