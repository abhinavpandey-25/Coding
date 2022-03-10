package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class EvenOddTree {
	//we have to tell whether the given tree is even odd tree or not
	//which means that at even index we should have odd value in strictly increasing manner
	//and at odd index we should have even values in strictly decreasing order 
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
static boolean check(ArrayList<Integer>l,int level) {
	if(level%2==0) {
		for(int i=0;i<l.size();i++) {
			int val=l.get(i);
			if(val%2==1) {
				if(i==0) {
					continue;
				}
				else {
					if(l.get(i)-l.get(i-1)>1) {
						continue;
					}
					else {
						return false;
					}
				}
			}
			else {
				return false;
			}
		}
	}
	
	else {
		for(int i=0;i<l.size();i++) {
			int val=l.get(i);
			if(val%2==0) {
				if(i==0) {
					continue;
				}
				else {
					if(l.get(i)-l.get(i-1)<0) {
						continue;
					}
					else {
						return false;
					}
				}
			}
			else {
				return false;
			}
		}
	}
	return true;
}
static int prevdata[];
static boolean check(TreeNode r,int l) {
	if(r==null) {
		return true;
	}
	if(l%2==0) {
		if(r.val%2==0) {
			return false;
		}
		else {
			if(prevdata[l]>=r.val) {
				return false;
			}
			else {
				prevdata[l]=r.val;
			}
		}
	}
	else {
		if(r.val%2==1) {
			return false;
		}
		else {
			//so prev m initaly odd level k coresponfin put Intmax as inital value
			
			if(r.val>=prevdata[l]) {
				return false;
			}
			else {
				prevdata[l]=r.val;	
			}
		}
		
	}
	//abhi toh keval level 0 k lye check hua h hame left right har node k liye krna h
	return check(r.left, l+1)&&check(r.right,l+1);
}
static int getheight(TreeNode root) {
	if(root==null) {
		return 0;
	}
	int l=getheight(root.left);
	int r=getheight(root.right);
	return Math.max(l, r)+1;
}
public boolean isEvenOddTreedfs(TreeNode root) {
	int l=getheight(root);
	prevdata=new int[l];
	//now kyuki hame increasing aur decreasing seq check krna h 
	//we keep an array of size height of the tree for levels
	//and then store the value when we incounter a level 
	//suppose if i reach 2 level first time which is even so should have
	//odd values and that should be stricclyt increasing so initiate
	//tthe even level as with zero as whenever i get current val less than prev
	//then return false as c should be greater as even level
	return check(root,0);
}
public boolean isEvenOddTreebfs(TreeNode root) {
	//bfs solution but this same question can also be done through dfs also
	
Queue<TreeNode>q=new  LinkedList<>();
q.add(root);
int level=0;
while(!q.isEmpty()) {
	int s=q.size();
	ArrayList<Integer>l=new ArrayList<>();
	while(s-->0) {
		TreeNode n=q.remove();
		l.add(n.val);
		if(n.left!=null) {
			q.add(n.left);
		}
		if(n.right!=null) {
			q.add(n.right);
		}
	}
	if(!check(l,level)) {
		return false;
	}
	level++;
}
return true;
}  
public static void main(String[] args) {
	
}
}
