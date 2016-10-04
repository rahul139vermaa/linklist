package finder.impl;

import finder.LoopFinder;
import model.Node;

/**
 * Created by rahul on 4/10/16.
 */
public class LinkedListLoopFinder<T> implements LoopFinder {

    private Node<T> head;

    public LinkedListLoopFinder(Node<T> node) {
        this.head = node;
    }

    public Node<T> getLoopStartNodeElseNull() throws NullPointerException{
        if(isLinkedListNull()) throw new NullPointerException("Linked list is Empty");
        Node<T> loopNode=getNodeFromLoopElseNull();
        return findStartNodeOfLoopElseNull(loopNode);
    }

    private boolean isLinkedListNull(){
        if(head == null) return true;
        return false;
    }

    private Node<T> findStartNodeOfLoopElseNull(Node<T> loopNode) {
        if(loopNode != null){
            Node<T> ptr=head;
            while(loopNode != ptr){
                loopNode=loopNode.getNext();
                ptr=ptr.getNext();
            }
            return ptr;
        }
        return null;
    }

    private Node<T> getNodeFromLoopElseNull(){
        /*if(isLinkedListNull()) return null;*/ //this line was redundant so was impacting code coverage
        Node<T> slow=head;
        Node<T> fast=head;
        while(fast !=null && fast.getNext() !=null){
            fast=fast.getNext().getNext();
            slow=slow.getNext();
            if(fast==slow){
                return fast;
            }
        }
        return null;
    }

}