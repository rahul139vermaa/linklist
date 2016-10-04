package finder;

import driver.LinkList;
import finder.impl.LinkedListLoopFinder;
import model.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by rahul on 4/10/16.
 */
public class LinkedListLoopFinderTests extends TestBase {

    //Test with null linklist
    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForEmptyList(){
        LinkedListLoopFinder linkedListLoopFinder = new LinkedListLoopFinder<Integer>(null);
        linkedListLoopFinder.getLoopStartNodeElseNull();
    }

    //test with single node without loop
    @Test
    public void testLinkedListWithSingleNodeWithoutLoop(){
        List<Integer> list=new ArrayList<Integer>();
        list.add(5);
        LinkList linkList=  createLinkedListWithoutLoop(list);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",null,loopStart);
    }

    //test with single node having loop on same node
    @Test
    public void testLinkedListWithSingleNodeWithLoop(){
        List<Integer> list=new ArrayList<Integer>();
        list.add(5);
        LinkList linkList=  createLinkedListWithLoop(list,1);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",linkList.getHead(),loopStart);
    }



    //test with odd length, without loop
    @Test
    public void testLinkedListWithOddLengthWithoutLoop(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        for (int i = 0; i < 7; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        LinkList linkList=  createLinkedListWithoutLoop(list);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",null,loopStart);
    }


    //test with even length, without loop
    @Test
    public void testLinkedListWithEvenLengthWithoutLoop(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        for (int i = 0; i < 8; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        LinkList linkList=  createLinkedListWithoutLoop(list);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",null,loopStart);
    }

    //test with odd length, with loop which points at last node
    @Test
    public void testLinkedListWithOddLengthWithLoopPointAtLastNode(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        int n=7;
        for (int i = 0; i < n; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        LinkList linkList=createLinkedListWithLoop(list,n);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",linkList.getTail(),loopStart);
    }

    //test with Even length, with loop which points at last node
    @Test
    public void testLinkedListWithEvenLengthWithLoopPointAtLastNode(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        int n=10;
        for (int i = 0; i < n; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        LinkList linkList=createLinkedListWithLoop(list,n);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",linkList.getTail(),loopStart);
    }

    //test with Odd length, with loop which points at first node
    @Test
    public void testLinkedListWithOddLengthWithLoopPointAtFirstNode(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        int n=21;
        for (int i = 0; i < n; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        LinkList linkList=  createLinkedListWithLoop(list,1);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",linkList.getHead(),loopStart);
    }

    //test with Even length, with loop which points at first node
    @Test
    public void testLinkedListWithEvenLengthWithLoopPointAtFirstNode(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        int n=20;
        for (int i = 0; i < n; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        LinkList linkList=  createLinkedListWithLoop(list,1);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Assert.assertEquals("Loop start is not as Expected",linkList.getHead(),loopStart);
    }

    //test with Odd length, with loop which points at any mid node
    @Test
    public void testLinkedListWithOddLengthWithLoopPointAtMidNode(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        int n=11;
        for (int i = 0; i < n; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        int mid=n/2;
        LinkList linkList=  createLinkedListWithLoop(list,mid);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Node ptr=linkList.getHead();

        while(ptr!=null && ptr.getNext()!=null && mid>1) {
            ptr=ptr.getNext();
            mid--;
        }
        Assert.assertEquals("Loop start is not as Expected",ptr,loopStart);
    }

    //test with Even length, with loop which points at any mid node
    @Test
    public void testLinkedListWithEvenLengthWithLoopPointAtMidNode(){
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        int n=10;
        for (int i = 0; i < n; i++) {
            list.add(Math.abs(random.nextInt(100)));
        }
        int mid=n/2;
        LinkList linkList=  createLinkedListWithLoop(list,mid);
        LinkedListLoopFinder<Integer> linkedListLoopFinder = new LinkedListLoopFinder<Integer>(linkList.getHead());
        Node<Integer> loopStart=linkedListLoopFinder.getLoopStartNodeElseNull();
        Node ptr=linkList.getHead();

        while(ptr!=null && ptr.getNext()!=null && mid>1) {
            ptr=ptr.getNext();
            mid--;
        }
        Assert.assertEquals("Loop start is not as Expected",ptr,loopStart);
    }
}
