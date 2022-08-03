package tree;

public class CountUnivalueSubtree {
	static int c; 
    static boolean traverse(TreeNode root){
        if(root==null)return true;
        //lval tells whether the left subtree is univalue or not and same for rval
        boolean lval=traverse(root.left);
        boolean rval=traverse(root.right);
        if(lval==false||rval==false)return false;
          //     1
         //   2 	1
        // 2	
       //2   5
      //in this case at the 2 two from top
     //we get false from left and true from right even than i checked condition
     //due to which i again increase teh count which is wrong   
        if(root.left!=null&&root.val!=root.left.val){
            return false;
        }
        if(root.right!=null&&root.val!=root.right.val){
            return false;
        }
        c++;
        return true;
    } 
	public int countUnivalSubtrees(TreeNode root) {
        c=0;
        traverse(root);
        return c;
    }
}
