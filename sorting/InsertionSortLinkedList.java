
public class InsertionSortLinkedList {
	public static ListNode insertionsort(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode newhead=new ListNode(head.data);
		ListNode key=newhead;
		ListNode pointer=head.next;
		ListNode check=pointer;
		while(pointer!=null)
		{
		if(check.getData()>=key.getData())
		{	
			pointer=pointer.next;
			key.next=check;
			check.next=null;
			key=key.next;
			check=pointer;
		}
		else if(check.getData()<key.getData())
		{	
			
			ListNode innerpointer=newhead;
			if(check.data<=innerpointer.getData())
			{
				pointer=pointer.next;
				check.next=newhead;
				newhead=check;
				check=pointer;
			}
			else {
			while(innerpointer!=null && innerpointer.next!=null && pointer!=null)
			{	
				
			 if(check.data>=innerpointer.getData() && check.data<innerpointer.next.getData())
				{
					pointer=pointer.next;
					check.next=innerpointer.next;
					innerpointer.next=check;
					check=pointer;
				}
				
				else{
					innerpointer=innerpointer.next;
				}
			}
			}
			}
		
		}
		
		return newhead;
	}
	public static ListNode insertionSortList(ListNode head) {
 		if (head == null || head.next == null)
			return head;
 
		ListNode newHead = new ListNode(head.data);
		System.out.println("new head data"+""+newHead.getData());
		ListNode pointer = head.next;
		System.out.println("pointer data"+""+pointer.getData());
		// loop through each element in the list
		System.out.println("loop throgh each element");
		while (pointer != null) {
			// insert this element to the new list
			System.out.println("In loop strating ->check for pointer value"+pointer);
			ListNode innerPointer = newHead;
			System.out.println("inner pointer data"+""+innerPointer.getData());
			ListNode next = pointer.next;
			if(next!=null)
			System.out.println("next data"+""+next.getData());
			else
				System.out.println("next is null");
			if (pointer.data <= newHead.data) {
				System.out.println("if loop (pointer.data <= newHead.data)"+(pointer.data <= newHead.data));
				ListNode oldHead = newHead;
				System.out.println("oldhead data"+""+oldHead.getData());
				newHead = pointer;
				System.out.println("newhead"+""+newHead.getData());
				newHead.next = oldHead;
				System.out.println("newHead->next data"+""+newHead.next.getData());
			} else {
				System.out.println("if loop (pointer.data <= newHead.data) fail");
				while (innerPointer.next != null) {
						System.out.println("in innner pointer while-> data"+innerPointer.next.getData());
					if (pointer.data > innerPointer.data && pointer.data <= innerPointer.next.data) {
						ListNode oldNext = innerPointer.next;
						System.out.println("oldNext data"+""+oldNext.getData());
						innerPointer.next = pointer;
						System.out.println("innerpointer->next data"+""+innerPointer.next.getData());
						pointer.next = oldNext;
						System.out.println("pointer->next data"+""+pointer.next.getData());
					}
 
					innerPointer = innerPointer.next;
					System.out.println("innerpointer at end of else while"+""+innerPointer.getData());
				}
 
				if (innerPointer.next == null && pointer.data > innerPointer.data) {
					System.out.println("if (innerPointer.next == null && pointer.data > innerPointer.data) pass");
					innerPointer.next = pointer;
					System.out.println("innerpointer->next data"+""+innerPointer.next.getData());
					pointer.next = null;
					System.out.println("pointer->next data"+""+pointer.next);
				}
			}
			
			// finally
			pointer = next;
			if(pointer!=null)
			System.out.println("pointer at end of while data"+""+pointer.getData());
			else
				System.out.println("pointer is null");
		}
		
		return newHead;
	}
 
	public static void main(String[] args) {
		ListNode n1 = new ListNode(20);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(14);
 		ListNode n4 = new ListNode(13);
		ListNode n5 = new ListNode(44);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		printList(n1);
		//n1 = insertionSortList(n1);
		
		//printList(n1);
		n1=insertionsort(n1);
		printList(n1);
 
	}
 
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.data + " ");
			while (x.next != null) {
				System.out.print(x.next.data + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
}