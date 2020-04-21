package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_¹ú²ÜÃ¤Ãë {
	static int result, N, M, C;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			result = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0, 0, 0);
			System.out.println("#"+test_case+" "+result);
		}
	}

	public static void dfs(int depth, int i, int j, int value) {
		if (depth == 2) {
			result = Math.max(result, value);
			return;
		}
		for (int r = 0; r < N; r++) {
			if (r < i)
				continue;
			for (int c = 0; c < N; c++) {
				if (r == i && c < j)
					continue;
				if (c + (M - 1) < N) {
					// »ç¿ëÇÒ¼ö ÀÖ´Â ¹úÅë¿¡¼­ ¹ú²ÜÁ¤ÇÏ±â
					
					dfs(depth + 1, r, c + M, value + getValue(r, c));
				}
			}
		}
	}

	public static int getValue(int i, int j) {
		int max = 0;
		for (int k = 0; k < 1 << (M); k++) {
			int sum = 0, value = 0;
			for (int l = 0; l < M; l++) {
				if ((k & (1 << l)) > 0) {
					sum += board[i][j + l];
					value += board[i][j + l] * board[i][j + l];
				}
			}
			if (sum <= C) {
				max = Math.max(max, value);
			}
		}
		return max;
	}
}
