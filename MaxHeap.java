package tree;

public class MaxHeap {
	 
	private  int[]Heap;
	private static int size;
	private int maxsize;
	MaxHeap(int maxsize){
		this.maxsize=maxsize;
		size=0;
	Heap=new int[maxsize+1];	
	Heap[0]=Integer.MAX_VALUE;
	}
	void insert(int element) {
		Heap[++size]=element;
		int i=size;
		while(i>1&&Heap[i]>Heap[i/2]) {
			int temp=Heap[i];
			Heap[i]=Heap[i/2];
			Heap[i/2]=temp;
			i=i/2;
		}
	}
	void BuildHeap() {
		int start=(int) Math.floor(maxsize/2);
	for(int i=start;i>=1;i--) {
		maxHeapify(Heap,i);
	}
	}
	private static boolean isLeaf(int pos) {
		if(pos>(int)Math.floor(size/2) &&pos<=size) {
			return true;
		}
		else
			return false;
	}
	private void swap(int l,int i) {
		int temp=Heap[l];
		Heap[l]=Heap[i];
		Heap[i]=temp;
	}
	private void maxHeapify(int ar[],int index) {
		if(isLeaf(index)) {
			  return;
		}
		else {
			int leftchild=2*index;
			int rightchild=2*index+1;
			if(rightchild<=size) {
				if(ar[index]>=ar[leftchild]&&ar[index]>=ar[rightchild]) {
					return;
				}
			}
			else {
				  if(ar[index]>=ar[leftchild])
					  return;
			}
			int largest;
			if(leftchild<=size&&ar[index]<ar[leftchild ]) {
				largest=leftchild;
			}
			else
				largest=index;
			if(rightchild<=size&&ar[rightchild]>ar[largest]) {
				largest=rightchild;
			}
			if(largest!=index) {
				swap(largest,index);
			}
				
			maxHeapify(ar, largest);	
		}
	}
	void heapsort() {
		int length=size;
		for(int i=size;i>=2;i--) {
			int temp=Heap[size];
			Heap[size]=Heap[1];
			Heap[1]=temp;
			size--;
			maxHeapify(Heap,1);
		}
		size=length;
	}
	void printHeap() {
		for(int i=1;i<=size;i++) {
			System.out.print(Heap[i]+" ");
		}
	}
	void del_max_from_max_heap() {
		if(size<1)
			System.out.println("invalid heap");
		else {
		int max=Heap[1];
		Heap[1]=Heap[Heap.length-1];
		size--;
		maxHeapify(Heap, 1);
		}
		}
	void increasekey(int index,int key) {
		if(key<1)
		return;
		Heap[index]=key;
		while(index<1&&Heap[index]>Heap[index/2]) {
				int temp=Heap[index];
				Heap[index]=Heap[index/2];
				Heap[index/2]=temp;
		index=index/2;
		}
			
	}

}
