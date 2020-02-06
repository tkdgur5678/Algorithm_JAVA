package algo_basic.day6;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6109_D4_추억의2048게임 {

	private static int[][] board;
	private static int[][] result;
	private static int size, num;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String str = sc.next();
			board = new int[N][N];
			result = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int [][]dir = {{0,N-1,1,0,N-1,1},{0,N-1,1,N-1,0,-1}};
			int d = 1;
			for (int i = dir[d][0]; i <= dir[d][1]; i+=dir[d][2]) {
				num = 0;
				size = 0;
				for (int j = dir[d][3]; j <= dir[d][4]; j+=dir[d][5]) {
					if(d == 0)
						move(j,i);
				}
				result[size++][i] = num;
			}
			for (int[] is : result) {
				System.out.println(Arrays.toString(is));
			}
		}
	}
	public static void move(int i, int j) {
		if (num == 0 && board[i][j] != 0) { // 값이 없으면서 0이 아닌 값이 왔을때
			num = board[i][j];
		} else if (num != 0) {
			if (board[i][j] == num) {// 값이 있으면서 현재값이랑 같다면 합쳐줌
				result[size++][j] = board[i][j] + num;
				num = 0;
			} else if (board[i][j] != 0) { // 다르면서 현재값이 0이아니면 값을바꿔줌
				result[size++][j] = num;
				num = board[i][j];
			}
		}
	}

}
