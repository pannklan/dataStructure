public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
	    if (q.isEmpty()) {
	        q.insertLast(x);
	        return;
	    }
	    int size = q.size();
	    int i = 0;
	    while (i < size && x >= q.front()) {
	        q.insertLast(q.removeFirst());
	        i++;
	    }
	    q.insertLast(x);
	    while (i < size) {
	        q.insertLast(q.removeFirst());
	        i++;
	    }
	}
	    //this stuck in forever loop
//	public void push(int x) throws Exception {
//	    if (q.isEmpty()) {
//			q.insertLast(x);
//			return;
//		}
//		int p=q.front();
//		while (x >= q.front()) {
//			q.insertLast(q.removeFirst());
//		}
//		q.insertLast(x);
//		while (q.front()>=p) {
//			q.insertLast(q.removeFirst());
//		}
//		return;		
//	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return q.front();
	}

}