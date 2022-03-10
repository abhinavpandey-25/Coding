package tree;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthofBinaryTree {
	   public int widthOfBinaryTree(TreeNode root) {
		     Deque<TreeNode>q=new LinkedList<>();
		        q.add(root);
		        int max=0;
		        while(!q.isEmpty()){
		            int size=q.size();
		            while(!q.isEmpty()&&q.getFirst()==null){
		                q.removeFirst();
		            }
		            while(!q.isEmpty()&&q.getLast()==null){
		                q.removeLast();
		            }
		            if(q.size()==0)
		                break;
		             max=Math.max(q.size(),max);
		            int sz=q.size();
		            for(int i=0;i<sz;i++){
		            TreeNode node=q.remove();
		                if(node==null){
		                    q.add(null);
		                }
		                else{
		                    q.add(node.left);
		                }
		                if(node==null){
		                    q.add(null);
		                }
		                else{
		                    q.add(node.right);
		                }
		            }
		        }
		        return max;
		    }
}
