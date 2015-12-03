


public class CircularLinkedList{
	protected CLLNode head;
	protected CLLNode tail;
	protected int length;
	
	// Constructs a new circular list
	public CircularLinkedList(){
		head = null;
		tail = null;
		length = 0;
	}
	
	// Adds element to head of list
	public void addToHead(int data){
		CLLNode temp=new CLLNode(data);
		if (head == null && tail==null) { // first data added
			head = temp;
			head.setNext(temp);
			tail=head.getNext();
		} else { // element exists in list
		    temp.setNext(head);
		    head=temp;
		    tail.setNext(head);
		
		}
		length++;
	}
	
	// Adds element to tail of list
		public void addToTail(int data){
			// new entry:
			addToHead(data);
			head = head.getNext();
			tail=tail.getNext();
		}
		
	// Adds data to beginning of list.
	public void add(int data){
		addToHead(data);
	}
	

	
	
	
	// Returns data at head of list
	public int peek(){
		return head.getData();
	}
	
	// Returns data at tail of list
	public int tailPeek(){
		return tail.getData();
	}
	
	// Returns and removes data from head of list
	public int removeFromHead(){
		CLLNode temp = head; // ie. the head of the list
		if (head == head.getNext()) {
			head = null;
		} else {
			head=head.getNext();
			tail.setNext(head);
			temp.setNext(null); // helps clean things up; temp is free
		}
		length--;
		return temp.getData();
	}
	
	// Returns and removes data from tail of list
	public int removeFromTail(){
		if (isEmpty()){
			return Integer.MIN_VALUE;
		}
		CLLNode finger = head;
		while (finger.getNext() != tail) {
			finger = finger.getNext();
		}
		// finger now points to second-to-last data
		
		if (finger == head)	{
			head = null;
		} else {
			finger.setNext(tail.getNext());
			tail = finger;
		}
		length--;
		return tail.getData();
	}
	
	// Returns true if list contains data, else false
	public boolean contains(int data){
		if (head == null) return false;
		CLLNode finger;
		finger = head;
		do{
			finger = finger.getNext();
		}while (finger !=head && (!(finger.getData() == data)));
		return finger.getData() == data;
	}
	
	// Removes and returns element equal to data, or null
	public int remove(int data){
		if (head == null) return Integer.MIN_VALUE;
		CLLNode finger = head;
		CLLNode previous =tail;
		int compares;
		for (compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
			previous = finger;
			finger = finger.getNext();
		}
		if (finger.getData() == data) {
			// an example of the pigeon-hole principle
			if (head == head.getNext()) { 
				head = null; }
			else {
				if (finger == head) 
					head = previous;
				previous.setNext(previous.getNext().getNext());
			}
			// finger data free
			finger.setNext(null); 	// to keep things disconnected
			length--;            	// fewer elements
			return finger.getData();
		}
		else return Integer.MIN_VALUE;
	}

	// Return the current length of the CLL.
	public int size(){
		return length;
	}
    
    	// Return the current length of the CLL.
	public int length() {
		return length;
	}
	
	// Returns true if no elements in list
	public boolean isEmpty(){
		return head == null;
	}
	
	// Remove everything from the CLL.
	public void clear(){
		length = 0;
		head = null;
	}

	// Return a string representation of this collection, in the form: ["str1","str2",...].    
	public String toString(){
		String result = "[";
		if (head == null) {
			return result+"]";
		}
		result = result + head.getData();
		CLLNode temp = head.getNext();
		while (temp != head) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

  public void PrintList(CLLNode head)
  {
	  System.out.println("");
	  System.out.println("List");
	   CLLNode temp=head;
	 do
	 {
		 System.out.print("::"+temp.getData());
		
		  temp=temp.getNext();
		 } while(temp!=head);
	 System.out.println("");
  }

public static void main(String[] args)
{
	System.out.println("This program contains an operation related to circular linked lists");
	CircularLinkedList clist=new CircularLinkedList();
	clist.addToHead(5);
	clist.PrintList(clist.head);
	clist.addToHead(10);
	clist.addToHead(15);
	clist.addToHead(20);
    clist.PrintList(clist.head);
    clist.addToTail(2);
    clist.PrintList(clist.head);
    int a=clist.removeFromHead();
    System.out.println("removed from head"+a);
    clist.PrintList(clist.head);
    int b=clist.removeFromTail();
    System.out.println("removed from tail and now tail is"+b);
    clist.PrintList(clist.head);
    System.out.println("doest it contain 12?"+":"+clist.contains(12));
    clist.remove(10);
    System.out.println("remove 10");
    clist.PrintList(clist.head);
}
}