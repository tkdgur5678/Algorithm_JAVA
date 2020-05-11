package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
	public static int[][] map;
	public static boolean possible, impossible;
	public static int[][] game = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 },
			{ 1, 5 }, { 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };

	static void dfs(int depth) {
		if (possible || depth == 15) {
			possible = true;
			return;
		}
		int x = game[depth][0];
		int y = game[depth][1];
		for (int i = 0; i < 3; i++) {
			int j = 3 - i - 1;
			if (map[x][i] > 0 && map[y][j] > 0) {
				--map[x][i];
				--map[y][j];
				dfs(depth + 1);
				++map[y][j];
				++map[x][i];
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		map = new int[6][3];
		for (int test_case = 0; test_case < 4; test_case++) {
			int win = 0, lose = 0;
			impossible = false;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				int temp = 0;
				for (int j = 0; j < 3; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					temp += map[i][j];
					if (j == 0)
						win += map[i][j];
					if (j == 2)
						lose += map[i][j];
				}
				if (temp != 5) {
					impossible = true;
					break;
				}
			}
			possible = false;
			if(win == lose && !impossible) {
				dfs(0);
			}
			
			sb.append(possible ? 1 : 0).append(" ");
		}
		System.out.println(sb);
	}

}
