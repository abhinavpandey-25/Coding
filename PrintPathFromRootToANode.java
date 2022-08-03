package tree;

import java.util.ArrayList;

public class PrintPathFromRootToANode {
	static void travel(ArrayList<Integer>l,TreeNode a,int b){
        if(a==null){
            return ;
        }
        if(a.val==b){
            l.add(a.val);
            return;
        }
        travel(l,a.left,b);
        if(!l.isEmpty()){
            l.add(a.val);
            return;
        }
        travel(l,a.right,b);
        if(!l.isEmpty()){
            l.add(a.val);
            return;
        }
    }
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer>l=new ArrayList<>();
        travel(l,A,B);
        int ar[]=new int[l.size()];
        for(int i=0;i<ar.length;i++){
            ar[i]=l.get(l.size()-i-1);
        }
        return ar;
    }
}
