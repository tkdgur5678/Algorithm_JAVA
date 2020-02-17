import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static int N, result;
	static int[][] map, dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] value;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			value = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(value[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = Integer.MAX_VALUE;
			bfs();
			System.out.println("Problem " + test_case++ + ": " + value[N - 1][N - 1]);
		}
	}

	public static void bfs() {
		value[0][0] = map[0][0];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		int ni, nj;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int d = 0; d < dir.length; d++) {
				ni = n.i + dir[d][0];
				nj = n.j + dir[d][1];
				if (isIn(ni, nj) && value[n.i][n.j] + map[ni][nj] < value[ni][nj]) {
					value[ni][nj] = value[n.i][n.j] + map[ni][nj];
					q.add(new Node(ni,nj));
				}
			}
		}
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 & i < N && j < N;
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
