package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;


public class PostorderIterator<T> implements Iterator<T> {
	private StackInterface<BinaryNode<T>> nodeStack;
	private BinaryNode<T> currentNode;
	
   
   

	public PostorderIterator(BinaryNode<T> root) {
		nodeStack = new ArrayStack<>();
		currentNode = (BinaryNode<T>) root;
		
        
	}
	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty() || (currentNode != null);
	}

	@Override
	public T next() {
		if (currentNode == null && nodeStack.isEmpty()) {
	        throw new NoSuchElementException();
	    }

	    while (currentNode != null || !nodeStack.isEmpty()) {
	        if (currentNode != null) {
	            if (currentNode.getRightChild() != null) {
	                nodeStack.push(currentNode.getRightChild());
	            }
	            nodeStack.push(currentNode);
	            currentNode = currentNode.getLeftChild();
	        } else {
	            BinaryNode<T> temp = nodeStack.pop();
	            if (temp.getRightChild() != null && !nodeStack.isEmpty() && temp.getRightChild() == nodeStack.peek()) {
	                currentNode = nodeStack.pop();
	                nodeStack.push(temp);
	            } else {
	                return temp.getData();
	            }
	        }
	    }

	    return null; 
	    }
	
        
    
		
	

	
	  
	
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
