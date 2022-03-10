package tree;

import java.util.Stack;

public class Inorder {
node root=null;
void inorder(node rootnode) {
	Stack<node>s=new Stack<>();
	node n=rootnode;
	while(s.size()>0||n!=null) {
		while(n!=null) {
			s.push(n);
			n=n.left;
		}
		n=s.pop();
		System.out.println(n.data);
		n=n.right;
	}
}
public static void main(String[] args) {
	Inorder o=new Inorder();
	o.root=new node(1);
	o.root.left=new node(2);
	o.root.right=new node(3);
	o.root.left.left=new node(4);
	o.root.left.right=new node(5);
	o.root.right.right=new node(7);
	o.root.right.left=new node(6);
	o.inorder(o.root);
}
}
