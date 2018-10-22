package binarySearchTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
/**
 * This class is used to create the binary search tree
 * @author RuotongXu 16935995
 *
 * @param <K>
 * @param <V>
 */


public class BinarySearchTree<K extends Comparable<K>,V> {
	Node<K, V> root;
	Set<Node<K, V>> elements = new HashSet<>();
	/**
	 * This is the constructor of this class.
	 * @param key
	 * @param value
	 */

	public BinarySearchTree(K key, V value){
		this.root = new Node<>(key,value);
		elements.add(root);
	}
	/**
	 * This is the add method.
	 * @param key
	 * @param value
	 */

	public void add(K key, V value) {		
		Node<K, V> nd = new Node<>(key,value);
		root.insert(nd);
		elements.add(nd);
	}
	/**
	 * This method is used to return a arraylist of value(because a key can have many values)
	 * by using the for loop to search the element arraylist.
	 * @param key
	 * @return
	 */

	public ArrayList<V> getValue(K key) {
		for(Node<K,V> temp : entryset(root)) {
			if(temp.getKey().equals(key)) {
				return temp.getValues();
			}
		}
		System.out.println("This input has not be found");
		return null;
	}
	/**
	 * This method is used to get the tree height.
	 * @return
	 */

	public int treeHeight() {
		if(root != null)
			return root.getHight()-1;
		else 
			return 0;
	}
	/**
	 * This method is used to return the keyset by create a new set, the for loop in this method is used to avoid the duplicate key.
	 * @param root
	 * @return
	 */
	public Set<K> keyset(Node<K, V> root)
	{
		Set<K> keyset =  new HashSet<>();
		if(root==null)
		{
			return null;
		}
		else
		{
			for(int i =0;i<elements.size();i++) {
				if(keyset.contains(((Node<K, V>) elements.toArray()[i]).getKey())) {
					
				} else {
					keyset.add((K) ((Node<K, V>) elements.toArray()[i]).getKey());
				}
			}
		}
		return keyset;
	}
	/**
	 * This method is same as the keyset.
	 * @param root
	 * @return
	 */
	public Set<V> valueset(Node<K, V> root) {
		Set<V> valueset = new HashSet<>();
		if(root==null)
		{
			return null;
		}
		else
		{
			for(int i =0;i<this.keyset(root).size();i++) {
				valueset.addAll(this.getValue(((K)this.keyset(root).toArray()[i])));
			}
		}
		return valueset;
	}
	/**
	 * This is the method to return the entryset by using the inorder recursion.
	 * The tree set and the contains in the bracket means the order is in this set is follow the compareTo rule to keep it is ascending ordered view .
	 * @param root
	 * @return
	 */
	public Set<Node<K, V>> entryset(Node<K, V> root) {
		Set<Node<K, V>> entry = new TreeSet<>((node1, node2) -> node1.getKey().compareTo(node2.getKey()));
		if(root == null) {
			return null;
		} else {
			inorder(root,entry);
		}
		return entry;
	}
	/**
	 * This is the inorder recursion method, which can get each tree nodes from small to large.
	 * @param root
	 * @param entry
	 */
	private void inorder(Node<K, V> root,Set<Node<K, V>> entry) {
		if(root == null) {
			return;
		}
		inorder(root.getLeft(),entry);
		entry.add(root);
		inorder(root.getRight(),entry);
	}
}
