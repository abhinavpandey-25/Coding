package tree;

public class NLevelBinaryTree {
static boolean check(int ar[]) {
	int i=1;
	int max=Integer.MAX_VALUE;
	int min=Integer.MIN_VALUE;
	while(i<ar.length) {
		//har value range k betwn hogi and agr value left m insert hoti toh uske 
		//cooresponding max change hoga else min change hoga
		if(ar[i]>ar[i-1]&&ar[i]>min&&ar[i]<max) {
			min=ar[i-1];
			i++;
		}
		//if the value is inserted to the left 
		//then 
		else if(ar[i]<ar[i-1]&&ar[i]<max&&ar[i]>min) {
			max=ar[i-1];
			i++;
		}
		else {
			return false;
		}
	}
	return true;
}
	public static void main(String[] args) {
	//find whther the given arary can form n level binary tree or not
	int ar[]= {500, 200, 90, 250, 100};
	System.out.println(check(ar));
}
}
