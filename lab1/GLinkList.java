/** 
 * Builds a singly linked list of size 5 and prints it to the console.
 * 
 * @author Jochen Lang
 */

class GLinkList<E> {
	GNode<E> llist;
	
	public GLinkList(){
		this.llist = null;
	}
	
	public void add(GNode<E> node){
		// 0 node
		if ( this.llist == null ){
			this.llist = node;
			return;
		}
		// 1 or more nodes
		GNode<E> last = this.llist;
		// find the last node
		while( last.getNext() != null ) {
			last = last.getNext();
		}
		last.setNext(node);
	}

    /**
     * Print all the elements of the list assuming that they are Strings
     */
    public void print() {
	/* Print the list */
	GNode<E> current = llist; // point to the first node
	while (current != null) {
	    System.out.print(current.getElement().toString() + " ");	
	    current = current.getNext(); // move to the next
	}
	System.out.println();	
    }

    public void deleteFirst() {
	if ( llist != null ) {
	    llist = llist.getNext();
	}
    }

    public void deleteLast() {
	if ( llist == null ) return; // no node
	GNode<E> prev = llist;
	GNode<E> current = prev.getNext(); 
	if ( current == null ) { // only 1 node
	    llist = null;
	    return;
	}
	while ( current.getNext() != null ) { // more than 1 node
	    prev = current;
	    current = current.getNext();
	}
	prev.setNext( null );
	return;
    }

    // create and display a linked list
    public static void main(String [] args){
	/* Create the list */
	GLinkList<Integer> llist = new GLinkList<Integer>();
	for ( int i = 0; i < 5; i++){
		GNode<Integer> node = new GNode<Integer>();
		node.setElement(i);
		llist.add(node);
	}
	/* Print the list */
	llist.print();
	/* delete first and print */
	llist.deleteFirst();
	llist.print();
	/* delete last and print 5 times */
	for ( int i=0; i< 5; ++i ) {
	    llist.deleteLast();
	    llist.print();
	}
    }
}
