

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

    private static class Node<E> implements Position<E> {

        private E element;               
        private Node<E> prev;            
        private Node<E> next;            

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() throws IllegalStateException {
            if (next == null)                         
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }
    
        public void setNext(Node<E> n) {
            next = n;
        }
        
        public String toString(){
            return element.toString();
        }
    } 

    private Node<E> header;                       
    private Node<E> trailer;                      
    private int size = 0;                         

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);      
        trailer = new Node<>(null, header, null);   
        header.setNext(trailer);                    
    }

/************ ADD validate() and position() **************/



    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);  // create and link a new node
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());       
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);     
    }

/*** ADD addBefore() addAfter() and set() ***/



    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);           
        node.setNext(null);              
        node.setPrev(null);
        return answer;
    }

    public String toString() {
        String s = "(";
        Node<E> n = header.getNext();
        while (n != trailer){
            s = s + n.getElement();
            n = n.getNext();
            if (n != trailer)
            s = s + (", ");
        }
        s = s + (")");
        return s;
    }
}
