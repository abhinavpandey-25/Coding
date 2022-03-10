package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Levelwise_sumIn_bTree {
	static void levelOrderBottom(TreeNode root) {
	    List<List<Integer>>list=new ArrayList<>();
	    int sum=0;
	   Queue<TreeNode>q=new LinkedList<>();
	      q.add(root);
	             while(true){
	      int nodecount=q.size();
	          if(q.size()==0)
	              break;
	         List<Integer>c=new ArrayList<>();
	      int temp=0;
	         while(nodecount>0){
	         TreeNode node=q.remove();
	          c.add(node.val);
	          temp=temp+node.val;
	          nodecount--;
	         if(node.left!=null){
	             q.add(node.left);
	         }
	         if(node.right!=null){
	             q.add(node.right);
	         }
	           }
	          if(!c.isEmpty())
	         list.add(c);
	          System.out.println(temp);
	      }
	      Collections.reverse(list);
	      System.out.println(list);
	
	  }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(6);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(1);
		root.right.right=new TreeNode(7);
		levelOrderBottom(root);
		//level order traveral from bottom of tree;
	//level wise sum of elements in a binary tree;
	}   
}
