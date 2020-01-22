package algo_basic.day1;

import java.util.Scanner;

public class SWEA_1204_D2_최빈수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] arr = new int[1000];
			int[] count = new int[101];
			int num = sc.nextInt();
			int max = 0;
			int result = 0;
			//입력 값 삽입
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				count[arr[i]]++;
			}
			//카운트 개수가 많은 값의 index저장
			for (int i = 0; i < count.length; i++) {
				if(max<=count[i]) {
					max = count[i];
					result = i;
				}
			}
			System.out.printf("#%d %d\n",num,result);
		}
	}

}
