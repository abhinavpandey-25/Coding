package tree;

public class FindClosestNodeValGivenToK {
//given a bst you need to find out the closest value of the node to the 
//given value k 
	static void check(TreeNode root, double target,int a[],double diff){
        if(root==null)return;
        //yadi target-root.val global min se kam hota h toh woh root ko store
        //krne ka otherwise not and for deciding kidhar travel krana
        //that depends on rootval if less than target move right as it is a bst
        //else go to left
            double diff2=Math.abs(target-root.val);           
            if(diff2<diff){
                a[0]=root.val;
               diff=diff2;           
            }
           if(root.val<=target){
            check(root.right,target,a,diff);
        }
        else{
            check(root.left,target,a,diff);
        }
    }
   public int closestValue(TreeNode root, double target) {
       // write your code here
       int ans[]=new int[1];
       ans[0]=Integer.MAX_VALUE;
       double diff=Double.MAX_VALUE;
       check(root,target,ans,diff);
       if(ans[0]==Integer.MAX_VALUE)
       return root.val;
       return ans[0];
   }	
	
}
