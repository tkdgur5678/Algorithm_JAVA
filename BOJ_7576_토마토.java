import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {
	public static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		M = sc.nextInt(); // 가로
		N = sc.nextInt(); // 세로
		int[][] box = new int[N][M];
		int tomato = N * M;
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] == -1)
					tomato--;
				if (box[i][j] == 1)
					q.add(new Node(i, j));
			}
		}
		// 처리
		int day = 0;
		int count = 0;
		boolean[][] visited = new boolean[N][M];
		List<Node> l = new ArrayList<>();
		while (!q.isEmpty()) {
			l.clear();
			while (!q.isEmpty()) {
				l.add(q.poll());
			}
			day++;
			for (int idx = 0; idx < l.size(); idx++) {
				Node n = l.get(idx);
				count++;
				visited[n.i][n.j] = true;
				int ni, nj;
				for (int d = 0; d < dir.length; d++) {
					ni = n.i + dir[d][0];
					nj = n.j + dir[d][1];
					if(isIn(ni,nj) && box[ni][nj] == 0) {
						box[ni][nj] = 1;
						q.add(new Node(ni,nj));
					}
				}
			}
		}
		if(count!=tomato)
			day = 0;
		System.out.println(day-1);
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}

	public static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}
