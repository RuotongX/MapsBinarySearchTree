package binarySearchTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class BinarySearchTree<K extends Comparable<K>,V> {
	Node<K, V> root;
	Set<Node<K, V>> elements = new HashSet<>();
	
	public BinarySearchTree(K key, V value){
		this.root = new Node<>(key,value);
		elements.add(root);
	}
	
	public void add(K key, V value) {		
		Node<K, V> nd = new Node<>(key,value);
		root.insert(nd);
		elements.add(nd);
	}
	public ArrayList<V> getValue(K key) {
		for(int i = 0;i<elements.size();i++) {
			if(key==((Node<K, V>) elements.toArray()[i]).getKey()) {
				return ((Node<K, V>) elements.toArray()[i]).getValues();
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
	public Set<Node<K, V>> entryset(Node<K, V> root) {
		Set<Node<K, V>> entry = new TreeSet<>((node1, node2) -> node1.getKey().compareTo(node2.getKey()));
		if(root == null) {
			return null;
		} else {
			inorder(root,entry);
		}
		return entry;
	}
	
	private void inorder(Node<K, V> root,Set<Node<K, V>> entry) {
		if(root == null) {
			return;
		}
		inorder(root.getLeft(),entry);
		entry.add(root);
		inorder(root.getRight(),entry);
	}
}
