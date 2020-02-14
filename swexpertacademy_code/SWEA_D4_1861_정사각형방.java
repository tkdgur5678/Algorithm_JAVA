import java.util.Scanner;

public class SWEA_D4_1861_정사각형방 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, board;
	static int T, N, result, si, sj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			// 처리
			result = 0;
			si = sj = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, i, j, 0);
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + board[si][sj] + " " + (result + 1));
		}
	}

	public static void dfs(int sy, int sx, int y, int x, int count) {
		int ni, nj;
		for (int d = 0; d < dir.length; d++) {
			ni = y + dir[d][0];
			nj = x + dir[d][1];
			if (isIn(ni, nj) && board[y][x] + 1 == board[ni][nj]) {
				dfs(sy, sx, ni, nj, count + 1);
			}
		}
		if (count > result) {
			result = count;
			si = sy;
			sj = sx;
		} else if (count == result && board[si][sj] > board[sy][sx]) {
			si = sy;
			sj = sx;
		}
		result = Integer.max(result, count);
	}

	public static boolean isIn(int y, int x) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}
