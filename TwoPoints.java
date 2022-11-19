import java.util.*;

public class TwoPoints{
    //Represents the node of list.
    public class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    //Declaring head and tail pointer as null.
    public Node head = null;
    public Node tail = null;

    //This function will add the new node at the end of the list.
    public void addAtEnd(int data){
        //Create new node
        Node newNode = new Node(data);
        //Checks if the list is empty.
        if(head == null) {
            //If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            //tail will point to new node.
            tail.next = newNode;
            //New node will become new tail.
            tail = newNode;
            //Since, it is circular linked list tail will points to head.
            tail.next = head;
        }
    }
    int detectLoop(int x, int y) {
        Node ptr = head;
        Node nxt = ptr.next;
        Node a = ptr, b = ptr;
        while (nxt.next != head) {
            if (nxt.data == x) {
                a = ptr.next;
            }
            if (nxt.data == y) {
                b = ptr.next;
            }
            ptr = ptr.next;
            nxt=nxt.next;

        }


        Node slowPointer = b,
                fastPointer = a;

        while (slowPointer != null
                && fastPointer != null
                && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer)
                return slowPointer.data;
        }

        return slowPointer.data;
    }

    //Displays all the nodes in the list
    public void display() {
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            // System.out.println("Adding nodes to the end of the list: ");
            do{
                //Prints each node by incrementing pointer.
                System.out.print(" "+ current.data);
                current = current.next;
            }while(current != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwoPoints cl = new TwoPoints();

        cl.display();
        cl.addAtEnd(1);
        cl.addAtEnd(2);
        cl.addAtEnd(3);
        cl.addAtEnd(4);
        cl.addAtEnd(5);
        cl.addAtEnd(6);
        cl.addAtEnd(7);
        cl.addAtEnd(8);
        cl.addAtEnd(9);
        cl.addAtEnd(10);
        cl.addAtEnd(11);
        cl.addAtEnd(12);
        cl.display();
        //The first parameter is the fast pointer which moves 2* faster
        //The second parameter is the slow pointer
        System.out.println(cl.detectLoop(2,5));
    }
}