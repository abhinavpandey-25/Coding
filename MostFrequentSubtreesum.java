package tree;

import java.util.*;

public class MostFrequentSubtreesum {
	//find every subtrree sum and store in hashmap and keep the track of max
	//frequency as this is what we need tp returm
	 static int sum(TreeNode r,HashMap<Integer,Integer>h,int m[]){
	        if(r==null)return 0;
	        int left=sum(r.left,h,m);
	        int right=sum(r.right,h,m);
	        int val=left+right+r.val;
	        h.put(val,h.getOrDefault(val, 0)+1);
	        if(h.get(val)>m[0]){
	            m[0]=h.get(val);
	        }
	        return val;
	    } 
	    public int[] findFrequentTreeSum(TreeNode root) {
	        // Write your code here
	        HashMap<Integer,Integer>h=new HashMap<Integer,Integer>();
	        int max[]={Integer.MIN_VALUE};
	        sum(root,h,max);
	       // System.out.println(h);
	        //System.out.println(max[0]);
	        ArrayList<Integer>l=new ArrayList<Integer>();
	        for(int k:h.keySet()){
	            if(h.get(k)==max[0]){
	                l.add(k);
	            }
	        }
	        int a[]=new int[l.size()];
	        int ind=0;
	        for(int v:l){
	            a[ind++]=v;
	        }
	        return a;

	    }
}
