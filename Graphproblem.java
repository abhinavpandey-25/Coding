package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class Graphproblem {
	public static Boolean isBalanced(String s) {
	int cnt=0;
	for(int i=0;i<s.length();i++) {
		if(s.charAt(i)=='(')cnt++;
		else if(s.charAt(i)==')')
			cnt--;
		if(cnt<0)
			return false;
	}
		 return true;
		
	}
	static Map<String,Boolean>vis=new HashMap<>();
	public static Vector<String> removeInvalidParenthesis(String s){
		Queue<String>q = null;
		Vector<String> ans = null;
		q.add(s);
		int found=0;
		while(!q.isEmpty()) {
			String u=q.peek();
			q.remove();
			if(vis.containsKey(u)) 
				continue;
				vis.put(u, true);
				if(isBalanced(u))
					found=1;
				ans.add(u);
				if(found==1) {
					continue;
			}
				for(int i=0;i<u.length();i++) {
					if(u.charAt(i)=='('||u.charAt(i)==')') {
						String v=u.substring(0,i)+u.substring(i+1, u.length());
						q.add(v);
					}
				}		
		}
		return ans;
	}
public static void main(String[] args) {
	Vector<String>v=removeInvalidParenthesis("(a)())()");
	for(String cur:v) {
		System.out.println(cur);
	}
}
}
