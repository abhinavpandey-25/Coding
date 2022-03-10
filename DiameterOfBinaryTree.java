package tree;

public class DiameterOfBinaryTree {
	public class TreeNode {
		    int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
}
	//better approach as we are calculating the height of every node
	//we should update the diameter if l+r+1>d do it for every node
	static int d=0;
	static int diameterop(TreeNode root) {
		if(root==null)
            return 0;
        else{
            int l=diameterop(root.left);
            int r=diameterop(root.right);
            if(l+r>=d)
                d=l+r;
            return Math.max(l,r)+1;
        }
	}
	static int height(TreeNode root){
		//Calculating height complexity is o(n) for each node
		if(root==null)
			return 0;
		int l=height(root.left);
		int r=height(root.right);
		if(l>r) {
			return l+1;
		}
		else
			return r+1;
	}
	public int diameter(TreeNode root){
		//the poitn here is that diamter can be made inlcuding the root
		//and also without including root 
		//in without root ->two condition first diameter is present in the
		//left subtree or in the right subtree
		//if including root then diamter is height of left subtree +right+1
		int l=height(root.left);
		int r=height(root.right);
		//without including root;
		//cal dia is called for n nodes so cal height colled n times 
		//so complexiyt o(n^2)
		//so heere comoplexity jyada h kyuki hight cal krte time bhi m bagal
		//vale node se height cal ko bolta and phir uske bad diameter cal krne
		//ko bolta toh woh waps height cal krta h ie increasing complexity uncessatiuly
		
		int lsd=diameter(root.left);
		int rsd=diameter(root.right);
		diameterop(root);
		System.out.println(d);
		return Math.max(l+r+1,Math.max(lsd,rsd) );
	}
}
	
