package tree;

public class MaxAverageSubtreeSum {
	 static double mavg;
     static TreeNode node;
     //here we are given a binary tree and we wanted to find out the max avg 
     //subtree sum so for that it is just like that finding the max sum of the subarray
     //and just here we need to return array from every subtree that would return the sum of
     //of the subarray and the count of nodes in that subarray     
     static int[] getsum(TreeNode root){
        if(root==null){
            return new int[2];
            //zero sum and zero count
        }
        int l[]=getsum(root.left);
        int r[]=getsum(root.right);
        int a[]=new int[2];
        a[0]=l[0]+r[0]+root.val;
        a[1]=l[1]+r[1]+1;
        double av=0;
        if(a[1]!=0){
        av=a[0]/(a[1]*1.0);     
        }
        if(av>mavg){
            mavg=av;
            node=root;
        }
        return a;
    }
    public TreeNode findSubtree2(TreeNode root) {
     node=null;
     mavg=Integer.MIN_VALUE;
     getsum(root);
    // System.out.println(mavg);
     return node;
    }
}
