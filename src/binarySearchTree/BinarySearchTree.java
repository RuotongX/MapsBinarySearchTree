package binarySearchTree;

import java.util.ArrayList;


public class BinarySearchTree<K,V> {
	Node root;
	ArrayList<Node> elements = new ArrayList<Node>();
	
	public BinarySearchTree(K key, V value){
		this.root = new Node(key,value);
		elements.add(root);
	}
	
	public void add(K key, V value) {		
		Node nd = new Node(key,value);
		root.insert(nd);
		elements.add(nd);
	}
	public ArrayList getValue(K key) {
		for(int i = 0;i<elements.size();i++) {
			if(key == elements.get(i)) {
				return elements.get(i).getValue();
			}
		}
		System.out.println("This input has not be found");
		return null;
	}
	
	public int treeHeight() {
		if(root != null)
			return root.getHight()-1;
		else 
			return 0;
	}
	public void keyset(Node root)//use recursion to print in order Traverse of the tree
	{
		if(root==null)
		{
			return;
		}
		else
		{
			keyset(root.getLeft());
			System.out.print(root.getKey());
			keyset(root.getRight());
		}
	}
}
