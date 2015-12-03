
public class ExchangeAdjacentNodes {
    public ListNode exchangeAdjacentNodes(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp, curr = head,next=head.next;
        while(curr != null && next != null){
           curr.next=next.next;
           next.next=curr;
           prev.next=next;
           prev=curr;
           next=curr.next.next;
           curr=curr.next;
         
        }
        return temp.next;
    }
public static void main(String[] args)
{
	ExchangeAdjacentNodes edn=new ExchangeAdjacentNodes();
	LinkedList a=new LinkedList();
	a.insert(1, 0);
	a.insert(6, 1);
	a.insert(7, 2);
	a.insert(8, 3);
	a.insert(9, 4);
	a.print(a.head);
	//edn.exchangeAdjacentNodes(a.head);
	a.print(edn.exchangeAdjacentNodes(a.head));
}


}
