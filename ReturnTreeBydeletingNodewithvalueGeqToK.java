package tree;

import tree.FindMinDistanceBetweenTwoNodes.Node;

public class ReturnTreeBydeletingNodewithvalueGeqToK {
//given a bst return the tree with by deleting node with value greater equal to k
	static Node recur(Node r,int k){
        if(r==null)return null;
        else if(r.data>=k){
            Node n1= recur(r.left,k);
         //   if(n1!=null&&n1.data<k){
         //       r.left=n1;
         //   }
            if(r.data>=k)
            return n1;
            else return r;
            
        }
     
        else{
            Node n2=recur(r.right,k);
             r.right=n2;
           return r;
            
            
        }
    }
      public Node deleteNode(Node root,int k)
      {
         return recur(root,k);
      }
}
