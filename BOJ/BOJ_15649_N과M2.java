package day0218;

import java.util.Scanner;

public class BOJ_15649_N과M2 {

	public static int N, M;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dfs(0, 1, new int[M]);
		System.out.println(sb);
	}

	public static void dfs(int depth, int start, int[] arr) {
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1, i + 1, arr);
		}
	}
}
