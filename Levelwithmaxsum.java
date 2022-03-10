package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Levelwithmaxsum {
node root ;
int calmaxsum(node rootnode) {
	int maxsum=0;
	int level=0;
	int maxlevel=0;
	int currentsum=0;
	Queue<node>que=new LinkedList<>();
	que.add(rootnode);
	que.add(null);
	while(!que.isEmpty()) {
		node temp=que.remove();
		if(temp==null) {
			if(currentsum>maxsum) {
				maxsum=currentsum;
				maxlevel=level;
			}
			currentsum=0;
			if(!que.isEmpty()) {
				que.add(null);
				level++;
			}
			
		}
		else {
			currentsum=+temp.data;
			if(temp.left!=null) {
				que.add(temp.left);
			}
			if(temp.right!=null) {
				que.add(temp.right);
			}
		}
	}
	
	return maxlevel;
	
}
public static void main(String[] args) {
	Levelwithmaxsum o=new Levelwithmaxsum();
	String s="Abhi  ";
	
	String []a=s.split(" ");
	for(int i=0;i<a.length;i++) {
		System.out.println(a[i]);
	}
	o.root=new node(1);
	o.root.left=new node(2);
	o.root.right=new node(3);
	o.root.left.left=new node(4);
	o.root.right.left=new node(8);
	o.root.right.left.right=new node(1);
	o.root.left.right=new node(6);
	o.root.left.right.left=new node(1);
	o.root.left.right.right=new  node(2);
	o.root.left.left.left=new node(9);
	System.out.println("the level with max sum is="+o.calmaxsum(o.root));
}
}
