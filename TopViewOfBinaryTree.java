package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
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
	    //for more detali look at topviewOfABinary Tree
	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        Queue<Pair>q=new LinkedList<>();
	        TreeMap<Integer,List<Integer>> h=new TreeMap<>();
	        int level=0;
	        q.add(new Pair(root,0));
	        while(!q.isEmpty()){
	            Pair pair=q.remove();
	            if(!h.containsKey(pair.d)){
	                List<Integer>l=new ArrayList<>();
	                l.add(pair.p.val);
	                h.put(pair.d,l);
	            }
	            //jo bhi vertival origin se phla naya distance rhega 
	            //towards left and right whi visible hoga from 
	            //the top and we use trrmap to get ans from left to right
	            	//if  present do nothing as that is visible only
	            if(pair.p.left!=null){
	                q.add(new Pair(pair.p.left,pair.d-1));
	            }
	            if(pair.p.right!=null){
	                q.add(new Pair(pair.p.right,pair.d+1));
	            }
	        }
	        List<List<Integer>>ans=new ArrayList<>();
	        for(int key:h.keySet()){
	            ans.add(h.get(key));
	        }
	        return ans;
	    }
}
