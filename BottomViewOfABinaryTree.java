package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import tree.FindMinDistanceBetweenTwoNodes.Node;

public class BottomViewOfABinaryTree {
	static class Pair{
	    Node n;
	    int d;
	    public Pair(Node node,int d){
	        this.n=node;
	        this.d=d;
	    }
	    }
	public ArrayList <Integer> bottomView(Node root)
    {
        Queue<Pair>q=new LinkedList<Pair>();
        TreeMap<Integer,ArrayList<Node>>h=new TreeMap<Integer,ArrayList<Node>>();
        q.add(new Pair(root,0));
       
        while(!q.isEmpty()){
            int s=q.size();
            while(s>0){
            Pair p=q.remove();
            
            if(!h.containsKey(p.d)){
                ArrayList<Node>list=new ArrayList<Node>();
                list.add(p.n);
                h.put(p.d,list);
               
            }
            else{
                h.get(p.d).add(p.n);
            }
            if(p.n.left!=null){
                q.add(new Pair(p.n.left,p.d-1));
            }
            if(p.n.right!=null){
                q.add(new Pair(p.n.right,p.d+1));
            }
            s--;
            }
        }
        ArrayList<Integer>ans=new ArrayList<Integer>();
        for(int d:h.keySet()){
            ArrayList<Node>node=h.get(d);
            ans.add(node.get(node.size()-1).data);
        }
        return ans;
    }
}
