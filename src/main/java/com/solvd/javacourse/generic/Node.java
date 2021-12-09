package com.solvd.javacourse.generic;

public class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		// TODO Auto-generated method stub
		return next;
	}
}
