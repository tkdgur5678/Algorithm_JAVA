package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569_≈‰∏∂≈‰ {
	static int C, R, H, maxTomato = 0, nowTomato = 0, result = 0;
	static int[][][] box;
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		H = sc.nextInt();
		maxTomato = C * R * H;
		box = new int[H][R][C];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					box[i][j][k] = sc.nextInt();
					if (box[i][j][k] == -1)
						maxTomato--;
					else if (box[i][j][k] == 1) {
						q.add(new Node(i, j, k));
						nowTomato++;
					}
				}
			}
		}
		bfs();
		if (nowTomato != maxTomato) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	static int[][] dir = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 1, 0, 0 }, { -1, 0, 0 } };

	public static boolean isIn(int h, int r, int c) {
		return h >= 0 && r >= 0 && c >= 0 && h < H && r < R && c < C;
	}

	public static void bfs() {
		q.add(new Node(-1, -1, -1));
		while (q.size()>1) {
			Node n = q.poll();
			if (n.h == -1) {
				result++;
				q.add(n);
				continue;
			}
			for (int d = 0; d < dir.length; d++) {
				int nh = n.h + dir[d][0];
				int nr = n.r + dir[d][1];
				int nc = n.c + dir[d][2];
				if (isIn(nh, nr, nc) && box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = 1;
					nowTomato++;
					q.add(new Node(nh, nr, nc));
				}
			}
		}
	}

	static class Node {
		int h;
		int r;
		int c;

		public Node(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
}
