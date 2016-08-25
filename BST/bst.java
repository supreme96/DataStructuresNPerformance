//Created by Sahil Tandon 
//The program uses generic datatype for the stored value and can be easily changed to support different datatypes.

public class bst {

	public static void main(String args[]){
		BST<Integer> tree = new BST<Integer>();
		tree.createTree(5);
		System.out.println(tree.getRoot().getData());
	}

}


class BST<t> {
	
	private	node<t> root;

	public node<t> getRoot(){
		return root;
	}

	public void createTree(t data){
		root = new node<t>();
		root.setData(data);
		root.left = null;
		root.right = null;
	}
}

class node<T> {
	private T data;
	public node<T> left;
	public node<T> right;

	public void setData(T data){
		this.data = data;
	}

	public T getData(){
		return data;
	}
}