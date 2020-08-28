import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_5525_IOIOI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N
		int M = sc.nextInt(); // S¿« ±Ê¿Ã
		String S = sc.next();
		StringBuilder sb = new StringBuilder("I");
		for (int i = 0; i < N; i++) {
			sb.append("OI");
		}
		System.out.println(kmp(S, sb.toString()).size());
	}

	static ArrayList<Integer> kmp(String str, String pattern) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] pi = getPi(pattern);
		int n = str.length(), m = pattern.length(), j = 0;
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();

		for (int i = 0; i < n; i++) {
			while (j > 0 && s[i] != p[j]) {
				j = pi[j - 1];
			}

			if (s[i] == p[j]) {
				if (j == m - 1) {
					list.add(i - m + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		return list;
	}

	static int[] getPi(String pattern) {
		int len = pattern.length();
		int j = 0;
		char[] p = new char[len];
		int[] pi = new int[len];

		p = pattern.toCharArray();

		for (int i = 1; i < len; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}

		return pi;
	}
}
