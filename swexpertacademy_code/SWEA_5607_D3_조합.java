package algorithm;

import java.util.Scanner;

public class SWEA_5607_D3_조합 {

	static int P = 1234567891;

	public static long pow(long num, long i) {
		if (i == 0)
			return 1;
		long temp = pow(num, i / 2);
		long ret = (temp * temp) % P;
		return i % 2 == 0 ? ret : (ret * num) % P;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long[] fact = new long[N + 1];
			fact[0] = 1;
			for (int i = 1; i <= N; i++) {
				fact[i] = (fact[i - 1] * i) % P;
			}

			long result = (fact[N - R] * fact[R]) % P;
			// 분모의 -1을 P-2승으로 만들어줌
			result = pow(result, P - 2);
			System.out.println("#" + test_case + " " + (fact[N] * result) % P);
		}
	}

}
