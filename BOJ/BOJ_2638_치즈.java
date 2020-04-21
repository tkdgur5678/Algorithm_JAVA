package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 	가장자리에는 치즈가 놓이지 않는다고 가정 했기에 0,0에서 bfs로 탐색하면서 공기라면 q에 추가 치즈라면 새로운 맵에 카운트 해주면서
 *	탐색이 끝난 후 카운트가 2보다 큰 치즈들을 없애주는것을 반복
 * */

public class BOJ_2638_치즈 {
	
	static int N, M, result = 0;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static boolean isIn(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static boolean bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int[][] air = new int[N][M];
		q.add(new Node(0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int ni = n.i + dir[d][0];
				int nj = n.j + dir[d][1];
				if(isIn(ni,nj)) {
					if(!visited[ni][nj] && map[ni][nj] == 0) {
						q.add(new Node(ni,nj));
						visited[ni][nj] = true;
					} else if(map[ni][nj] == 1) {
						air[ni][nj]++;
					}
				}
			}
		}
		boolean check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(air[i][j] >= 2) {
					check = true;
					map[i][j] = 0;
				}
			}
		}
		return check;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			if(bfs()) {
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);
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
