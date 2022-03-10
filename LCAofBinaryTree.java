package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LCAofBinaryTree {
	int m=2;
	
	static TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
		//binary tree m hame node tak jana pdega tree k left and right
		//subtree p travel kro and jab hame node p ya q milta h toh woh node
		//hi return krdo if yadi left  right of a subtree dono null ajata h iska matlb
		//udhar nhi h return null but uf bith left right reutrn soomthing
		//iiska matlb root of that subtrre hi lca h aur kbhi left subtree
		//m mil skta but right m na mile ie null us case m left return kiya.
        if(root==null)return root;
        if(root==p||root==q)return root;
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        else if(left!=null)
            return left;
        else if(right!=null)
            return right;
        else
            return null;
    }
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        TreeNode t=lca(root,p,q);
	        return t;
	      
	    }
	 public static void main(String[] args) {
			}
}
