//Created by Sahil Tandon 
//The program uses generic datatype for the stored value and can be easily changed to support different datatypes.

public class bst {

	public static void main(String args[]){
		BST<Integer> tree = new BST<Integer>();
		tree.createTree(5);
		System.out.println(tree.getRoot().getData());
	}

}


class BST<t extends Comparable<t>> {
	
	private	Node<t> root;

	public Node<t> getRoot(){
		return root;
	}

	public void createTree(t data){
		root = new Node<t>();
		root.setData(data);
		root.left = null;
		root.right = null;
	}

	public void addNode(t data){
		Node newNode = new Node();
		newNode.setData(data);
		Node nodeReference = root;
		Node parentTracker = root;
		boolean leftRightFlag = true;
		while (nodeReference != null){
			parentTracker = nodeReference;
			if(nodeReference.getData().compareTo(data)>0){
				nodeReference = nodeReference.left;
				leftRightFlag = true;	
			}
			else{
				nodeReference = nodeReference.right;
				leftRightFlag = false;
			}
		}
		if(leftRightFlag == true){
			parentTracker.left = newNode;
		}
		else{
			parentTracker.right = newNode;
		}
		newNode = null;
		nodeReference = null;
		parentTracker = null;
		System.out.println("Node Added Successfully");
	}

	public Node locateParentNode(t data){
		Node nodeReference = root;
		Node parentTracker;
		while(nodeReference!=null){
			parentTracker = nodeReference;
			if (nodeReference.getData().equals(data)) {
				return parentTracker;
			}
			else if (nodeReference.getData().compareTo(data)>0){
				nodeReference = nodeReference.left;
			}
			else{
				nodeReference = nodeReference.right;
			}
		}
		return null;
	}

	public Node locateNode(t data){
		Node nodeReference = root;
		while(nodeReference!=null){
			if (nodeReference.getData().equals(data)) {
				return nodeReference;
			}
			else if (nodeReference.getData().compareTo(data)>0) {
				nodeReference = nodeReference.left;
			}
			else{
				nodeReference = nodeReference.right;
			}
		}
		return null;
	}

	public boolean searchNode(t data){
		Node locationResult = locateNode(data);
		if(locationResult!=null){
			return true; //Search hit
		}
		else{
			return false; //Search miss.
		}
	}

	public boolean updateNodeValue(t currentData, t newData){
		Node locateResult = locateNode(currentData);
		if(locateResult!=null){
			locateResult.setData(newData);
			return true; //Report true that the node value was successfully updated.
		}
		else{
			return false; //Report a node not found.
		}	
	}

	public boolean deleteNode(t data){
		Node locateResult = locateParentNode(data);
		if(locateResult!=null){
			if(locateResult.left.getData().equals(data)) {
				locateResult.left = null;
			}
			else{
				locateResult.right = null;
			}
			return true; //Report true that the node value was successfully deleted.
		}
		else{
			return false; //Report a node not found.
		}	
	}

}

class Node<t extends Comparable<t>> {
	private t data;
	public Node<t> left;
	public Node<t> right;

	public void setData(t data){
		this.data = data;
	}

	public t getData(){
		return data;
	}

}