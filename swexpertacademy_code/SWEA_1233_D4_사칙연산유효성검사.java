package algo_basic.day7;

import java.util.Scanner;

public class SWEA_1233_D4_사칙연산유효성검사 {
	
	private static char[] word;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			word = new char[N+1];
			for (int i = 1; i <= N; i++) {
				sc.nextInt();
				word[i] = sc.next().charAt(0);
				if (i * 2 <= N) {
					sc.nextInt();
				}
				if (i * 2 + 1 <= N) {
					sc.nextInt();
				}
			}
			System.out.print("#"+test_case+" ");
			inorder(1,N);
			System.out.println();
		}
	}

	public static void inorder(int i, int N) {
		if (i > N)
			return;
		inorder(i * 2, N);
		//i
		System.out.print(word[i]);
		inorder(i * 2 + 1, N);
	}
}
