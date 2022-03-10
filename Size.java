package tree;
import java.util.*;
public class Size {
	node root;
	int calsize(node rootnode) {
		if(rootnode==null) {
			return 0;
		}
		else
			return(calsize(rootnode.left)+1+calsize(rootnode.right));
	}
public static void main(String[] args) {
	Size o=new Size();
	o.root=new node(1);
	o.root.left=new node(2);
	o.root.right=new node(3);
	o.root.left.left=new node(4);
	o.root.left.right=new node(5);
	o.root.right.left=new node(6);
	o.root.right.right=new node(9);
	o.root.right.right.right=new node(12);
	System.out.println(o.calsize(o.root));
}
}