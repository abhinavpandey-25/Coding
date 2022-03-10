package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Height {
	node root ;
	int calheight(node root) {
		if(root==null) {
			return 0;
		}
		else {
		int lef=calheight(root.left);
		int rig=calheight(root.right);
		if(lef>rig) 
			return lef+1;
		//depth
			else
				return (rig+1);
		}
	}
		public static void main(String[] args) {
			 Queue<node> q = new LinkedList<>(); 
			
			 			Height o=new Height();
			o.root=new node(1);
			o.root.left=new node(2);
			o.root.left.left=new node(4);
			o.root.right=new node(5);
			o.root.right.left=new node(6);
			o.root.right.left.left=new node(11);
			o.root.right.left.left.left=new node(5);
			o.root.left.right=new node(7);
			o.root.left.right.right=new node(54);
			int result =o.calheight(o.root);
			q.add(o.root);
			System.out.println(result-1);//this is important
		}
	}

