public class HashIterator implements Iterator {

    OpenAddressing h; // the associated hash table
    int currentPos;   // position in the table's array that is currently marked.
    int lastPos = -1; // position of the last element returned by next() or previous()

    // Create an iterator that marks the leftmost actual data in the hash table.
    // Assume actual data are not 0 and DELETED.
    // If there are no actual data in the table, set currentPos to -1.
    public HashIterator(OpenAddressing o) {
        h = o;
        int i = 0;
        for (; i < o.array.length; i++) {
            if (o.array[i] != 0 && o.array[i] != OpenAddressing.DELETED) {
                currentPos = i;
                break;
            }
        }
        if (i >= o.array.length) {
            currentPos = -1;
        }
    }
    
//    @Override
//    public boolean hasNext() {
//        int i = currentPos + 1;
//        while (i < h.array.length && (h.array[i] == 0 || h.array[i] == OpenAddressing.DELETED)) {
//            i++;
//        }
//        return i < h.array.length;
//    }
//
//    @Override
//    public boolean hasPrevious() {
//        int i = currentPos - 1;
//        while (i >= 0 && (h.array[i] == 0 || h.array[i] == OpenAddressing.DELETED)) {
//            i--;
//        }
//        return i >= 0;
//    }
//    
//    @Override
//    public int next() throws Exception {
//        if (!hasNext()) {
//            throw new Exception();
//        }
//        int i = currentPos + 1;
//        while (i < h.array.length && (h.array[i] == 0 || h.array[i] == OpenAddressing.DELETED)) {
//            i++;
//        }
//        currentPos = i;
//        return h.array[i];
//    }
//
//    @Override
//    public int previous() throws Exception {
//        if (!hasPrevious()) {
//            throw new Exception();
//        }
//        int i = currentPos - 1;
//        while (i >= 0 && (h.array[i] == 0 || h.array[i] == OpenAddressing.DELETED)) {
//            i--;
//        }
//        currentPos = i;
//        return h.array[i+1];
//    }

    @Override
    public boolean hasNext() {
        for (int i = currentPos+1; i < h.array.length; i++) {
        	if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
        		return true;
        	}
        }
        return false;
    }

    @Override
    public boolean hasPrevious() {
        for (int i = currentPos-1; i >= 0; i--) {
        	if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
        		return true;
        	}
        }
        return false;
    }
    
    @Override
    public int next() throws Exception {
        if (!hasNext()) {
            throw new Exception();
        }
        for (int i = currentPos+1; i < h.array.length; i++) {
        	if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
        		currentPos = i;
        		return h.array[currentPos];
        	}
        }
        return -1;
    }

    @Override
    public int previous() throws Exception {
        if (!hasPrevious()) {
            throw new Exception();
        }
        for (int i = currentPos-1; i >= 0; i--) {
        	if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
        		currentPos = i;
        		return h.array[currentPos+1];
        	}
        }
        return -1;
    }
    
    public void set(int value) {
        // does not do anything,
        // because it will break hash table definition
    }

}
