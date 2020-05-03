package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2933_미네랄 {

	public static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static int R, C;
	public static char[][] tmpMap, Map;

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	public static char[][] deepCopy(char[][] original) {
		char[][] ret = new char[original.length][original[0].length];
		for (int i = 0; i < ret.length; i++) {
			System.arraycopy(original[i], 0, ret[i], 0, original[0].length);
		}
		return ret;
	}

	public static int checkCluster() {
		// 클러스터가 있는지 확인
		int ret = 0;
		tmpMap = deepCopy(Map);
		boolean[][] visited = new boolean[R][C];
		for (int c = 0; c < C; c++) {
			// 맨 밑에꺼만 확인하면 됨
			if (Map[R - 1][c] == 'x' && !visited[R - 1][c]) { // 안떨어지는 cluster
				ret++;
				Queue<int[]> q = new LinkedList<>();
				int[] start = { R - 1, c };
				q.add(start);
				visited[R - 1][c] = true;
				tmpMap[R - 1][c] = 'C'; // 바닥에 붙은 클러스터 표시
				while (!q.isEmpty()) {
					int[] node = q.poll();
					for (int d = 0; d < dir.length; d++) {
						int nr = node[0] + dir[d][0];
						int nc = node[1] + dir[d][1];
						if (isIn(nr, nc) && Map[nr][nc] == 'x' && !visited[nr][nc]) {
							visited[nr][nc] = true;
							tmpMap[nr][nc] = 'C';
							int[] temp = { nr, nc };
							q.add(temp);
							ret++;
						}
					}
				}
			}
		}
		return ret;
	}

	public static void gravity() {
		int min = Integer.MAX_VALUE;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (tmpMap[r][c] == 'x') {
					int h = 0;
					for (int nr = r + 1; nr < R; nr++) { // 바로 밑부터 땅까지
						if (tmpMap[nr][c] == 'C') { // 다른 클러스터
							break;
						} else if (tmpMap[nr][c] == 'x') {
							h = min;
							break;
						} else {
							h++;
						}
					}
					min = Math.min(min, h);
				}
			}
		}
		// 이제 최소 높이만큼만 이동
		for (int r = R - 2; r >= 0; r--) {
			for (int c = 0; c < C; c++) {
				if (tmpMap[r][c] == 'x') {
					Map[r][c] = '.';
					Map[r + min][c] = 'x';
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		R = sc.nextInt();
		C = sc.nextInt();
		Map = new char[R][C];
		for (int r = 0; r < R; r++) {
			Map[r] = sc.next().toCharArray();
			for (int c = 0; c < C; c++) {
				if (Map[r][c] == 'x') {
					count++;
				}
			}
		}
		int N = sc.nextInt();

		boolean turn = true;
		for (int i = 0; i < N; i++) {
			int h = sc.nextInt();
			if (turn) {// true 왼쪽
				for (int c = 0; c < C; c++) {
					if (Map[R - h][c] == 'x') {
						Map[R - h][c] = '.';
						count--;
						break;
					}
				}
			} else {
				for (int c = C - 1; c >= 0; c--) {
					if (Map[R - h][c] == 'x') {
						Map[R - h][c] = '.';
						count--;
						break;
					}
				}
			}
			//막대기를 던져서 미네랄이 부셔졌다면
			if (count != checkCluster()) {
				gravity();
			}
			turn = !turn;
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(Map[r][c]);
			}
			System.out.println();
		}
	}

}
