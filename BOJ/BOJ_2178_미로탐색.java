import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178_미로탐색 {

	static int N, M, result;
	static char[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static boolean isIn(int y, int x) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			visited[i] = new boolean[M];
		}
		q.add(new Node(0, 0, 1));
		visited[0][0] = true;
		result = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node n = q.poll();
			// 종료 조건 N, M 위치에 도착했을때
			if (n.y == N-1 && n.x == M-1) {
				result = Integer.min(result, n.v);
				continue;
			}
			for (int d = 0; d < dir.length; d++) {
				int ny = n.y + dir[d][0];
				int nx = n.x + dir[d][1];
				if (isIn(ny, nx) && !visited[ny][nx] && map[ny][nx] == '1') {
					q.add(new Node(ny, nx, n.v + 1));
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		bfs();
		System.out.println(result);
	}

	static class Node {
		int x, y, v;

		public Node(int y, int x, int v) {
			this.y = y;
			this.x = x;
			this.v = v;
		}
	}

}
