package algo_basic.day8;

import java.util.Scanner;

public class SWEA_8840_D3_아바바바 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		for (int test_case = 1; test_case <= Tc; test_case++) {
			long N = sc.nextInt()/2;
			System.out.println("#"+test_case+" "+N*N);
		}
	}

}
