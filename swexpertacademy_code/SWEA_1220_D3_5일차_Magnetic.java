import java.util.Scanner;

public class SWEA_1220_D3_5일차_Magnetic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[][] table = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			// 알고리즘 처리
			int count = 0;
			for (int j = 0; j < N; j++) {
				int M = 0;
				boolean drop = true;
				for (int i = 0; i < N; i++) {
					// 처음으로 N극이 나오면 처리(떨어지는 자석)
					if (drop && table[i][j] == 1)
						drop = false;
					if (!drop) {
						if (table[i][j] != 0) { // 다른 자석이 나왔다면
							if (M == 0 && table[i][j] == 1) { // 처음이나 교착상태 후 N극 자석이 나오면
								M = 1;
							} else if (M == 1 && table[i][j] == 2) { // N극 다음 S극 자석이 나오면
								count++;
								M = 0;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}

}
