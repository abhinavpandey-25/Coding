package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Cousinsinbinarytree {
	
	//  Definition for a binary tree node.
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

	class Solution {
		//in this logic hr node ko q me add krte time check krlo
		//ki x ya y ke brabr toh nhi h if h toh mark krlo with some var
		//ki konsa mil gya h 
		//and yadi wo x and y ke brabr h and parent same h 
		//then return false
		//otherwise check krlo us level p add krte  time tumne x and y
		//ko add kia h and false return nhi kia h toh they belong to 
		//different  parent then in that case return true;
		public boolean isCousins2(TreeNode root, int x, int y) {
	        Queue<TreeNode>q=new LinkedList<TreeNode>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int s=q.size();
	            boolean fx=false;
	            boolean fy=false;
	            boolean gx=false;
	            boolean gy=false;
	            while(s-->0){
	                TreeNode t=q.remove();                
	                if(t.left!=null){
	                    if(t.left.val==x){
	                        fx=true;
	                        gx=true;
	                    }
	                    else if(t.left.val==y){
	                        fx=true;
	                        gy=true;
	                    }
	                    q.add(t.left);
	                }
	                if(t.right!=null){
	                    if(t.right.val==y){
	                        fy=true;
	                        gy=true;
	                    }
	                    else if(t.right.val==x){
	                        fy=true;
	                        gx=true;
	                    }
	                    q.add(t.right);
	                }
	                if(fx&&fy){return false;}
	                else{
	                    fx=false;
	                    fy=false;
	                }
	            }
	            if(gx&&gy)return true;
	        }
	         return false;
	     }  
	    public boolean isCousins(TreeNode root, int x, int y) {
	        Queue<TreeNode>q=new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int size=q.size();
	           boolean isXthere=false;
	            boolean isYthere=false;
	            for(int i=0;i<size;i++){
	               TreeNode v= q.remove();
	            if(v.val==x){
	                isXthere=true;
	                System.out.println(v.val);
	                System.out.println(isXthere);
	            }
	            if(v.val==y){
	                isYthere=true;
	                 System.out.println(v.val);
	                 System.out.println(isYthere);
	            }
	                if(!(v.left==null)&&(v.left.val==y)&&!(v.right==null)&&(v.right.val==x)){
	                    return false;
	                }
	                if(!(v.left==null)&&(v.left.val==x)&&!(v.right==null)&&(v.right.val==y)){
	                    return false;
	                }
	                if(v.left!=null){
	                    q.add(v.left);
	                    System.out.println(v.left.val);
	                }
	                if(v.right!=null){
	                    q.add(v.right);
	                    System.out.println(v.right.val);
	                }
	                 }
	            System.out.println(isXthere+" "+isYthere);
	            if(isXthere==true&isYthere==true){
	                return true;
	            }
	        }
	        return false;
	    }
	}
}
