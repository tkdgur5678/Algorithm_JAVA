import java.util.Scanner;

public class BOJ_2789_유학금지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] word = {'C','A','M','B','R','I','D','G','E'};
		String str = sc.next();
		String result = "";
		loop: for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < word.length; j++) {
				if(str.charAt(i) == word[j]) {
					continue loop;
				}
			}
			result += str.charAt(i);
		}
		System.out.println(result);
	}

}
