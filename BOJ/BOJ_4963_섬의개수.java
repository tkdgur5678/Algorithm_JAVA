import java.util.Scanner;

public class BOJ_4963_섬의개수 {

	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, 1 },
			{ 1, -1 } };
	public static int w, h, result;
	public static boolean[][] visited;
	public static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			result = 0;
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						visited[i][j] = true;
						dfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	public static void dfs(int i, int j) {
		int ni, nj;
		for (int d = 0; d < dir.length; d++) {
			ni = i + dir[d][0];
			nj = j + dir[d][1];
			if (isIn(ni, nj) && !visited[ni][nj] && map[ni][nj] == 1) {
				visited[ni][nj] = true;
				dfs(ni, nj);
			}
		}
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < h && j < w;
	}
}
