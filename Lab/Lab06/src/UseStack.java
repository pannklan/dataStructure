
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception{
		ArrayListStack result = new ArrayListStack();
		ArrayListStack temp = new ArrayListStack();
		
		int max = -1;
		
		while (!s.isEmpty()) {
			if (s.top()>max) {
				if (max!=-1) {
					temp.push(max);
				}
				max=s.top();
				s.pop();
			}
			else {
				temp.push(s.top());
				s.pop();
			}
			result.push(max);
			while (!temp.isEmpty()) {
				s.push(temp.top());
				temp.pop();
			}
		}
		return result;
	}
}