package tree;

import java.util.LinkedList;

public class DeleteEdges {
	static void dfs(int v,int w[],LinkedList<Integer>[]l,boolean vis[],int sub[]) {
	if(!vis[v]) {
	sub[v]+=w[v];
	vis[v]=true;
	//this is to caluclate and store the subtree sum for each node
	for(int child:l[v]) {
		if(!vis[child]) {
		dfs(child,w,l,vis,sub);
		sub[v]+=sub[child];
		}
	}
	}
	}
	static void printsubtree(int a[]) {
		for(int v:a) {
			System.out.print(v+" ");
		}
		System.out.println();
	}
		static public int deleteEdge(int[] A, int[][] B) {
	  //you need to delete a edge in such a way so that product of the 
	  //the weight of the two subtree formed is maxmized
      //the logic is that we will store the subarray sum of every node in 
	  //an array and after that since we have total sum and we have sm of each
	//subarray so we can easily find out the max weight product 		
		 LinkedList<Integer>[]l=new LinkedList[A.length];
		 for(int i=0;i<l.length;i++) {
			 l[i]=new LinkedList<Integer>();
		 }
		 //
		 for(int i=0;i<B.length;i++) {
				 l[B[i][0]-1].add(B[i][1]-1);
				 l[B[i][1]-1].add(B[i][0]-1);
		 }
		 boolean visited[]=new boolean [A.length];
		 int subtreesum[]=new int [A.length];
		 dfs(0,A,l,visited ,subtreesum);
		 int total=subtreesum[0];
		 int max=0;
		 printsubtree(subtreesum);
		 for(int i=1;i<subtreesum.length;i++) {
			 max=Math.max(max, subtreesum[i]*(total-subtreesum[i]));
		 }
		 //here we are starting from index 1 as index 0 wil have the whole sum of tree
		 
		 return max;
	 }
		public static void main(String[] args) {
			int a[]= {10, 5, 12, 6};
			int b[][]= {{1,2},{1,4},{4,3}};
			int ans=deleteEdge(a, b);
			System.out.println(ans);
		}
}
