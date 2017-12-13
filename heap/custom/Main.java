package heap.custom;
class Node2{
	public int data;
	public boolean state;
	public Node2 left, right;
	public Node2(int data){
		this.data = data;
		this.state = true;
		this.left = new Node2(0);
		this.right = new Node2(0);
		this.left.state = false;
		this.right.state = false;
		
	}
}
class Tree2{
	//member
	public Node2 root;
	//insert
	public Tree2(){
		root = null;
	}
	public void insert(int data){
		if(root == null){
			root = new Node2(data);
			return;
		}
		Node2 t = root;
		while(t.state){
			if(t.data > data)
				t = t.left;
			else
				t = t.right;
		}
		t.data = data;
		t.state = true;
	}
	public void show(Node2 n){
		if(n.state == false)
			return;
		System.out.println(n.data);
		show(n.left);
		show(n.right);
	}
}

class Tree{
	//member
	public Node root;
	//method
	public Tree(){
		this.root = new Node(0);
	}
	//ins
	public void insert(int d){
		Node t = this.root;
		if(t.data == 0){
			t.data = d;
			return;
		}else{
			while(t != null){
				if(t.data > d)
					t = t.left;
				else
					t = t.right;
			}
			t = new Node(d);
		}
		/*Node t = this.root;
		if(t == root)
			System.out.println("same");
		while(t != null){
			if(t.data > d)
				t = t.left;
			else
				t = t.right;
		}
		t = new Node(d); 
		System.out.println(t + ", " + this.root);*/

	}
}

public class Main {
	//method
	static void makeLeft(Node p, Node c){
		p.left = c;
	}
	static void makeRight(Node p, Node c){
		p.right = c;
	}
	//show
	static void show(Node node){
		if(node == null)
			return;
		System.out.println(node.data);
		show(node.left);
		show(node.right);
	}
	
	public static void main(String[] args) {
		TreeBasic t1 = new TreeBasic();
		t1.insert(10);
		t1.insert(4);
		t1.insert(20);
		t1.insert(1);
		t1.showAll();
		/*Tree2 t2 = new Tree2();
		t2.insert(10);
		t2.insert(2);
		t2.show(t2.root);*/
		/*Tree t1 = new Tree();
		t1.insert(10);
		t1.insert(20);
		show(t1.root);*/


		/*// TODO Auto-generated method stub
		Node n1 = new Node(10);
		Node n2 = new Node(2);
		Node n3 = new Node(5);
		Node n4 = new Node(4);
		Node n5 = new Node(11);
		makeLeft(n1, n2);
		makeRight(n1, n3);
		makeLeft(n2, n4);
		makeRight(n2,n5);
		show(n1);*/

	}

}
