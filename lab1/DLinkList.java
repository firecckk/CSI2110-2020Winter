import java.util.Currency;

/**
 * Builds a doubly linked list
 * 
 * @author ClareCheng
 */

class DLinkList {
    DNode header;
    DNode trailer;

    public DLinkList( int size ){
        if ( size <= 0 ) {
            // zero node
            this.header = null;
            this.trailer = null;
        } else {
            // one or more nodes
            this.header = new DNode( 0, null, null);
            this.trailer = header;
            DNode prev = header;
            for ( int i=1; i<size; i++) {
                this.trailer = new DNode( i, null, prev);
                prev.setNext(this.trailer);
                prev = this.trailer;
            }
        }
    }

    public void print() {
        if ( this.header == null ) {
            System.out.println("empty!");
            return;
        };
        DNode current = this.header;
        String std_out = current.getElement().toString();
        while ( ( current = current.getNext() ) != null ) {
            std_out += " " + current.getElement().toString();
        }
        System.out.println(std_out);
    }

    /* delete the first element on the list */
    public void deleteFirst() {
        // no node
        if (header == null)
            return;
        // 1 node
        else if (header.getNext() == null) {
            header = null;
            trailer = null;
            return;
        }
        // more than 1 nodes
        else {
            DNode secondNode = this.header.getNext();
            secondNode.setPrev(null);
            this.header = secondNode;
        }
    }

    /* delete the last element of the list */
    public void deleteLast() {
        // no node
        if (this.trailer == null)
        return;
        // 1 node
        else if (this.trailer.getPrev() == null) {
            this.header = null;
            this.trailer = null;
            return;
        } else {
            // more than 1 nodes
            DNode prev = this.trailer.getPrev();
            prev.setNext(null);
            this.trailer = prev;
        }
    }

    public static void main( String [] args){
        DLinkList list = new DLinkList( 5 );
        list.print();
        for ( int i=0; i< 5; ++i ) {
            list.deleteLast();
            list.print();
        }
        list = new DLinkList( 5 );
        list.print();
        for ( int i=0; i< 5; ++i ) {
            list.deleteFirst();
            list.print();
        }

    }
}