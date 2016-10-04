package finder;

import driver.LinkList;
import model.Node;

import java.util.List;

/**
 * Created by rahul on 4/10/16.
 */
public class TestBase {

    protected LinkList createLinkedListWithoutLoop(List<Integer> list){
        LinkList linkList=new LinkList();
        for(Integer element:list){
            linkList.insert(new Node<Integer>(element));
            System.out.printf(element+"->");
        }
        return linkList;
    }

    protected LinkList createLinkedListWithLoop(List<Integer> list,int loopStart){
        if (list==null||list.isEmpty()){
            return null;
        }
        LinkList linkList=new LinkList();
        for(Integer element:list){
            linkList.insert(new Node<Integer>(element));
            System.out.printf(element+"->");
        }
        linkList.createLoop(loopStart);
        System.out.println("Loop at "+list.get(loopStart-1));
        return linkList;
    }
}
