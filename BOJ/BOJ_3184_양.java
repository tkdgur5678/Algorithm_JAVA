import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3184_양 {
	static int R, C, sheep, wolf;
	static char[][] map;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visited;

	static boolean isIn(int y, int x) {
		return y >= 0 && y < R && x >= 0 && x < C;
	}

	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(y, x));
		visited[y][x] = true;
		int s = 0; // sheep
		int w = 0; // wolf
		while (!q.isEmpty()) {
			Node n = q.poll();
			if(map[n.y][n.x] == 'o') {
				s++;
			} else if(map[n.y][n.x] == 'v') {
				w++;
			}
			for (int d = 0; d < dirs.length; d++) {
				int ny = n.y + dirs[d][0];
				int nx = n.x + dirs[d][1];
				if(isIn(ny,nx) && map[ny][nx]!='#' && !visited[ny][nx]) {
					q.add(new Node(ny,nx));
					visited[ny][nx] = true;
				}
			}
		}
		if(s>w) {
			sheep+=s;
		} else {
			wolf+=w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sheep = wolf = 0;
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			visited[r] = new boolean[C];
		}

		for (int r = 0; r < R; r++) {
			map[r] = sc.next().toCharArray();
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != '#' && !visited[r][c]) {
					bfs(r, c);
				}
			}
		}
		System.out.println(sheep + " " + wolf);
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
