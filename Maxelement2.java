package tree;

import java.util.LinkedList;
import java.util.Queue;

//class node{
	//int data =0;
//	node left;
	//node right;
	//node(int d){
		//data =d;
	//	left=null;
	//	right=null;
	//}
//}
public class Maxelement2 {
 node root;
 static int maximumelement(node treenode) {
		int  max=Integer.MIN_VALUE;
	 if(treenode!=null) {
		 Queue<node>queue=new LinkedList<>();
		 queue.add(treenode);
		 while(!queue.isEmpty()) {
			node temp= queue.remove();
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
			if(temp.data>max) {
				max=temp.data;
			}
		 }
	 }
	 return max; 
 }
 public static void main(String[] args) {
	Maxelement o=new Maxelement();
	o.root=new node(2);
	o.root.left=new node(7);
	o.root.right=new node(5234);
	o.root.left.right=new node(600);
	o.root.left.right.left=new node(0011);
	o.root.left.right.right=new node(0101);
	o.root.right.right=new node(9);
	o.root.right.right.left=new node(4);
	System.out.println("maximum element is "+o.maximumelement(o.root));
}
}

