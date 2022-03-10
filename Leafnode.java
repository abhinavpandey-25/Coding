package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Leafnode {
	node root;
int calleaf(node rootnode) {
	int count=0;
	int num=0;
	Queue<node>que=new LinkedList<>();
	que.add(rootnode);
	while(!que.isEmpty()) {
		node n=que.remove();
		if(n.left!=null&&n.right!=null)
			num++;
		if(n.left==null&&n.right==null) {
			count++;
		}
		else {
			if(n.left!=null) {
				que.add(n.left);
			}
			if(n.right!=null) {
				que.add(n.right);
			}
		}
	}
	System.out.println("complte node="+num);
	return count;
}
public static void main(String[] args) {
	Leafnode o=new Leafnode();
	o.root=new node(1);
	o.root.left=new node(2);
	o.root.right=new node(3);
	o.root.left.left=new node(4);
	o.root.left.right=new node(5);
	o.root.left.right.left=new node(6);
	o.root.left.right.right=new node(49);
	System.out.println("no of leafnode="+o.calleaf(o.root));
	
}
}
