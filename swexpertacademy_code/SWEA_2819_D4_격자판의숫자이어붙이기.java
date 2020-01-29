import java.util.Scanner;

public class SWEA_2819_D4_격자판의숫자이어붙이기 {
	private static int[] number;
	private static int[][] arr;
	private static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static int ni, nj, N = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			number = new int[10000000];
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 처리 알고리즘
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					recursive("", i, j, 1);
				}
			}
			int sum = 0;
			for (int i = 0; i < number.length; i++) {
				sum += number[i];
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}

	public static void recursive(String str, int i, int j, int len) {
		str += arr[i][j];
		if (len == 7) {
			number[Integer.parseInt(str)] = 1;
			return;
		}
		for (int k = 0; k < 4; k++) {
			ni = i + dir[k][0];
			nj = j + dir[k][1];
			if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
				recursive(str, ni, nj, len + 1);
			}
		}
	}
}
