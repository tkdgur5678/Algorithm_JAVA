import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		// 2차원 배열 선언
		int[][] ladder = new int[100][100];
		for (int test_case = 1; test_case <= 10; test_case++) {
            		T = sc.nextInt();
			// 사다리 입력
			for (int i = 0; i < 100; ++i) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}

			// 처리 알고리즘
			for (int t = 0; t < 100; ++t) {
				// 시작 지점
				if (ladder[0][t] == 1) {
					int i = 1;
					int j = t;
					// 진행 방향 아래:0 좌:1 우:2
					int dir = 0;
					// 탐색 시작
					while (i < 99) {
						// 방향이 아래 일 경우
						if (dir == 0) {
							// 좌 경로 확인
							if (j > 0 && ladder[i][j-1] == 1) {
								dir = 1;
								j--;
							}
							// 우 경로 확인
							else if (j < 99 && ladder[i][j+1] == 1) {
								dir = 2;
								j++;
							}
							// 아래로 이동
							else {
								i++;
							}
						}
						// 방향이 좌 일 경우
						else if (dir == 1) {
							// 아래 경로 확인
							if (ladder[i+1][j] == 1) {
								dir = 0;
								i++;
							}
							// 좌로 이동
							else {
								j--;
							}
							
						}
						// 방향이 우 일 경우
						else {
							// 아래 경로 확인
							if (ladder[i+1][j] == 1) {
								dir = 0;
								i++;
							}
							// 우로 이동
							else {
								j++;
							}
						}
					}
					// 마지막 숫자 확인
					if (ladder[i][j] == 2) {
						System.out.println("#"+T+" "+t);
						break;
					}
				}
			}
		}
	}
}