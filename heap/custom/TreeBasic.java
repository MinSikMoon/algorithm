package heap.custom;

public class TreeBasic {
	//members
	public Node root;
	//constructor
	public TreeBasic(){
		root = null;
	}
	
	//method
	public void insert(int data){
		if(this.root == null){
			this.root = new Node(data);
			return;
		}
		
		Node tp = null;
		Node tc = this.root;
		boolean flag = true;
		
		while(tc != null){
			tp = tc;
			if(tc.data > data){
				tc = tp.left;
				flag = true;
			}				
			else{
				tc = tp.right;
				flag = false;
			}
				
		}
		if(flag)
			tp.left = new Node(data);
		else
			tp.right = new Node(data);
	}
	
	//show
	public void show(Node in){
		if(in == null)
			return;
		show(in.left);
		System.out.println(in.data);
		show(in.right);
	}
	public void showAll(){
		show(this.root);
	}
}
