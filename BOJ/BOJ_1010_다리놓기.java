package test;

import java.util.Scanner;

public class BOJ_1010_다리놓기 {
	/*
	 * 
	 * */
	static int [][]cache = new int[31][31];
	
	static int comb(int n, int r) {
		if(n == r || r == 0)
			return 1;
		if(cache[n][r] != 0) {
			return cache[n][r];
		}
		cache[n][r] = comb(n-1,r-1) + comb(n-1,r);
		return cache[n][r];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(comb(M,N));
		}
	}

}
