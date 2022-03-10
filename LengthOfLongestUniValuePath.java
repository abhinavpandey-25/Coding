package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LengthOfLongestUniValuePath {
	
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
	static boolean check(ArrayList<Integer>l,int level) {
		if(level%2==0) {
			for(int i=0;i<l.size();i++) {
				int val=l.get(i);
				if(val%2==1) {
					if(i==0) {
						continue;
					}
					else {
						if(l.get(i)-l.get(i-1)>1) {
							continue;
						}
						else {
							return false;
						}
					}
				}
				else {
					return false;
				}
			}
		}
		
		else {
			for(int i=0;i<l.size();i++) {
				int val=l.get(i);
				if(val%2==0) {
					if(i==0) {
						continue;
					}
					else {
						if(l.get(i)-l.get(i-1)<0) {
							continue;
						}
						else {
							return false;
						}
					}
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isEvenOddTree(TreeNode root) {
    Queue<TreeNode>q=new  LinkedList<LengthOfLongestUniValuePath.TreeNode>();
    q.add(root);
    int level=0;
    while(q.isEmpty()) {
    	int s=q.size();
    	ArrayList<Integer>l=new ArrayList<>();
    	while(s-->0) {
    		TreeNode n=q.remove();
    		l.add(n.val);
    		if(n.left!=null) {
    			q.add(n.left);
    		}
    		if(n.right!=null) {
    			q.add(n.right);
    		}
    	}
    	if(!check(l,level)) {
    		return false;
    	}
    	level++;
    }
    return true;
    }  
			static int ans=0;
			public int getlongest(TreeNode root){
	         if(root==null){
	            return 0;
	        }
	        int l=getlongest(root.left);
	        int r=getlongest(root.right);
	        TreeNode leftval=root.left;
	        TreeNode rightval=root.right;
//	        Basically, if every node can tell how far the path from it can extend on the left and on the right, we are done!
//	        As part of traversal of the tree, we touch every node so we can keep updating max with that answer at each node.
//	        Now, what do we mean by extending? Simply compare the values of the current node and its children. Then any path starting at the child can be extended to our node.
//
//	        If we cannot extend our path either to left or right, we simply return 0.
//	        If we can extend only one side, we add 1 to that side path and return to the caller.
//	        If we can extend to both sides, max will be the total path extended to the left side and right side combined. But to our caller, we just pick the max of the two sides and return.
	    if(leftval!=null && rightval!=null && root.val==root.left.val && root.val==root.right.val){
	            ans=Math.max(ans,l+r+1); 
	            //ab uppar toh l+r+1 vala path nhi bnega 
	            //so keval l ya r mse se jo max hoga whi contribute kr 
	            //skta for above path
	            return Math.max(l,r)+1;
	        }
	        else if(leftval!=null&&root.val==root.left.val){
	            ans=Math.max(ans,l+1);
	            return l+1;
	        }
	        else if(rightval!=null&&root.val==root.right.val){
	            ans=Math.max(ans,r+1);
	            return r+1;
	        }
	        else{
	            ans=Math.max(1,ans);
	            return 1;
	        }    
	    }
	    //[1,null,1,1,1,1,1,1] 
	    //actually we need to calculate the length of longest path so in 
	    //situation where left.val=right.val=root we are returning eq nodes
	    //but we need to return the   longest edge 
	    public int longestUnivaluePath(TreeNode root) {
	        ans=0; 
	        int val=getlongest(root);
	          if(val==0)
	              return 0;
	            else
	            return ans-1;
	    }
	    public static void main(String[] args) {
		
		}
}
