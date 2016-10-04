package driver;

import model.Node;

/**
 * Created by rahul on 4/10/16.
 */
public class LinkList {

    private Node<Integer> head;
    private Node<Integer> tail;
    public void insert(Node<Integer> item){
        if(item==null){
            return;
        }
        if(head==null){
            head=item;
            tail =item;
        }
        else {
            tail.setNext(item);
            tail =item;
        }
    }

    public void createLoop(int k){
        if (head == null && k<1){
            return;
        }
        Node<Integer> ptr=head;
        while(ptr.getNext() != null && k>1){
            ptr=ptr.getNext();
            k--;
        }
        if(k==1){
            tail.setNext(ptr);
        }
    }

    public Node<Integer> getHead(){
        return head;
    }

    public Node<Integer> getTail() {
        return tail;
    }
}
