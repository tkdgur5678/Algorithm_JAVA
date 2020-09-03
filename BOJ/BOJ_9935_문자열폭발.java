import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_9935_¹®ÀÚ¿­Æø¹ß {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String bomb = sc.next();
		int str_len = str.length();
		int bomb_len = bomb.length();
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < str_len; i++) {
			list.add(str.charAt(i));
		}
		Stack<Node> stack = new Stack<>();
		int idx = 0;
		for (int i = 0; i < str_len; i++) {
			if (str.charAt(i) == bomb.charAt(idx)) {
				idx++;
			} else if (str.charAt(i) == bomb.charAt(0)) {
				idx = 1;
			} else {
				idx = 0;
			}
			stack.push(new Node(str.charAt(i), idx));
			if(idx == bomb_len) {
				for (int j = 0; j < bomb_len; j++) {
					stack.pop();
				}
				if(!stack.empty())
					idx = stack.peek().i;
				else
					idx = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(stack.size() == 0) {
			System.out.println("FRULA");
		} else {
			for (int i = stack.size() - 1; i >= 0; i--) {
				sb.append(stack.pop().c);
			}
		}
		System.out.println(sb.reverse());
	}

	static class Node {
		char c;
		int i;

		public Node(char c, int i) {
			this.c = c;
			this.i = i;
		}
	}
}
