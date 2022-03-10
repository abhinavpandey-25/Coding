package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ProgLinkedList.RemoveDuplicate1.ListNode;

public class FindMinheightTrees {
//given a tree we need to return the value of that nodes whom if we make as roots
//will give the min height tree
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	//logic is that if the number of nodes are odd then only the middle node would be
	//the one which give the min height on making as root and for even the middle two nodes will give
	//min heihgt
	//lets keep the track of degree of the nodes
	ArrayList<Integer>nodes=new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>>l=new ArrayList<ArrayList<Integer>>();
	int degree[]=new int[n];
	  if(edges.length==0) {nodes.add(0);return nodes;}
      
	for(int i=0;i<n;i++) {
		l.add(new ArrayList<Integer>());
	}
	
	
	for(int e[]:edges) {
		degree[e[0]]++;
		degree[e[1]]++;
		l.get(e[0]).add(e[1]);
		l.get(e[1]).add(e[0]);
	}
	for(int i=0;i<n;i++) {
		if(degree[i]==1) {
			nodes.add(i);
		}
	}
	//we have added all the nodes to the list whose degree is 1
	//now get the nodes one by one and decrease there neighbour degree by 1
	//as soon as upon decreasing negihbour if the the degree becomes 1 then
	//then add that to the que
	while(n>2) {
		n=n-nodes.size();
		for(int val:nodes) {
			degree[val]--;
			for(int ngh:l.get(val)) {
				degree[ngh]--;
				if(degree[ngh]==1) {
					nodes.add(ngh);
				}
			}
		}
	}
	return nodes;
}	
	
}
