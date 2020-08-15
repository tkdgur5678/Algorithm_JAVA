import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int count = 0;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 알고리즘
		dfs(0, 1, 0);
		// 출력
		System.out.println(count);
	}

	static int ni, nj;

	public static void dfs(int i, int j, int d) { // 0:가로 1:세로 2:대각
		if (i == N - 1 && j == N - 1) {
			count++;
			return;
		}
		for (int k = 0; k < 3; k++) {
			if ((k == 0 && d == 1) || (k == 1 && d == 0)) { // 가로일때 세로일경우와 세로일때 가로인 경우
				continue;
			}
			ni = i + dir[k][0];
			nj = j + dir[k][1];
			if (ni >= N || nj >= N || map[ni][nj] == 1) { // 나가거나 벽일때
				continue;
			}
			if (k == 2 && (map[i + 1][j] == 1 || map[i][j + 1] == 1)) { // 대각일때 나머지 부분 확인
				continue;
			}
			dfs(ni, nj, k);
		}
	}
}
