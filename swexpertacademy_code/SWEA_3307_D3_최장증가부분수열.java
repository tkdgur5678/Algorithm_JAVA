package algo_basic.day1;

import java.util.Scanner;

public class SWEA_3307_D3_최장증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int []arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int []count = new int[N];
			for(int i=0; i<N; ++i) {
				count[i] = 1;
			}
			for (int i = 0; i < N; i++) {
				//현재 값보다 앞에있는 배열 탐색
			    for (int j = 0; j < i; j++) {
			    	//자기보다 작은수
			        if (arr[i] > arr[j]) {
			        	//자기 카운트랑 같거나 크다면
			            if (count[i] <= count[j]) {
			            	count[i] = count[j] + 1;
			            }
			        }
			    }
			}
			int max = 0;
			for(int i=0; i<count.length; ++i) {
				max = Integer.max(max, count[i]);
			}
			System.out.println("#"+test_case+" "+max);
		}
	}

}
