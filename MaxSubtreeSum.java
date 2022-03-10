package tree;

public class MaxSubtreeSum {
    static TreeNode node;
    static int ms;
    //we encounter like every subtree take its left sum and right
    //sum and from every subtree return its sum and whenever the sum of a subtree
    //is greater than maxsum then update the maxsum and by alsoo keeping the track of the
    //root node
       static int getSubtreesum(TreeNode rt){
       int sum=0;
       if(rt==null)
       return 0; 
       int l=getSubtreesum(rt.left);
       int r=getSubtreesum(rt.right);
       sum+=l+r+rt.val;
       if(sum>=ms){
           ms=sum;
           node=rt;
       }
       return sum;
   }
	public TreeNode findSubtree(TreeNode root) {
	    node=null;
	    ms=Integer.MIN_VALUE;
	    getSubtreesum(root);
	     return node;
	   }     
}
