import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2667_단지번호붙이기 {
	
	static int N;
	static char[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static List<Integer> result;
	static boolean[][] visited;

	public static boolean isIn(int y, int x) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(y,x));
		visited[y][x] = true;
		int count = 1;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int ny = n.y + dir[d][0];
				int nx = n.x + dir[d][1];
				if (isIn(ny, nx) && !visited[ny][nx] && map[ny][nx] == '1') {
					q.add(new Node(ny, nx));
					count++;
					visited[ny][nx] = true;
				}
			}
		}
		result.add(count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			visited[i] = new boolean[N];
		}
		
		result = new ArrayList<Integer>();
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if(!visited[y][x] && map[y][x] == '1') {
					bfs(y, x);
				}
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		for (Integer r : result) {
			System.out.println(r);
		}
	}

	static class Node {
		int x, y;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
