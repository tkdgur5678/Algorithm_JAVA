
/**
 * @brief 시뮬레이션
 * @detail 사과 행과 열이 착각하여 푸는데 더 오래 걸림
 * @date 2020.07.15
 * @author tkdgur5678
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3190_뱀 {

	static int N, K, L;
	static int[][] board, dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[] moveT;
	static char[] moveD;

	static boolean isOut(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 보드 크기
		K = sc.nextInt(); // 사과 개수
		// 맨위 맨 좌축(1,1)로 주어져서 받을때 1을 빼줌
		board = new int[N][N];
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			board[r][c] = 1;
		}

		// 방향 전환 정보
		L = sc.nextInt();
		Queue<MoveInfo> info = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			info.add(new MoveInfo(sc.nextInt(), sc.next().charAt(0)));
		}
		// 머리방향 0 우 1 하 2 좌 3 상
		int snakeY = 0, snakeX = 0, d = 0, time = 0;
		Queue<Node> snake = new LinkedList<>();
		snake.add(new Node(0, 0));
		while (true) {
			time++;
			// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
			int ny = snakeY + dirs[d][0];
			int nx = snakeX + dirs[d][1];
			// 벽 또는 자기자신의 몸과 부딪히면
			boolean flag = false;
			for (Node node : snake) {
				if (ny == node.y && nx == node.x) {
					flag = true;
					break;
				}
			}
			if (isOut(ny, nx) || flag) {
				break;
			}
			// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
			if (board[ny][nx] == 1) {
				board[ny][nx] = 0;
			}
			// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
			else {
				snake.poll();
			}
			snake.add(new Node(ny, nx));
			snakeY = ny;
			snakeX = nx;

			// 끝난 후 방향 전환 L 왼쪽 D 오른쪽
			if (!info.isEmpty()) {
				MoveInfo mi = info.peek();
				if (mi.t == time) {
					mi = info.poll();
					if (mi.d == 'L') {
						d = (d + 3) % 4;
					} else {
						d = (d + 1) % 4;
					}
				}
			}
		}
		System.out.println(time);
	}

	static class MoveInfo {
		int t;
		char d;

		public MoveInfo(int t, char d) {
			this.t = t;
			this.d = d;
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
