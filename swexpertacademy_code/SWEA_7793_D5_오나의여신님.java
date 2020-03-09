package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793_D5_오나의여신님 {

	static int N, M, result;
	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Node> q;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // height
			M = Integer.parseInt(st.nextToken()); // weight
			map = new char[N][M];
			visited = new boolean[N][M];
			result = 0;
			q = new LinkedList<>();
			Node player = null, devil = null;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') { // 수연
						player = new Node(i, j, 0);
						visited[i][j] = true;
						map[i][j] = '.';
					} else if (map[i][j] == '*') {
						q.add(new Node(i, j, -1));
					}
				}
			};
			q.add(player);
			bfs();
			System.out.print("#" + test_case + " ");
			System.out.println(result>0 ? result : "GAME OVER");
		}
	}

	public static void bfs() {
		boolean[][] visited = new boolean[N][M];

		while (!q.isEmpty()) {
			Node n = q.poll();

			// 악마의 손아귀든 수연이든 상하좌우로 움직임
			for (int d = 0; d < dir.length; d++) {
				int ni = n.i + dir[d][0];
				int nj = n.j + dir[d][1];
				if (isIn(ni, nj) && map[ni][nj] == '.') {
					if (n.v == -1) { // 악마
						map[ni][nj] = '*';
						q.add(new Node(ni, nj, -1));
					} else if (!visited[ni][nj]) { // 수연
						visited[ni][nj] = true;
						q.add(new Node(ni, nj, n.v + 1));
					}
				} else if (isIn(ni, nj) && n.v != -1 && map[ni][nj] == 'D') {
					result = n.v + 1;
					return;
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
		int v;

		public Node(int i, int j, int v) {
			// super();
			this.i = i;
			this.j = j;
			this.v = v;
		}
	}
}
