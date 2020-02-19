package algo_basic.day8;

import java.util.Scanner;

public class SWEA_8821_D3_적고지우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] num = new int[10];
			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				num[str.charAt(i) - '0']++;
			}
			int result = 0;
			for (int i = 0; i < 10; i++) {
				if (num[i] % 2 == 1)
					result++;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
