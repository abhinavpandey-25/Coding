package tree;
 
 

public class ConstructABinaryTreeFromInorderandPreorder {
	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	 }
	  }
	static TreeNode construct(int ps,int pe,int is,int ie,int p[],int in[]){
        if(ps>pe){
            return null;
        }
        TreeNode root=new TreeNode(p[ps]);
        int size=0;
        while(in[size]!=p[ps]){
            size++;
        }
        int elements=size-is;
        root.left=construct(ps+1,ps+elements,is,size-1,p,in);
        root.right=construct(ps+elements+1,pe,size+1,ie,p,in);
        return root;
    }
    public TreeNode buildTree(int[] porder, int[] inorder) {
       return construct(0,porder.length-1,0,inorder.length-1,porder,inorder);
//for constructing the tree first we have preorder ie root left right
//now in the inorder if we find the root than its left is left subtre
//and its right is rsubtree so this can be done recursviely to create the
//tree .first create a root element with the starting index value of the porder array
// now for creating its  left subtree we need to identify 
//  root value in the inorder array to get how many
//elements in the left subtree of the root are there to get the endingindex in the porder for left 
//subarray from this we ahve all the index ie are porderstart,porderend,inorderstart,inorderend
       
//       
       
    }

}
