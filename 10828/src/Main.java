import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		class Stack {
			ArrayList<Integer> stack = new ArrayList<Integer>();
			
			void push(int num) {
				stack.add(0, num);
			}
			int pop() {
				if(size()==0) return -1;
				int num = stack.get(0);
				stack.remove(0);
				return num;
			}
			int size() {
				return stack.size();
			}
			int empty() {
				return (stack.isEmpty())? 1 : 0;
			}
			int top() {
				if(size()==0) return -1;
				return stack.get(0);
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		Stack stack = new Stack();
		
		while(testCase-- > 0) {
			switch(sc.next()) {
			case "push":
				stack.push(sc.nextInt());
				break;
			case "pop" :
				System.out.println(stack.pop());
				break;
			case "size" :
				System.out.println(stack.size());
				break;
			case "empty" :
				System.out.println(stack.empty());
				break;
			case "top" :
				System.out.println(stack.top());
				break;
			}
		}
	}
}
