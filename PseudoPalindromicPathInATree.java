package tree;

public class PseudoPalindromicPathInATree {
//count the number of pseudo palindromic path ie the path from root to
//leaf that can be converted to palindrome upon rearranging
	static int c;
    static  int ar[];
    static boolean check(){
    	//"it runs in constant complexity  as the size 
    //of the array is 10 only as the node values are fixed ie in between 1 to 9";
        //System.out.println(l);
        int count=0;
        for(int i:ar){
            if(i%2==1){
               // System.out.println(i+" "+ar[i]);
                count++;
            }
        }
        
        if(count>1)
            return false;
        else 
            return true;
    }
    static void travel(TreeNode root){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            ar[root.val]++;
            if(check()){
            c++;
            }
            ar[root.val]--;
           return ;
        }
        ar[root.val]++;
        travel(root.left);
        travel(root.right);
        ar[root.val]--;
       // System.out.println(l);
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        c=0;
        ar=new int[10];
        travel(root);
        return c;	
        //to minimize complexity traverse krte time hi global array me 
        //count store krte jao as soon leaf pr gye then iterate on that
        //10 sized array to check ki odd frequency value yadi >1 hue then
        //cannot be made palindrome else can be made
        //and then freq waps original pe le aao
}
}
