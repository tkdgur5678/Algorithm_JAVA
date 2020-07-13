import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3055_탈출 {

	static int R, C;
	static char[][] map;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static boolean isIn(int y, int x) {
		return y >= 0 && y < R && x >= 0 && x < C;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = sc.next().toCharArray();
		}
		Node hog = new Node(0, 0);
		Node cave = new Node(0, 0);
		List<Node> waters = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'D') {
					cave = new Node(r, c);
				} else if (map[r][c] == 'S') {
					hog = new Node(r, c);
				} else if (map[r][c] == '*') {
					waters.add(new Node(r, c));
				}
			}
		}

		// bfs
		Queue<Node> q = new LinkedList<>();
		q.add(hog);
		int count = 0;
		boolean end = false;
		bfs: while (!q.isEmpty()) {
			count++;
			// 물은 상하좌우로 점점 퍼짐
			List<Node> temp = new LinkedList<>();
			for (Node water : waters) {
				for (int d = 0; d < dirs.length; d++) {
					int ny = water.y + dirs[d][0];
					int nx = water.x + dirs[d][1];
					if (isIn(ny, nx) && map[ny][nx] == '.') {
						map[ny][nx] = '*';
						temp.add(new Node(ny, nx));
					}
				}
			}
			waters = temp;

			// 고슴도치가 움직임
			Queue<Node> tempHog = new LinkedList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.poll();
				for (int d = 0; d < dirs.length; d++) {
					int ny = n.y + dirs[d][0];
					int nx = n.x + dirs[d][1];
					if (isIn(ny, nx)) {
						if (map[ny][nx] == '.') {
							map[ny][nx] = 'S';
							tempHog.add(new Node(ny, nx));
						} else if (map[ny][nx] == 'D') {
							end = true;
							break bfs;
						}
					}
				}
			}
			q = tempHog;
		}
		if (end) {
			System.out.println(count);
		} else {
			System.out.println("KAKTUS");
		}
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
