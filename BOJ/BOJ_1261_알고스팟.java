package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1261_¾Ë°í½ºÆÌ {
	static int N, M, result = 0;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map, value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		value = new int[N][M];
		for (int i = 0; i < value.length; i++) {
			Arrays.fill(value[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
		System.out.println(value[N - 1][M - 1]);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		value[0][0] = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int ni = n.i + dir[d][0];
				int nj = n.j + dir[d][1];
				if (isIn(ni, nj)) {
					if (map[ni][nj] == 1 && value[ni][nj] > value[n.i][n.j] + 1) {
						value[ni][nj] = value[n.i][n.j] + 1;
						q.add(new Node(ni, nj));
					} else if (map[ni][nj] == 0 && value[ni][nj] > value[n.i][n.j]) {
						value[ni][nj] = value[n.i][n.j];
						q.add(new Node(ni, nj));
					}
				}
			}
		}
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}
