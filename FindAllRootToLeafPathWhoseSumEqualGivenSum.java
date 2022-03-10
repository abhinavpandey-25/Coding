package tree;
import java.util.*;
public class FindAllRootToLeafPathWhoseSumEqualGivenSum {
 static void travel(TreeNode root,int sum,List<List<Integer>>l,List<Integer>l1,int s){	
	if(root==null)return;
    if(root.left==null&&root.right==null){
        s+=root.val;
        if(sum==s){
            l1.add(root.val);
            l.add(new ArrayList<Integer>(l1));
            l1.remove(l1.size()-1);
        }
        return;
    }
    s+=root.val;
    l1.add(root.val);
    travel(root.left,sum,l,l1,s);
    travel(root.right,sum,l,l1,s);
    l1.remove(l1.size()-1);
} 
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    // Write your code here.
	//travel from root to leaf and at leaf check the sum 
	//and then remove the last added element to get back to previous state again
    List<List<Integer>>l=new ArrayList<List<Integer>>();
    List<Integer>l1=new ArrayList<Integer>();
    int s=0;
    travel(root,sum,l,l1,s);
    return l;
}
}
