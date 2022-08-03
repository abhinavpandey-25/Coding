package tree;

public class FindMinDistanceBetweenTwoNodes {
	static class Node
	{
	    int data;
	    Node left, right;
	   Node(int item)    {
	        data = item;
	        left = right = null;
	    }
	} 
	static int check(Node root,int a){
		//find the distance from root node to a node with value a
		
		//depth tak jao yadi node nhi milta toh zero return krte jao and
		//jab mil jaye toh +1 hegiht krke reutrn krdo
        if(root==null)return 0;
        if(root.data==a)return 1;
        int l=check(root.left,a);
        int r=check(root.right,a);
        if(l!=0)return l+1;
        if(r!=0)return r+1;
        return l;
    }
    static Node lca(Node root,int a,int b){
        if(root==null)return null;
        if(root.data==a||root.data==b)return root;
        Node l=lca(root.left,a,b);
        Node r=lca(root.right,a,b);
        if(l!=null&&r!=null)return root;
        else if(l!=null)return l;
        else return r;
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        int lrd=-1;
        int rrd=-1;
        if(root.data==a)lrd=0;
        else if(root.data==b)rrd=0;
        if(lrd!=0)
        lrd=check(root,a)-1;
        if(rrd!=0)
        rrd=check(root,b)-1;
        Node n=lca(root,a,b);
        int lcard=check(root,n.data)-1;
       // System.out.println(lrd+" "+rrd+n.data);
        return lrd+rrd-2*lcard;
        
    }
}
