/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter03linkedlists;

public class LoopInALinkedList
{
	public static int findLengthOfTheLoop(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        int length = 0;
        if (loopExists) {
            do {
                slowPtr = slowPtr.getNext();
                length++;
            } while (slowPtr != fastPtr);
        }
        return length;
    }

    public static ListNode findBeginofLoop(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
            }
            return fastPtr;
        } else
            return null;
    }

    public static boolean findIfLoopExistsUsingFloyds(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr)
                return true;

        }
        return false;
    }

    public static boolean findIfLoopExistsUsingBrents(ListNode head){
        ListNode movingPtr = head;
        ListNode stationaryPtr = head;
        int stepsTaken = 0;
        int stepLimit = 2;
        while (movingPtr != null) {
            movingPtr = movingPtr.getNext();
            stepsTaken++;
            if (movingPtr == stationaryPtr)
                return true;
            if (stepsTaken == stepLimit) {
                stepLimit = 2 * stepLimit;
                stepsTaken = 0;
                stationaryPtr = movingPtr;
            }
        }
        return false;
    }
    
    
		
	
    public static void main(String[] args)
    {
    	LoopInALinkedList looplist=new LoopInALinkedList();
    	LinkedList a=new LinkedList();
		a.insert(1, 0);
		a.insert(6, 1);
		a.insert(7, 2);
		a.insert(8, 3);
		a.insert(9, 4);
		ListNode x=a.head;
		while(x.next.next!=null)
		{
			x=x.next;
		}
		x.next=x;
    	System.out.println(looplist.findIfLoopExistsUsingFloyds(a.head));
    	int xx=looplist.findLengthOfTheLoop(a.head);
    	ListNode m=looplist.findBeginofLoop(a.head);
    	System.out.println("length is"+xx);
    	System.out.println("begin of loop is"+m);
    }
}