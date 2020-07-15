
/**
 * @brief �ùķ��̼�
 * @detail ��� ��� ���� �����Ͽ� Ǫ�µ� �� ���� �ɸ�
 * @date 2020.07.15
 * @author tkdgur5678
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3190_�� {

	static int N, K, L;
	static int[][] board, dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[] moveT;
	static char[] moveD;

	static boolean isOut(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ���� ũ��
		K = sc.nextInt(); // ��� ����
		// ���� �� ����(1,1)�� �־����� ������ 1�� ����
		board = new int[N][N];
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			board[r][c] = 1;
		}

		// ���� ��ȯ ����
		L = sc.nextInt();
		Queue<MoveInfo> info = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			info.add(new MoveInfo(sc.nextInt(), sc.next().charAt(0)));
		}
		// �Ӹ����� 0 �� 1 �� 2 �� 3 ��
		int snakeY = 0, snakeX = 0, d = 0, time = 0;
		Queue<Node> snake = new LinkedList<>();
		snake.add(new Node(0, 0));
		while (true) {
			time++;
			// ���� ���� �����̸� �÷� �Ӹ��� ����ĭ�� ��ġ��Ų��.
			int ny = snakeY + dirs[d][0];
			int nx = snakeX + dirs[d][1];
			// �� �Ǵ� �ڱ��ڽ��� ���� �ε�����
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
			// ���� �̵��� ĭ�� ����� �ִٸ�, �� ĭ�� �ִ� ����� �������� ������ �������� �ʴ´�.
			if (board[ny][nx] == 1) {
				board[ny][nx] = 0;
			}
			// ���� �̵��� ĭ�� ����� ���ٸ�, �����̸� �ٿ��� ������ ��ġ�� ĭ�� ����ش�. ��, �����̴� ������ �ʴ´�.
			else {
				snake.poll();
			}
			snake.add(new Node(ny, nx));
			snakeY = ny;
			snakeX = nx;

			// ���� �� ���� ��ȯ L ���� D ������
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
