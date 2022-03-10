package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Depthwithoutrecursion {
	node root;
int caldepth(node rootnode) {
	int level=0;
	if(rootnode!=null) {
		Queue<node>que=new LinkedList<>();
		que.add(rootnode);
		que.add(null);
		while(!que.isEmpty()) {
			rootnode=que.remove();
			if(rootnode==null) {
				if(!que.isEmpty()) 
					que.add(null);
				level++;
			}
			else {
				if(rootnode.left!=null) {
					que.add(rootnode.left);
				}
				if(rootnode.right!=null) {
					que.add(rootnode.right);
				}
				
			}
		}
	}
return level;		
}
public static void main(String[] args) {
	Depthwithoutrecursion o=new Depthwithoutrecursion();
	o.root=new node(1);
	o.root.left=new node(2);
	o.root.right=new node(3);
	o.root.left.left=new node(4);
	o.root.left.right=new node(5);
	o.root.left.left.left=new node(6);
System.out.println(o.caldepth(o.root)-1);	
}
}
