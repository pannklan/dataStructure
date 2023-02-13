public class StudentList extends CDLinkedList {

	public void swapNode(DListIterator i1, DListIterator i2) {
		if (i1.currentNode == null || i2.currentNode == null) return;
		DListNode p1 = i1.currentNode.previousNode;
		DListNode p2 = i2.currentNode.previousNode;
		DListNode n1 = i1.currentNode.nextNode;
		DListNode n2 = i2.currentNode.nextNode;
		
		p1.nextNode = i2.currentNode;
		i1.currentNode.previousNode = p2;
		
		i1.currentNode.nextNode = n2;
		n1.previousNode = i2.currentNode;

		p2.nextNode = i1.currentNode;
		i2.currentNode.previousNode = p1;
		
		i2.currentNode.nextNode = n1;
		n2.previousNode = i1.currentNode;
		
	}

    public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
    	if (i1.currentNode == null || lst.isEmpty()) {
            return;
       }
    	
//    	DListNode n1 = i1.currentNode;
//    	DListNode n2 = i1.currentNode.nextNode;
//    	DListNode l1 = lst.header.nextNode;
//    	DListNode l2 = lst.header.previousNode;
//    	
//    	n1.nextNode = l1;
//    	l1.previousNode = n1;
//    	l2.nextNode = n2;
//    	n2.previousNode = l2;
    	
    	DListIterator i = new DListIterator(lst.header.nextNode); 	
    	while (i.currentNode!=lst.header) {
    		insert(i.currentNode.data,i1);
    		i.next();
    		i1.next();
    		}
    }
    
    public void gender(String g) throws Exception {
    	DListIterator i = new DListIterator(header);
    	DListIterator t = new DListIterator(header);
    	while (i.currentNode.nextNode != header) {
    		i.next();
    		Student std = (Student) i.currentNode.data;
    		if (std.getSex().equals(g)) {
    			DListNode start = t.currentNode;
    			DListNode cont = t.currentNode.nextNode;
    			DListNode curr = i.currentNode;
    			DListNode prev = i.currentNode.previousNode;
    			DListNode next = i.currentNode.nextNode;
    			
    			if (prev != header) {
    				start.nextNode = curr;
    				curr.previousNode = start;
    				
    				curr.nextNode = cont;
    				cont.previousNode = curr;
    				
    				prev.nextNode = next;
    				next.previousNode = prev;
    				
    				i.currentNode = next.previousNode;
    			}
    			t.next();
    		}
    	}
    }

}