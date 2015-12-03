



public class DoublyLinkedList{
	// properties
	private DLLNode head;
	private int length;

	// Create a new empty list.
	public DoublyLinkedList() {
		head = null;
		length = 0;
	} 

	// Get the value at a given position.
	public int get(int position) {
		return Integer.MIN_VALUE;
	}

	// Find the position of the head value that is equal to a given value.
	// The equals method us used to determine equality.
	public int getPosition(int data) {
		// go looking for the data
		DLLNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				// return the position if found
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		// else return -1
		return Integer.MIN_VALUE;
	} 

	// Return the current length of the DLL.
	public int length() {
		return length;
	}

	// Add a new value to the front of the list.
	public void insert(int newValue) {
		DLLNode newNode = new DLLNode(newValue,null,null);
		if(head==null)
		{
			head=newNode;
		}
		else{
		head.setPrev(newNode);
		newNode.setNext(head);
		head=newNode;
		length += 1;
		System.out.println("length is"+length);
		}
		} 

// Add a new value to the list at a given position.
	// All values at that position to the end move over to make room.
	public void insert(int data, int position) {
		// fix the position
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}

		// if the list is empty, make it be the only element
		if (head == null) {
			head = new DLLNode(data);
		}
		// if adding at the front of the list...
		else if (position == 0) {
			DLLNode temp = new DLLNode(data);
			head.prev=temp;
			temp.next = head;
			head = temp;
		}
		// else find the correct position and insert
		else {
			DLLNode temp = head;
			for (int i=1; i<position; i+=1) {
				temp = temp.getNext();
			}
			DLLNode newNode = new DLLNode(data);
			temp.next.prev = newNode;
			newNode.next = temp.next;
			newNode.prev = temp;
			temp.next = newNode;
		}
		// the list is now one value longer
		length += 1;
	} 

	// Add a new value to the rear of the list.
	public void insertTail(int newValue,DLLNode head) {
		DLLNode temp=head;
		DLLNode newNode = new DLLNode(newValue,null,null);
		while(temp.next!=null)
		{
			temp=temp.getNext();
		}
		newNode.setPrev(temp);
		temp.setNext(newNode);
		length += 1;
		System.out.println("length"+":"+length);
	}

	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	public void remove(int position) {
		// fix position
		if (position < 0) {
			position = 0;
		}
		
		if (position >= length) {
			position = length-1;
		}
		
		// if nothing in the list, do nothing
		if (head == null)
			return;
		
		// if removing the head element...
		if (position == 0) {
			head = head.getNext();
			
		}
		// else advance to the correct position and remove
		else {
			DLLNode temp = head;
			for (int i=1; i<position; i+=1) {
				temp = temp.getNext();
			}
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
		}
		// reduce the length of the list
		length -= 1;
	}
	
	// Remove a node matching the specified node from the list.  
	// Use equals() instead of == to test for a matched node.
	public synchronized void removeMatched(DLLNode node) {
		if (head == null) 
			return;
		if (node.equals(head)) { 
			head = head.getNext(); 
			return;
		}
		DLLNode p = head;
		while(p != null) {
			if (node.equals(p)) {
				p.prev.next = p.next;
				p.next.prev = p.prev;
				return;
			}
		}
	}

	// Remove the head value from the list. If the list is empty, do nothing.
	public int removeHead() {
		if (length == 0)
		    return Integer.MIN_VALUE;
		DLLNode save = head;
		head=head.getNext();
		head.getNext().setPrev(null);
		save.setNext(null);
		
		length -= 1;
		System.out.println("length"+":"+length);
		return save.getData();
		
	} 
	

	
	// Remove everything from the DLL.
	public void clearList(){
		head = null;
		length = 0;
	}

	public void print(DLLNode head)
	{
		DLLNode temp=head;
		System.out.println("");
		System.out.println("List Data");
		while(temp!=null)
		{
			System.out.print("::"+temp.getData());
			temp=temp.getNext();
		}
		System.out.println("");
	}
	public static void main(String[] args)
	{
		DoublyLinkedList dlist=new DoublyLinkedList();
		dlist.insert(00);
		dlist.insert(05);
		dlist.insert(15);
		dlist.insert(25);
		dlist.print(dlist.head);
		System.out.println("insert 12 at 2nd position");
		dlist.insert(12, 2);
		dlist.print(dlist.head);
		System.out.println("inserting tails 9,19,29");
		dlist.insertTail(9,dlist.head);
		dlist.insertTail(19,dlist.head);
		dlist.insertTail(29,dlist.head);
		dlist.print(dlist.head);
		System.out.println("remove third elemnt");
		dlist.remove(3);
		dlist.print(dlist.head);
		System.out.println("remove head");
		int a=dlist.removeHead();
		System.out.println("removed head"+a);
		dlist.print(dlist.head);
	}
	
	
	
	
	
	
} 
