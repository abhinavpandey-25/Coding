package tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfABinaryTree {
	//here we are given a tree a and we need to find the boundary of the
	//tree in anticlockwise manner and for that we need to first 
	//print the root left view  and then leaf of root left and then
	//leaf of right and then right boundary but that two from niceh se upar
	//for anticlockwise (that can be done by adding to the list
	//as we are coming from recursion)
	//example so leftboundary-> -34 ,leafleft->-100
	//rightleaf->-100,8 rightboundary-> -22,-71,-54,48,-48
//							37
					//				\\
//				-34			   			-48
//					\\					// \\
//					-100			-100	48
										  //
//								   		-54
//										// \\ 
//								   	  -71   -22
//										   	  \\	
//								   		  		8
//										  	
	//ans is [37,-34,-100,-100,-71,8,-22,-54,48,-48]
	static  class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	  }
	 
	     static void leftBoundary(TreeNode r,List<Integer>l){
	         //since it is the left boundary so first i wanted to check the left first and
	        //then the right as left is first priority at the left boundary 
	        
	          if(r==null){
	              return ;
	          }  
	         else if(r.left!=null){
	             l.add(r.val);
	             leftBoundary(r.left,l);
	         }
	         else if(r.right!=null){
	             l.add(r.val);
	             leftBoundary(r.right, l);
	         }
	     }
	     static void leaf(TreeNode r,List<Integer>l){
	        if(r==null)
	            return ;
	        else if(r.left==null&&r.right==null){
	            l.add(r.val);
	            return;
	        }
	        leaf(r.left, l);
	        leaf(r.right, l);            
	     }
	     static void rightBoundary(TreeNode r,List<Integer>l){
	        //since it is the right boundary so first i wanted to check the right first and
	        //then the left as right is first priority at the right boundary 
	        //and since we wanted to print the data in an anticlockwise manner 
	        //so we will add the node val during coming from recursion so that niche se upar tak
	        //ki value store hongi
	          if(r==null){
	              return ;
	          }  
	         else if(r.right!=null){
	             rightBoundary(r.right,l);
	             l.add(r.val);
	         }
	         else if(r.left!=null){
	             rightBoundary(r.left, l);
	             l.add(r.val);
	         }
	     }
	    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	        // write your code here
	        List<Integer>l=new ArrayList<>();
	        //so let's padd the left boundary of the Tree toh the List
	        if(root==null)
	        return l;
	        l.add(root.val);
	        leftBoundary(root.left,l);
	        System.out.println("leftBoundary"+l);
	        //after this we need the leaf node of the root left 
	        leaf(root.left,l);
	        
	        System.out.println("leftleaf"+l);    
	        leaf(root.right,l);
	        
	        System.out.println("rightLeaf"+l);
	        rightBoundary(root.right,l);
	        
	        System.out.println("rightBoundary"+l);
	        return l;
	    }
	}
