
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}
	
	public void insert(int value, Iterator p) throws Exception {
		DListIterator insertAfter = (DListIterator) p;
		DListNode insertNode = new DListNode(value);
		insertNode.previousNode=insertAfter.currentNode;
		insertNode.nextNode=insertAfter.currentNode.nextNode;
		insertAfter.currentNode.nextNode.previousNode=insertNode;
		insertAfter.currentNode.nextNode=insertNode;
		size++;
		
		int count = 1;
		DListIterator left = insertAfter;
		DListIterator right = new DListIterator (insertAfter.currentNode.nextNode);
		while (left.previous() == value) {
			count++;
		}
		while (right.next() == value) {
			count++;
		}
		left.next();
		if (count >= 3) {
		    removeBetween(left, right, count);
		    score += count;
		    while (left.currentNode.data == right.currentNode.data) {
		    	count = 1;
		    	value = left.currentNode.data;
		    	while (left.previous() == value) {
					count++;
				}
				while (right.next() == value) {
					count++;
				}
				left.next();
				if (count >= 3) {
				    removeBetween(left, right, count);
				    score += count;
				}
		    	
		    }
		}
	}
	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		if (left == null || right == null || left.currentNode==right.currentNode || left.currentNode.nextNode == right.currentNode)
			return;
		left.currentNode.nextNode=right.currentNode;
		right.currentNode.previousNode=left.currentNode;
		size-=inc;
	}
	
}
