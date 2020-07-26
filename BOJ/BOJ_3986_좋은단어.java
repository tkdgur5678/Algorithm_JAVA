import java.util.Scanner;
import java.util.Stack;

public class BOJ_3986_좋은단어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			Stack<Character> s = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				if (s.size() > 0 && s.peek() == str.charAt(j)) {
					s.pop();
				} else {
					s.add(str.charAt(j));
				}
			}
			if(s.size()==0) {
				result++;
			}
		}
		System.out.println(result);
	}

}
