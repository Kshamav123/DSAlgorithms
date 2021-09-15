package com.datastructure;

public class BalancedParanthesis<T> {

	static CreatingStack<Character> stack = new CreatingStack<>();

	/* logic for checking balanced paranthesis */

	public static <T> void balanced(String expr) {

		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(') {
				stack.push(expr.charAt(i));
			} else if (expr.charAt(i) == ')') {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not balanced");
		}

	}

	public static void main(String[] args) {
		String para = "(8+23)*(0+9)/(21+8)";// (8+23)*(0+9/(21+8)
		balanced(para);

	}

}

/**
 * creating the stack
 * @author kshamavidyananda
 *
 * @param <T>
 */

class CreatingStack<T> {
	char data[];
	int top = 0;

	CreatingStack() {
		data = new char[100];
	}

	public void push(char a) {
		data[top] = a;
		top++;

	}

	public char pop() {
		top--;
		char b = data[top];
		return b;
	}

	public char peek() {
		char c = data[top - 1];
		return c;

	}

	public boolean isEmpty() {
		if (top == 0)
			return true;
		return false;
	}

	public int size() {
		return top;
	}
}
