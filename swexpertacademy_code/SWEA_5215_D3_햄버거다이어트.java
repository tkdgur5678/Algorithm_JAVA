package algo_basic.day1;

import java.util.Scanner;

public class SWEA_5215_D3_햄버거다이어트 {

	public static int getTaste(int[][] material, int i, boolean check, int cal, int maxCal, int maxTaste) {
		if (check) {
			if (cal+material[i][1] <= maxCal) {
				maxTaste += material[i][0];
				cal += material[i][1];
			}
			else {
				return maxTaste;
			}
		}
		int maxTaste_1 = maxTaste, maxTaste_2 = maxTaste;
		if (i < material.length - 1) {
			maxTaste_1 = Integer.max(maxTaste_1, getTaste(material, i + 1, true, cal, maxCal, maxTaste));
			
			maxTaste_2 = Integer.max(maxTaste_2, getTaste(material, i + 1, false, cal, maxCal, maxTaste));
		}
		return Integer.max(maxTaste_1, maxTaste_2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N, L;
			N = sc.nextInt();
			L = sc.nextInt();
			int[][] material = new int[N][2];
			for (int i = 0; i < material.length; i++) {
				material[i][0] = sc.nextInt();
				material[i][1] = sc.nextInt();
			}
			// 처리 알고리즘
			int maxTaste = 0;
			maxTaste = getTaste(material, 0, true, 0, L, 0);
			maxTaste = Integer.max(maxTaste, getTaste(material, 0, false, 0, L, 0));
			System.out.println("#"+test_case+" "+maxTaste);
		}

	}

}
