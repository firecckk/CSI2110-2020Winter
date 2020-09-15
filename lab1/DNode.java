/**
 * A double node class for a doubly-linked list. Each node has a reference to a
 * stored element and a next node and a last node.
 *
 * @author Clare Cheng
 */

public class DNode {
    private Object element;
    private DNode prev;
    private DNode next;

    public DNode() {
        this(null, null, null);
    }

    public DNode(Object e, DNode next, DNode prev) {
        this.element = e;
        this.next = next;
        this.prev = prev;
    }

    public void setElement(Object newElem) {
        this.element = newElem;
    }

    public void setNext(DNode newNext) {
        this.next = newNext;
    }

    public void setPrev(DNode newPrev) {
        this.prev = newPrev;
    }

    public Object getElement() {
        return this.element;
    }

    public DNode getNext() {
        return this.next;
    }

    public DNode getPrev(){
        return this.prev;
    }
}