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
		Node nodePositionFinder = root;
		Node parentTracker;
		boolean leftRightFlag;
		while(nodeReference != null){
			parentTracker = nodePositionFinder;
			if(nodeReference.getData()>=data){
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
		nodePositionFinder = null;
		parentTracker = null;
		System.out.println("Node Added Successfully");
	}

	public Node locateParentNode(t data){
		Node nodeReference = root;
		Node parentTracker;
		while(nodeReference!=null){
			parentTracker = nodeReference;
			if (nodeReference.getData() == data) {
				return parentTracker;
			}
			else if (nodeReference.getData()>=data){
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
			if (nodeReference.getData() == data) {
				return nodeReference;
			}
			else if (nodeReference.getData()>=data){
				nodeReference = nodeReference.left;
			}
			else{
				nodeReference = nodeReference.right;
			}
		}
		return null;
	}

	public boolean searchNode(t data){
		Node locationResult = 	locateNode(data);
		if(locateResult!=null){
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
			if(locateResult.left.getData() == data){
				locateResult.left == null;
			}
			else{
				locateResult.right == null;
			}
			return true; //Report true that the node value was successfully deleted.
		}
		else{
			return false; //Report a node not found.
		}	
	}

}

class Node<T> {
	private T data;
	public Node<T> left;
	public Node<T> right;

	public void setData(T data){
		this.data = data;
	}

	public T getData(){
		return data;
	}

}