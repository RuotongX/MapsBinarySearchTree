package binarySearchTree;
import java.util.ArrayList;

public class Node<K,V> {
	protected K key;
	protected ArrayList<V> values = new ArrayList<V>();

	
	private Node<K,V> left;
	private Node<K,V> right;
	
	public Node() {
		key = null;
		left = null;
		right = null;
	}
	public Node(K key,V value) {
		this.key = key;
		values.add(value);
		left = null;
		right = null;
	}
	
	public ArrayList getValue() {
//		String value = "";
//		for(int i = 0;i<values.size();i++) {
//			value = value+" "+values.get(i);
//		}
		return values;
	}
	public K getKey() {
		return key;
	}
	
	public Node<K, V> getLeft() {
		return left;
	}

	public void setLeft(Node<K, V> left) {
		this.left = left;
	}

	public Node<K, V> getRight() {
		return right;
	}

	public void setRight(Node<K, V> right) {
		this.right = right;
	}
	public ArrayList<V> getValues() {
		return values;
	}
	public void insert(Node input) {
		if((int)input.getKey()<(int)this.getKey()) {
			if(this.left == null) {
				this.left.setLeft(input);
				return;
			} else {
				this.left.insert(input);
			}
		}
		else if((int)input.getKey()>(int)this.getKey()) {
			if(this.right == null) {
				this.right.setRight(input);
				return;
			} else {
				this.right.insert(input);
			}
		}
		else {
			this.values.add((V) input.values.get(0));
		}
	}
	
	public int getHight() {
		int lheight = 0 , rheight = 0;
		if(this.left!=null)
			lheight = this.left.getHight();
		if(this.right!=null) 
			rheight = this.right.getHight();
		return 1+Math.max(lheight, rheight);
	}
}
