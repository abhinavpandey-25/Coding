package tree;

import java.util.Scanner;

public class Mainmaxheap {
	public static void main(String[] args) {
		Scanner o=new Scanner(System.in);
		int n=o.nextInt();
		MaxHeap m=new MaxHeap(n);
		for(int i=1;i<=n;i++) {
			m.insert(o.nextInt());
		}
		System.out.println("Before");
		m.printHeap();
		m.BuildHeap();
		System.out.println("After");
		m.printHeap();
	//	m.del_max_from_max_heap();
		//m.printHeap();
	//	m.increasekey(5, 400);
		//m.printHeap();
		m.heapsort();
		m.printHeap();
	}
}
