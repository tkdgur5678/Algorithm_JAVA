package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2617_구슬찾기 {
	static int midCount, N, M, result = 0, count;
	static List<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
		}
		midCount = (N + 1) / 2;
		for (int i = 1; i <= N; i++) {
			count = 0;
			small(i, new boolean[N + 1]);
			if (N % 2 == 0) {
				if (count >= midCount + 1) {
					result++;
					continue;
				}
			} else {
				if (count >= midCount) { // 작은게 많음
					result++;
					continue;
				}
			}
			count = 0;
			large(i, new boolean[N + 1]);
			if (count >= midCount) { // 큰게 많음
				result++;
			}
		}
		System.out.println(result);
	}

	public static void small(int num, boolean[] visited) {
		for (int n : list[num]) {
			if (!visited[n]) {
				visited[n] = true;
				count++;
				small(n, visited);
			}
		}
	}

	public static void large(int num, boolean[] visited) {
		for (int i = 1; i <= N; i++) {
			if (num == i)
				continue;
			if (!visited[i] && list[i].contains(num)) { // 크다
				visited[i] = true;
				count++;
				large(i, visited);
			}
		}
	}

}
