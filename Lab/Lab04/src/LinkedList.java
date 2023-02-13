import org.w3c.dom.Node;

class ListNode {
	// Constructors
	ListNode(Object theElement) {
		this(theElement, null);
	}

	ListNode(Object theElement, ListNode n) {
		data = theElement;
		nextNode = n;
	}

	// Friendly data; accessible by other package routines
	Object data;
	ListNode nextNode;
}

public class LinkedList {
	ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}
//

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = null;
	}

	public void insert(Object value, Iterator p) throws Exception {
		if (p == null || !(p instanceof MyListIterator))
			throw new Exception();
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();
		ListNode n = new ListNode(value, p2.currentNode.nextNode);
		p2.currentNode.nextNode = n;
	}

	public int find(Object value) throws Exception {
		Iterator itr = new MyListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v.equals(value))
				return index; // return the position of value.
		}
		return -1;
	}

	public Iterator findPrevious(Object value) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		Object currentData = itr2.next();
		while (!currentData.equals(value) && itr2.hasNext()) {
			currentData = itr2.next();
			itr1.next();
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}
	
	public void remove(Iterator p) {
		if (p == null || !(p instanceof MyListIterator))
			return;
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null || p2.currentNode.nextNode == null)
			return;
		p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
	}

	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// Returns the number of data stored in this list.
	// To be completed by students.
	public int size() throws Exception{
		int count = 0;
	    ListNode current = header.nextNode;
	    while (current != null) {
	        count++;
	        current = current.nextNode;
	    }
	    return count;
	}
	
	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception{
		ListNode current = this.header;
		for (int i=0; i<this.size(); i++) {
			ListNode contact = current;
		    System.out.println(contact.toString());
		    System.out.println("");
		    current=current.nextNode;
		}

	}

	//Return iterator pointing to value that stores a given name, or null otherwise.
	//To be completed by students.
	public Iterator findPosition(String name) throws Exception{
		MyListIterator current = new MyListIterator(header);
		while (current.hasNext()){
			current.next();
			Object currentData= current.currentNode.data;
			Contact contact = (Contact) currentData;
			if (contact.name==name) {
				return current;
			}
		}
		return null;
	}
	
//	public Iterator findPosition(String name) throws Exception{
//		MyListIterator current = new MyListIterator(header);
//		while (current.hasNext()) {
//			Contact contact = (Contact) current.next();
//			if (contact.name==name) {
//				return new MyListIterator((ListNode) current.next());
//			}
//		}
//		return null;
//	}
//	

	//add a new contact to the list the contact must be added in such a way that each contact is sorted by name, in alphabetical order.	
//	private int compare(String name1, String name2) {
//	    int length = Math.min(name1.length(), name2.length());
//	    for (int i = 0; i < length; i++) {
//	        if (name1.charAt(i) < name2.charAt(i)) {
//	            return -1;
//	        } else if (name1.charAt(i) > name2.charAt(i)) {
//	            return 1;
//	        }
//	    }
//	    return name1.length() - name2.length();
//	}
//	public void add(Object c) {
//	    Contact newContact = (Contact) c;
//	    ListNode current = header.nextNode;
//	    ListNode prev = header;
//	    Contact currentNode = (Contact) current.data;
//
//	    while (current != null && compare(currentNode.name, newContact.name) < 0) {
//	        prev = current;
//	        current = current.nextNode;
//	        currentNode = (Contact) current.data;
//	    }
//
//	    ListNode newNode = new ListNode(newContact);
//	    prev.nextNode = newNode;
//	    newNode.nextNode = current;
//	}
	
	public void add(Object c) throws Exception{
		Contact contact = (Contact) c;
		ListNode current = header;
		while (current.nextNode!=null && ((Contact) current.nextNode.data).name.compareTo(contact.name)<0) {
			current=current.nextNode;
		}
		current.nextNode=new ListNode(c,current.nextNode);
	}

	
	//Remove the contact pointed by the iterator, i, and then returns an iterator pointing to the next contact. 
	//If the removed contact is the last one, return the iterator pointing to the first contact 
	//   (if there is no first contact, make the iterator point to header). 
	//If i is marking an illegal position that cannot be removed, just return null. 
	//To be completed by students.
	// just find previous node of current node then connect it with its next 2 node.
	
	public Iterator removeAt(Iterator i) {
		MyListIterator itr = (MyListIterator) i;
		ListNode current = header;
		while (current.nextNode != null && current.nextNode != itr.currentNode) {
			current=current.nextNode;
		}
		if (current.nextNode==null) {
			return null;
		}
		current.nextNode=current.nextNode.nextNode;
		
		if (current.nextNode!=null) {
			return new MyListIterator(current.nextNode);
		}
		if (header.nextNode!=null) {
			return new MyListIterator(header.nextNode);
		}
		return new MyListIterator(header);
	}

}