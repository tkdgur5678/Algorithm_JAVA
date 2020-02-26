package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1937_øÂΩ…¿Ô¿Ã∆«¥Ÿ {
	static int N, result = 0;
	static int[][] map;
	static int[][] value;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		value = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = Math.max(result,dfs(i, j));
			}
		}
		System.out.println(result);
	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int dfs(int i, int j) {
		if (value[i][j] > 0) {
			return value[i][j];
		}
		value[i][j] = 1;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			if (isIn(ni, nj) && map[i][j] < map[ni][nj]) {
				value[i][j] = Math.max(value[i][j],dfs(ni, nj)+1);
			}
		}
		
		return value[i][j];
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N;
	}

}
