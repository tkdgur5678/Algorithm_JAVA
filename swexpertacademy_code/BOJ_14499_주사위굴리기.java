package test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14499_¡÷ªÁ¿ß±º∏Æ±‚ {

	static int[] dice = { 2, 4, 1, 3, 5, 6 };
	static int[] diceNum = { 0, 0, 0, 0, 0, 0, 0 };
	static int[][] dir = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static int N, M;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N][M];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int o = 0; o < K; o++) {
			int d = sc.nextInt();
			int ni = x + dir[d][0];
			int nj = y + dir[d][1];
			if(isIn(ni,nj)) {
				if(map[x][y] == 0) {
					map[x][y] = diceNum[dice[5]];
				} else {
					diceNum[dice[5]] = map[x][y];
					map[x][y] = 0;
				}
				x = ni;
				y = nj;
				rotateDice(d);
				System.out.println(diceNum[dice[2]]);
			}
		}

	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}

	public static void rotateDice(int dir) {
		if (dir == 1) { // µø
			int temp = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp;
		} else if (dir == 2) {// º≠
			int temp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
		} else if (dir == 3) {// ∫œ
			int temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[4];
			dice[4] = dice[5];
			dice[5] = temp;
		} else { // ≥≤
			int temp = dice[0];
			dice[0] = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[2];
			dice[2] = temp;
		}
	}
}
