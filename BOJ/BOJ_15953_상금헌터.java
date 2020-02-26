package test;

import java.util.Scanner;

public class BOJ_15953_ªÛ±›«Â≈Õ {
	static int[] c2017 = { 1, 3, 6, 10, 15, 21 };
	static int[] m2017 = { 500, 300, 200, 50, 30, 10 };
	static int[] c2018 = { 1, 3, 7, 15, 31 };
	static int[] m2018 = { 512, 256, 128, 64, 32 };

	public static int getReward(int score, int[] gradeArr, int[] moneyArr) {
		if (score != 0) {
			for (int i = 0; i < gradeArr.length; i++) {
				if (score <= gradeArr[i]) {
					return moneyArr[i]* 10000;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int s2017 = sc.nextInt();
			int s2018 = sc.nextInt();
			int money = 0;
			money += getReward(s2017, c2017, m2017);
			money += getReward(s2018, c2018, m2018);
			System.out.println(money);
		}
	}

}
