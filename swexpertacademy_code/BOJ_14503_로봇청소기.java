package test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14503_�κ�û�ұ� {

	static int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static int[][] backDir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt(); // 0 �� 1 �� 2 �� 3 ��
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
			 * ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�. ���� ���⿡ û����
			 * ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä��
			 * �� ĭ ������ �ϰ� 2������ ���ư���. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡��
			 * �۵��� �����.
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
