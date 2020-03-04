package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15900_나무탈출 {

	static int result = 0, N;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		bfs();
		System.out.println(result%2 == 0 ? "No" : "Yes");
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.add(1);
		q.add(-1);
		visited[1] = true;
		int count = 0;
		while (q.size() > 1) {
			int n = q.poll();
			if (n == -1) {
				count++;
				q.add(-1);
				continue;
			}
			boolean check = false;
			for (Integer i : list[n]) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
					check = true;
				}
			}
			if (!check) { // 리프 노드
				result += count;
			}
		}
	}
}
