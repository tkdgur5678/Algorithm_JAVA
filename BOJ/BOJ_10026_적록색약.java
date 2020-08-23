package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

	static int N, A, B;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		visited[y][x] = true;
		q.add(new Node(y, x));
		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int d = 0; d < dirs.length; d++) {
				int ny = n.y + dirs[d][0];
				int nx = n.x + dirs[d][1];

				if (isIn(ny, nx) && map[ny][nx] == map[n.y][n.x] && !visited[ny][nx]) {
					q.add(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = B = 0;
		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					A++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					B++;
				}
			}
		}
		System.out.println(A + " " + B);

	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
