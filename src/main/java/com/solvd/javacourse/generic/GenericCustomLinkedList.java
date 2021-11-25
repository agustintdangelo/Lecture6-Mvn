package com.solvd.javacourse.generic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericCustomLinkedList<T> {
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
//	            System.out.print(currentNode.data + " ");
//	            currentNode = currentNode.next;
//	        }
			size = sizeRecursion(currentNode);
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

}
