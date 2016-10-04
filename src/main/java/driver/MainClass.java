package driver;

import model.Node;

import java.util.Scanner;

/**
 * Created by rahul on 4/10/16.
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Enter number nodes to be added in linked list");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkList linkList = new LinkList();
        for (int i = 0; i < n; i++) {
            linkList.insert(new Node<Integer>(sc.nextInt()));
        }
        linkList.createLoop(6);

        //finder.impl.LinkedListLoopFinder listOperations = new finder.impl.LinkedListLoopFinder(linkList);

      //  Node loopStart=listOperations.getLoopStartNode(linkList.getHead());
     //   String result = ( loopStart == null) ? "No loop found":loopStart.getData().toString();
        //System.out.println(result);
    }
}
