package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesAtAdistanceofKinABinaryTree {
	static void createChildToParentMap(HashMap<TreeNode,TreeNode>h,TreeNode root){
       if(root==null)
          return;
//since child is unique so keeep key as child
//in general we do not use boolean aray in bfs but yha use krna
//pdega as hame kisi node k parent ki bhi jarurat pdegi kkyuki target
//se k distance m track of parent is required       
        if(root.left!=null){
            h.put(root.left,root);
        }
        if(root.right!=null){
            h.put(root.right,root);
        }
        createChildToParentMap(h,root.left);
        createChildToParentMap(h,root.right);
   }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer>l=new ArrayList<>();
        if(root==null)
            return l;
        else if(k==0){
            l.add(target.val) ;
            return l;
        }
            
        Queue<TreeNode>q=new LinkedList<>();
        HashSet<TreeNode>visited=new HashSet<>();
        q.add(target);
        HashMap<TreeNode,TreeNode>h=new HashMap();
        createChildToParentMap(h,root);
     //create child jo h wo child to parent ka relation return krra h
    //now start from the target and start visiting its neghbours like
    //in a bfs manner and once we reach k distance in bfs then
    //there just add all the node val at that point to list and do not
    //proced on further neighbour as i only need to go upto distance k    
        
        while(!q.isEmpty()&&k>0){
            int size=q.size();
            while(size>0){
            TreeNode n=q.remove();
            visited.add(n);
            if(n.left!=null&&!visited.contains(n.left)){
                if(k==1){
                    l.add(n.left.val);
                }
                q.add(n.left);
            }
            if(n.right!=null&&!visited.contains(n.right)){
                if(k==1){
                    l.add(n.right.val);
                }
                q.add(n.right);
            }
            TreeNode parent=h.get(n);
            if(parent!=null&&!visited.contains(parent)){
                if(k==1){
                    l.add(parent.val);
                }
                q.add(parent);
            }
                size--;
            }
            k--; 
        }
        return l;
    }
   public static void main(String[] args) {
	    	int a[]= {3,2,1,7,5,4};
			
		}
}

