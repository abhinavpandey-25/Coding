package tree;

import java.util.Stack;

public class Preorder {
	node root;
	//without recursn() {
		void preorder(node rootnode) {
			if(rootnode!=null) {
				Stack<node>stack=new Stack<>();
				stack.push(rootnode);
				while(!stack.empty()) {
					node node2=stack.peek();
					System.out.println(node2.data);
					stack.pop();
					if(node2.right!=null) {
						stack.push(node2.right);
					}
					if(node2.left!=null) {
						stack.push(node2.left);
					}
									}
			}
	}
	public static void main(String[] args) {
		Preorder o=new Preorder();
		o.root=new node(14);
		o.root.right=new node(46);
		o.root.left=new node(8);
		o.root.left.left=new node(13);
		o.root.left.right=new node(5);
		o.root.right.left=new node(2);
		o.preorder(o.root);
	}

}
