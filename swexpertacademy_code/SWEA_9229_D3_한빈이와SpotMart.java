package algo_basic.day7;

import java.util.Scanner;

public class SWEA_9229_D3_한빈이와SpotMart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int []snack = new int[N];
			for (int i = 0; i < snack.length; i++) {
				snack[i] = sc.nextInt();
			}
			//알고리즘
			int max = -1;
			for (int i = 0; i < snack.length; i++) {
				for (int j = i+1; j < snack.length; j++) {
					if(snack[i]+snack[j]<=M)
						max = Integer.max(snack[i]+snack[j],max);
				}
			}
			//출력
			System.out.println("#"+test_case+" "+max);
		}
	}

}
