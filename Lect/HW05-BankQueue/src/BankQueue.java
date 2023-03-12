public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		float totalPeople = 0;
		for (DeQ q : counters) {
			totalPeople += q.size();
		}
		
		int neededQLen = (int) Math.round(totalPeople/(counters.length+1));
		
		for (DeQ q : counters) {
			DeQ temp = new DeQLinkedList();
			while (q.size() > neededQLen) {
				temp.insertFirst(q.removeLast());
			}
			while (special.size() < neededQLen && !(temp.isEmpty())) {
				special.insertLast(temp.removeFirst());
			}
			while (!(temp.isEmpty())) {
				q.insertLast(temp.removeFirst());
			}
			
		}
		if (special.isEmpty()) {
			special.insertFirst(counters[counters.length-1].removeLast());
		}
	}
	
}