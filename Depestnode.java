package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Depestnode {
	node root;
	node caldeppest(node rootnode) {
	node temp=null;
		Queue<node>qu=new LinkedList<>();
		qu.add(rootnode);
		while(!qu.isEmpty()) {
			temp=qu.remove();
			if(temp.left!=null) {
				qu.add(temp.left);
			}
			if(temp.right!=null) {
				qu.add(temp.right);
			}
		}
		return temp;
	}
public static void main(String[] args) {
	Depestnode o=new Depestnode();
	o.root=new node(1);
	o.root.left=new node(2);
	o.root.left.left=new node(8);
	o.root.right=new node(9);
	o.root.left.right=new node (12);
	o.root.left.right.left=new node(18);
	o.root.left.right.left.left=new node(15);
	node n=o.caldeppest(o.root);
	System.out.println("data of deepest node:"+n.data);
}
}
