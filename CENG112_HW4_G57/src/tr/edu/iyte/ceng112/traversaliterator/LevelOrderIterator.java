package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tr.edu.iyte.ceng112.queue.ArrayQueue;
import tr.edu.iyte.ceng112.queue.EmptyQueueException;
import tr.edu.iyte.ceng112.queue.QueueInterface;

import tr.edu.iyte.ceng112.tree.BinaryNode;

public class LevelOrderIterator<T> implements Iterator<T> {
	private QueueInterface<BinaryNode<T>> nodeQueue;
	private BinaryNode<T> currentNode;

	public LevelOrderIterator(BinaryNode<T> root) {
		nodeQueue = new ArrayQueue<>();
		currentNode = (BinaryNode<T>) root;
	}
	@Override
	public boolean hasNext() {
		return !nodeQueue.isEmpty() || (currentNode != null);
	}

	@Override
	public T next() {
		
		if (currentNode == null && nodeQueue.isEmpty()) {
	        throw new NoSuchElementException();
	    }

	    if (currentNode == null) {
	        try {
				currentNode = nodeQueue.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    BinaryNode<T> nextNode = currentNode;

	    if (nextNode.getLeftChild() != null) {
	        nodeQueue.enqueue(nextNode.getLeftChild());
	    }

	    if (nextNode.getRightChild() != null) {
	        nodeQueue.enqueue(nextNode.getRightChild());
	    }

	    if (!nodeQueue.isEmpty()) {
	        try {
				currentNode = nodeQueue.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        currentNode = null;
	    }

	    return nextNode.getData();
		
	}

}
