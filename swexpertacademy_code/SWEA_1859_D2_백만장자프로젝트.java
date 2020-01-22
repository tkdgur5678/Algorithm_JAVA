package algo_basic.day1;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1859_D2_백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, N;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int []arr = new int[N];
			//데이터 삽입
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int count = 0;
			long profit = 0;
			int topValue = 0;
			for (int i = N-1; i>=0; --i) {
				if(topValue>arr[i]) {//구매
					count++;
					profit -= arr[i];
				}
				else {	//판매
					profit += topValue*count;
					count = 0;
					topValue = arr[i];
				}
			}
			profit += topValue*count;
			System.out.println(profit);
		}
	}

}
