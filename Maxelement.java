package tree;
class node{
	int data=0	;
	node left;
	node right;
public node(int d) {
	left=null;
	right=null;
	data=d;
}
}
public class Maxelement {
	node root;
	static int maximumelement(node node) {
		if(node!=null) {
			int value=node.data;
			int left=maximumelement(node.left);
			int right=maximumelement(node.right);
			if(left>value) {
				value=left;
			}
			if(right>value) {
				value=right;
			}
			return value;
		}
		else {
			return Integer.MIN_VALUE;
		}
		
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
