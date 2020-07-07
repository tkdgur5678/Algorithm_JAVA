import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11559_PuyoPuyo {

	static int R, C, result;
	static char[][] map;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visited;

	static boolean isIn(int y, int x) {
		return y >= 0 && y < R && x >= 0 && x < C;
	}

	static boolean bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(y, x));
		visited[y][x] = true;
		List<Node> list = new ArrayList<>();
		list.add(new Node(y, x));
		int count = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			count++;
			// 4방 탐색
			for (int d = 0; d < dirs.length; d++) {
				int ny = n.y + dirs[d][0];
				int nx = n.x + dirs[d][1];
				if (isIn(ny, nx) && map[n.y][n.x] == map[ny][nx] && !visited[ny][nx]) {
					q.add(new Node(ny, nx));
					visited[ny][nx] = true;
					list.add(new Node(ny, nx));
				}
			}
		}
		// 4개 이상
		if (count >= 4) {
			for (Node node : list) {
				map[node.y][node.x] = '.';
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = 12;
		C = 6;
		result = 0;
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}
		boolean check;
		while (true) {
			check = false;
			visited = new boolean[R][C];
			// 전체 탐색하면서 방문안된 구간에서 bfs로 터뜨릴 구간 찾기
			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					if (map[y][x] != '.') {
						if (bfs(y, x)) {
							check = true;
						}
					}
				}
			}
			// 하나도 안터졋다면 break;
			if(!check) {
				break;
			}
			// 중력 작용
			for (int x = 0; x < C; x++) {
				for (int py = R-1; py >= 0; py--) {
					if(map[py][x] == '.') {
						for (int ny = py - 1; ny >= 0; ny--) {
							if(map[ny][x] != '.') {
								map[py][x] = map[ny][x];
								map[ny][x] = '.';
								break;
							}
						}
						
					}
				}
			}
			
			result++;
		}
		
		System.out.println(result);
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
