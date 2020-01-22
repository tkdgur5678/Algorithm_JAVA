package algo_basic.day1;

import java.util.Scanner;

public class SWEA_1289_D3_원재의메모리복구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String initBit = sc.next();
			char[] arr = new char[initBit.length()];
			char[] temp = new char[initBit.length()];
			arr = initBit.toCharArray();
			int count = 0;
			for (int i = 0; i < initBit.length(); i++) {
				temp[i] = '0';
			}
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] != temp[i]) {
					for(int j = i; j<temp.length; j++) {
						temp[j] = arr[i];
					}
					count++;
				}
			}
			System.out.printf("#%d %d",test_case,count);
		}

	}

}
