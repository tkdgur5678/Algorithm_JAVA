package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16948_데스나이트 {

	static boolean[][] board;
	static int[][] dir = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };
	static int r1, r2, c1, c2, N, result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new boolean[N][N];
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		bfs();
		System.out.println(result);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r1, c1));
		q.add(new Node(-1, -1));

		while (q.size() > 1) {
			Node n = q.poll();
			if(n.r == r2 && n.c == c2)
				return;
			if (n.r == -1) {
				q.add(n);
				result++;
				continue;
			}
			for (int d = 0; d < dir.length; d++) {
				int nr = n.r + dir[d][0];
				int nc = n.c + dir[d][1];
				if (isIn(nr, nc) && !board[nr][nc]) {
					board[nr][nc] = true;
					q.add(new Node(nr, nc));
				}
			}
		}
		result = -1;
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
	}
}
