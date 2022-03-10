package tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SumOfLeftNodes {
	static class Pair{
        int n1=0;
        int n2=0;
        Pair(int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }
    }
//find the sum of all the nodes that are towards left of a given node
	 static int s;
	 //here the tricky part is two find that where the left is
	 //so in recursion whenever u will do left call keep a flag and based
	 //on that flag add the rot val
	    static void travel(TreeNode r,int flag){
	        if(r==null)return;
	        if(flag==1)s+=r.val;
	        travel(r.left,1);
	        travel(r.right,0);
	        return;
	    }
	    public static long leftSum(TreeNode root) 
	    {
	    	
	        s=0;
	         travel(root,0);
	        return s;
	    }
	    public static void main(String[] args) {
		
	    	
		}
	
}
