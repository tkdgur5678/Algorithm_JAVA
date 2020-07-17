import java.util.Scanner;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.nextLine();
			if (str.equals(".")) {
				break;
			}
			boolean check = true;
			Stack<Character> s = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(' || c == '[') {
					s.add(c);
				} else if (c == ')') {
					if (s.size() > 0 && s.peek() == '(') {
						s.pop();
					} else {
						check = false;
						break;
					}
				} else if (c == ']') {
					if (s.size() > 0 && s.peek() == '[') {
						s.pop();
					} else {
						check = false;
						break;
					}
				}
			}
			if (s.size() > 0 || !check) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}

}
