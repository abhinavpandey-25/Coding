package tree;

public class SumOfTheNodeOnLongestPathInABinaryTree {
	static class Node {
	    int data;
	    Node left, right;
	    
	    public Node(int data){
	        this.data = data;
	    }
	}
	static int[] helper(Node r){
	       if(r==null)
	       return new int[]{0,Integer.MIN_VALUE};
	       int lt[]= helper(r.left);
	       int rt[]=helper(r.right);
	       int a[]=new int[2];
	       if(lt[0]>rt[0]){
	            a[0]=lt[0]+1;
	            a[1]=lt[1]+r.data;
	       }
	       else if(lt[0]==rt[0]){
	            a[0]=lt[0]+1;
	            if(lt[1]==rt[1]&&lt[1]==Integer.MIN_VALUE){
	                a[1]=r.data;
	            }
	            else
	            a[1]=Math.max(lt[1],rt[1])+r.data;
	       }
	       else{
	            a[0]=rt[0]+1;
	            a[1]=rt[1]+r.data;
	         }
	       return a;
	    }
	    public int sumOfLongRootToLeafPath(Node root)
	    {
	        int ans[]=helper(root);
	        return ans[1];
	        //yha hamne har node se jake puch ki tere l subtree
	        //ki h badi h ki right subtree ki jiski badi hogi uske node ki sum value ham store krenge
	        //but if same h hogi then we ki sum kiska jyda h woh store krna pdega
	        
	    }
}
