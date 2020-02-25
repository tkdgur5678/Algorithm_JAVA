package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2589_º¸¹°¼¶ {
	static int H, W;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			map[i] = sc.next().toCharArray();
		}
		int result = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') { // À°ÁöÀÏ¶§¸¸ bfs
					result = Integer.max(result, bfs(i, j));
				}
			}
		}
		System.out.println(result);
	}

	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < H && j < W;
	}

	public static int bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j));
		int[][] value = new int[H][W];
		for (int k = 0; k < value.length; k++) {
			Arrays.fill(value[k], Integer.MAX_VALUE);
		}
		value[i][j] = 0;
		int max = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int ni = n.i + dir[d][0];
				int nj = n.j + dir[d][1];
				if (isIn(ni, nj) && map[ni][nj] == 'L' && value[n.i][n.j] + 1 < value[ni][nj]) {
					value[ni][nj] = value[n.i][n.j] + 1;
					q.add(new Node(ni, nj));
					if (max < value[ni][nj]) {
						max = value[ni][nj];
					}
				}
			}
		}
		return max;
	}

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
