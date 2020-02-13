package algo_basic.day7;

import java.util.Scanner;

public class SWEA_1233_D4_사칙연산유효성검사 {
	
	private static char[] word;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int possible = 1;
			char c = ' ';
			for (int i = 1; i <= N; i++) {
				sc.nextInt();
				c = sc.next().charAt(0);
				if((i*2>N && !isNum(c)) || isNum(c)) {	//숫자
						possible = 0;
				}
				if (i * 2 <= N || i * 2 + 1 <= N) {
					sc.nextInt();
				}
			}
			System.out.println("#"+test_case+" "+possible);
		}
	}
	public static boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}
}
