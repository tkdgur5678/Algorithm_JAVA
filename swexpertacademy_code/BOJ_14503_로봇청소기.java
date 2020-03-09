package test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14503_로봇청소기 {

	static int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static int[][] backDir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt(); // 0 북 1 동 2 남 3 서
		int result = 1;
		int[][] map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		map[r][c] = 2;
		int count = 0;
		while (true) {
			/*
			 * 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다. 왼쪽 방향에 청소할
			 * 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로
			 * 한 칸 후진을 하고 2번으로 돌아간다. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는
			 * 작동을 멈춘다.
			 */
			int ni = r + dir[d][0];
			int nj = c + dir[d][1];
			if(isIn(ni,nj) && map[ni][nj] == 0) {
				map[ni][nj] = 2;
				result++;
				r = ni;
				c = nj;
				d = (d+3)%4;
				count = 0;
			} else if(count >= 4) {
				count = 0;
				ni = r + backDir[d][0];
				nj = c + backDir[d][1];
				if(isIn(ni,nj) && map[ni][nj] != 1) {
					r = ni;
					c = nj;
				} else {
					break;
				}
			}
			else {
				d = (d+3)%4;
				count++;
			}
		}
		System.out.println(result);
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}

}
