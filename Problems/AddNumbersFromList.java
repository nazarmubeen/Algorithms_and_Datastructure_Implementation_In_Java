


public class AddNumbersFromList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode head = new ListNode();
        ListNode cur = head;
        int advance = 0;
        while(l1 != null && l2 != null){
            int sum = l1.data + l2.data + advance;
            advance = sum / 10;
            sum = sum % 10;
            cur.next= new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l1, new ListNode(advance));
            else
                cur.next = l1;
        }else if(l2 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l2, new ListNode(advance));
            else
                cur.next = l2;
        }else if(advance != 0){
            cur.next = new ListNode(advance);
        }
        return head.next;
    }
    
    
    public static void main(String[] args)
    {
    	AddNumbersFromList add=new AddNumbersFromList();
    	LinkedList a=new LinkedList();
    	LinkedList b=new LinkedList();
    	LinkedList ad=new LinkedList();
    	a.insert(1, 0);
    	a.insert(6, 1);
    	a.insert(7, 2);
    	a.insert(8, 3);
    	a.insert(9, 4);
    	a.print(a.head);
    	b.insert(1, 0);
    	b.insert(2, 1);
    	b.insert(3, 2);
    	b.insert(4, 3);
    	b.insert(5, 4);
    	a.print(b.head);
    	
    	ad.head=add.addTwoNumbers(a.head, b.head);
    	a.print(ad.head);
    }
}