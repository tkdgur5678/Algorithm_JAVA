package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2068_D1_최대수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            int max = -1, input;
            for(int idx = 0; idx<10; ++idx)
            {
                input = sc.nextInt();
                max = max > input ? max : input;
            }
            System.out.println("#"+test_case+" "+max);
		}
	}

}
