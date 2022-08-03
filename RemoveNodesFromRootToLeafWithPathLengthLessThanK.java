package tree;

public class RemoveNodesFromRootToLeafWithPathLengthLessThanK {
	static TreeNode checkPath(TreeNode r,int l,int k) {
		if(r.left==null&&r.right==null) {
		 	if(l<k)return null;
		 	else return r;
		}
		r.left=checkPath(r.left,l+1,k);
		r.right=checkPath(r.right,l+1,k);
		return r;
	}
	static TreeNode removeNodes(TreeNode r,int k) {
	return checkPath(r,1,k);
	}
}
