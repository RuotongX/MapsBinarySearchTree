package binarySearchTree;
import java.util.ArrayList;
/**
 * This is the node class which create the tree node
 * @author RuotongXu 16935995
 *
 * @param <K>
 * @param <V>
 */
public class Node<K extends Comparable<K>,V> {
	protected K key;
	protected ArrayList<V> values = new ArrayList<V>();

	
	private Node<K,V> left;
	private Node<K,V> right;
	
	public Node() {
		key = null;
		left = null;
		right = null;
	}
	/**
	 * This is the constructor of this class.
	 * @param key
	 * @param value
	 */
	public Node(K key,V value) {
		this.key = key;
		values.add(value);
		left = null;
		right = null;
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
	/**
	 * This insert method is just find a suitable place for the node to store by using recursion, once the input node is smaller than current node,
	 * it will go to compare with the current node left child, if larger compare with the right child,
	 * until it find a place is null for it.
	 * @param input
	 */
	public void insert(Node input) {
		if((int)input.getKey()<(int)this.getKey()) {
			if(this.left == null) {
				this.setLeft(input);
				return;
			} else {
				this.left.insert(input);
			}
		}
		else if((int)input.getKey()>(int)this.getKey()) {
			if(this.right == null) {
				this.setRight(input);
				return;
			} else {
				this.right.insert(input);
			}
		}
		else {
			this.values.add((V) input.values.get(0));
		}
	}
	/**
	 * This gethight method is used to find the left child height and right child height by using recursion, then
	 * compare which one is higher, return that value.
	 * @return
	 */
	
	public int getHight() {
		int lheight = 0 , rheight = 0;
		if(this.left!=null)
			lheight = this.left.getHight();
		if(this.right!=null) 
			rheight = this.right.getHight();
		return 1+Math.max(lheight, rheight);
	}
	/**
	 * This is the toString method of node.
	 */
	public String toString() {
		return "Key: "+this.key+" Value: "+this.values.toString();
	}
}
