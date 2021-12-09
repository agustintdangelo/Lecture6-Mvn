package com.solvd.javacourse.generic;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericCustomLinkedList<T> implements Iterable<Node<T>> {
	private final static Logger LOG = Logger.getLogger(GenericCustomLinkedList.class.getName());
	Node<T> head;

	public T get(int index) {
		Node<T> currentNode = head;
		Node<T> auxNode = null;
		if (index < this.size()) {
			auxNode = nodeAtRecursion(currentNode, index);
		}
		return auxNode.data;
	}

	private Node<T> nodeAtRecursion(Node<T> currentNode, int index) {
		// TODO Auto-generated method stub
		Node<T> auxNode = null;
		if (index > 0) {
			auxNode = currentNode;
			return nodeAtRecursion(currentNode.next, index - 1);
		} else {
			auxNode = currentNode;
		}
		return auxNode;
	}

	public int size() {
		Node<T> currentNode = head;
		int size = 0;
		if (currentNode == null) {
			return size;
		} else {
//	        while(currentNode != null) {
//	            size++;
//	            currentNode = currentNode.next;
//	        }
			size = sizeRecursion(currentNode); // NO
		}
		return size;
	}

	private int sizeRecursion(Node<T> currentNode) {
		// TODO Auto-generated method stub
		int size = 0;
		if (currentNode != null) {
			size++;
			return size + sizeRecursion(currentNode.next);
		} else {
			return size;
		}
	}

	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> currentNode = head;
//			while (currentNode.next != null) {
//				currentNode = currentNode.next;
//			}
//			currentNode.next = newNode;
			insertRecursion(currentNode, newNode);
		}
	}

	public void insertRecursion(Node<T> currentNode, Node<T> newNode) {
		if (currentNode.next == null) {
			currentNode.next = newNode;
		} else {
			insertRecursion(currentNode.next, newNode);
		}
	}

	public void insertAtStart(T data) {
		Node<T> newNode = new Node<T>(data);

		newNode.next = head;
		head = newNode;
	}

	public void insertAt(int index, T data) {
		if (index == 0) {
			insertAtStart(data);
		} else {
			Node<T> newNode = new Node<T>(data);

			Node<T> currentNode = head;
//			for (int i = 0; i < index - 1; i++) {
//				currentNode = currentNode.next;
//			}
//			newNode.next = currentNode.next;
//			currentNode.next = newNode;
			insertNodeRecursion(currentNode, newNode, index - 1);
		}
	}

	private void insertNodeRecursion(Node<T> currentNode, Node<T> newNode, int index) {
		if (index == 0) {
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		} else {
			insertNodeRecursion(currentNode.next, newNode, index - 1);
		}
	}

	public void deleteData(T data) {
		// Case1: when there is no element in LinkedList
//        if(head==null){  //means LinkedList in empty, throw exception.              
//               throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
//        }

		// Case2: when there is only one element in LinkedList- check whether we have to
		// delete that Node or not.
		if (head.data == data) { // means LinkedList consists of only one element, delete that.
			Node<T> tempNode = head; // save reference to first Node in tempNode- so that we could return saved
										// reference.
			head = head.next;
			System.out.println("Node with data=" + tempNode.data + " was found on first and has been deleted.");
		} else {
			Node<T> previous = null;
			Node<T> current = head;
			while (current != null && current.data != data) {
				if (current.next == null) { // Means Node wasn't found.
					System.out.println("Node with data=" + data + " wasn't found for deletion.");
				}
				previous = current;
				current = current.next;
			}
			if (current.data == data) {
				System.out.println("Node with data=" + current.data + " has been deleted.");
				previous.next = current.next; // make previous node's next point to current node's next. //return
												// deleted
				// Node.
			}
		}

		// Case3: when there are atLeast two elements in LinkedList

	}

	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> currentNode = head;
//			for (int i = 0; i < index - 1; i++) {
//				currentNode = currentNode.next;
//			}
//			currentNode.next = currentNode.next.next;
			deleteAtRecursion(currentNode, index - 1);
		}
	}

	private void deleteAtRecursion(Node<T> currentNode, int index) {
		if (index == 0) {
			currentNode.next = currentNode.next.next;
		} else {
			deleteAtRecursion(currentNode.next, index - 1);
		}

	}

	public void show() {
		Node<T> currentNode = head;
		if (currentNode == null) {
			LOG.log(Level.INFO, "Linked list is empty");
		} else {
//	        while(currentNode != null) {
//	            System.out.print(currentNode.data + " ");
//	            currentNode = currentNode.next;
//	        }
			printingNodeRecursion(currentNode);
		}
	}

	private void printingNodeRecursion(Node<T> currentNode) {
		if (currentNode != null) {
			LOG.log(Level.INFO, "Data: " + currentNode.data);
			if (currentNode.next != null) {
				printingNodeRecursion(currentNode.next);
			}
		}
	}

	public String toStringNodes() {
		String nodes = "";
		Node<T> currentNode = head;
		while (currentNode != null) {
			nodes += currentNode.data.toString();
			nodes += ", ";
			currentNode = currentNode.next;
		}
		return nodes;
	}

	@Override
	public String toString() {
		return "[" + toStringNodes() + "]";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Iterator<Node<T>> iterator() {
		return new ListIterator(head);
	}

}
