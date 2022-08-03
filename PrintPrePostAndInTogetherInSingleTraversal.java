package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.FindMinDistanceBetweenTwoNodes.Node;

public class PrintPrePostAndInTogetherInSingleTraversal {
	static class Info{
        Node b;
        int num;
        public Info(Node bt,int i){
            this.b=bt;
            this.num=i;
        }
    }
	 public static List<List<Integer>> getTreeTraversal(Node root) {
	        // Write your code here.
	        List<List<Integer>> l = new ArrayList<>();
	        Stack<Info>st=new Stack<Info>();
	        List<Integer>pre=new ArrayList<Integer>();
	        List<Integer>in=new ArrayList<Integer>();
	        List<Integer>post=new ArrayList<Integer>();
	        if(root==null)return l;
	        Info i=new Info(root,1);
	        st.push(i);
	        while(!st.isEmpty()){
	            Info i1=st.pop();
	            if(i1.num==1){
	                pre.add(i1.b.data);
	               st.push(new Info(i1.b,2));
	                if(i1.b.left!=null){
	                    st.push(new Info(i1.b.left,1));
	                }                
	            }
	            else if(i1.num==2){
	                in.add(i1.b.data);
	                 st.push(new Info(i1.b,3));
	                if(i1.b.right!=null){
	                    st.push(new Info(i1.b.right,1));
	                }
	            }
	            else {
	                post.add(i1.b.data);
	            }
	        }
	        l.add(in);
	        l.add(pre);
	       
	        l.add(post);
	     //  List<List<Integer>> lists = new ArrayList<>();
	        //based on number of visits we can do that
			return l;
	    }
}
