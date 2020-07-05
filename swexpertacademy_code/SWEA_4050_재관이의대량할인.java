package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4050_재관이의대량할인 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int result = 0;
			int cnt = 1;
			for (int i = N-1; i >= 0; i--) {
				if(cnt++%3==0) continue;
				result += arr[i];
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
