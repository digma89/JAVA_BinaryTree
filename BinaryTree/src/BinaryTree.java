import java.util.Stack;


public class BinaryTree {
	
	Node root;
	
	public void addNode (int key, String name){	
		Node newNode = new Node(key, name);		
		if(root == null){	
			root = newNode;
		}else{				
			Node focusNode = root;
			Node parent;
			while(true){
				parent = focusNode;
				if(key < focusNode.key){
					focusNode = focusNode.leftChild;
					if(focusNode == null){
						parent.leftChild = newNode;
						System.out.println("Inserted left : "+newNode);
						return;						}
				}else{
					focusNode = focusNode.rightChild;
					if(focusNode == null){
						parent.rightChild = newNode;
						System.out.println("Inserted right : "+newNode);
						return;
					}
				}
			}
		}
	}
	
	//less to max 
	public void inOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);			
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	//through tree 
	public void preOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);			
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void postOrderTraverseTree(Node focusNode){
		if(focusNode != null){			
			postOrderTraverseTree(focusNode.leftChild);			
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int key){
		Node focusNode = root;
		while(focusNode.key != key){
			if(key < focusNode.key){
				focusNode = focusNode.leftChild;
			}else{
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null)
				return null;
		}
		return focusNode;
	}
	

	public static void main(String[] args) {
		
		BinaryTree theTree = new BinaryTree();
		
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice Pres");
		theTree.addNode(10, "Office Manager");
		theTree.addNode(18, "Office Manager");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales");
		theTree.addNode(85, "Sales1");
		
		theTree.postOrderTraverseTree(theTree.root);
			

	}

}

class Node{
	
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
		this.key = key;
		this.name = name;
	}
	
	public String toString(){
		return name + " has a key " + key;
	}
}
