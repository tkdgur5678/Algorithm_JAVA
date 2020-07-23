import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_ºù»ê {

	static int N, M;
	static int[][] map, temp, dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		while (true) {
			time++;
			
			temp = new int[N][M];
			// ºù»ê ³ìÀÌ±â
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0) {
						melt(i,j);
					}
				}
			}

			map = temp;
			
			visited = new boolean[N][M];
			// µÎ µ¢ÀÌ Ã¼Å©
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			if (count > 1) {
				break;
			} else if(count == 0) {
				time = 0;
				break;
			}
		}
		System.out.println(time);
	}

	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int ny = n.y + dir[d][0];
				int nx = n.x + dir[d][1];
				if (isIn(ny, nx) && map[ny][nx] > 0 && !visited[ny][nx]) {
					q.add(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}

	static void melt(int y, int x) {
		int count = 0;
		// »ç¹æ Ã¼Å©
		for (int d = 0; d < dir.length; d++) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			if (map[ny][nx] == 0) {
				count++;
			}
		}
		temp[y][x] = map[y][x] - count;
		if (temp[y][x] < 0)
			temp[y][x] = 0;
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
