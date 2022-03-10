	package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalInABinaryTree {
//this same problem is an advancement of top view of binary tree
//in that first we need to know the common point in between nodes that
//are not visible and that is the distance from the root ie a fixed pivot
//matlb once i got a node whose distacne from the root is 0 then
//and after traveeling down i again got a node whose distacne from root 
//is zero then that node is not visible so keep a store like map with key
//as the distance and value as the nodeval	now in this problem
//we are been given a binary tree and we need itss vertical traversal
//nodes in the arraylist as answer from top to bottom and if two nodes
//are at same distance from the root and at same level then sort them
//based on value d->distance from root horizontally 
// 		 	  	    d(0)5
		  		//	 	  \\
//     		d(-1)1		 d(1)6
	  		//    \\	    //
// 		d(-2)0    d(0)3  d(0)2	
	//output should  be [[0],[1],[5,2,3],[6]]
	//so same level p sorted lane k liye ham
	//har level k corrsponding levelmap rkhenge jo ki dis,nodeval store
	//krega and jab level traverse ho jyga toh sare entry nikal k dekhnge
	//ki uski key hamere global map m h ki nai yadi h toh global ki list
	//m we need to add the level lisst else toh add level list to global list
	  public class TreeNode {
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
	    static public class Pair{
	    TreeNode p;
	    int d;
	    public Pair(TreeNode p,int d){
	        this.p=p;
	        this.d=d;
	    }
	    }
	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        Queue<Pair>q=new LinkedList<>();
	        int level=0;
	        q.add(new Pair(root,0));
	          TreeMap<Integer,List<Integer>> h=new TreeMap<>();    
	        while(!q.isEmpty()){
	            int size=q.size();
	            TreeMap<Integer,List<Integer>> lm=new TreeMap<>();    
	            while(size-->0){
	                  Pair pair=q.remove();
	                if(!lm.containsKey(pair.d)){
	                List<Integer>l=new ArrayList<>();
	                l.add(pair.p.val);
	                lm.put(pair.d,l);
	            }
	            else{
	                List<Integer>nl=lm.get(pair.d);
	                nl.add(pair.p.val);
	                Collections.sort(nl);
	                System.out.println(nl);
	                lm.put(pair.d,nl);
	            }
	            if(pair.p.left!=null){
	                q.add(new Pair(pair.p.left,pair.d-1));
	            }
	            if(pair.p.right!=null){
	                q.add(new Pair(pair.p.right,pair.d+1));
	            }
	            }
	             for(int key:lm.keySet()){
	                 List<Integer>l=lm.get(key);    
	                 if(!h.containsKey(key)){
	                       h.put(key,l); 
	                   }
	                 else{
	                     List<Integer>gl=h.get(key);
	                     gl.addAll(l);
	                     h.put(key,gl);
	                 }
	            }
	       
	            
	        }
	        
	        return new ArrayList<>(h.values());
	    }
	
}
