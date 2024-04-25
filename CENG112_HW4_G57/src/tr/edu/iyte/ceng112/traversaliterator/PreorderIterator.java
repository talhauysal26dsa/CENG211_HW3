package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;


public class PreorderIterator<T> implements Iterator<T> {
	private StackInterface<BinaryNode<T>> nodeStack;
	private BinaryNode<T> currentNode;

	
	public PreorderIterator(BinaryNode<T> root) {
		nodeStack = new ArrayStack<>();
		currentNode = (BinaryNode<T>) root;
	}
	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty() || (currentNode != null);
	}

	@Override
	public T next() {
		
		
		BinaryNode<T> nextNode = null;

	    while (currentNode != null || !nodeStack.isEmpty()) {
	        if (currentNode != null) {
	            nextNode = currentNode;
	            if (nextNode.getRightChild() != null) {
	                nodeStack.push(nextNode.getRightChild());
	            }
	            currentNode = nextNode.getLeftChild();
	            break;
	        } else {
	            currentNode = nodeStack.pop();
	        }
	    }

	    if (nextNode == null) {
	        throw new NoSuchElementException();
	    }

	    return nextNode.getData();
	    

	    }
	public void remove() {
		throw new UnsupportedOperationException();
	}
	}

