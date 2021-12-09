package com.solvd.javacourse.generic;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<Node<T>> {
	private Node<T> current;

	public ListIterator(Node<T> first) {
		current = first;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public Node<T> next() {
		Node<T> tempo = current;
		current = current.getNext();
		return tempo;
	}
}
