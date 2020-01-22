package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2058_D1_자릿수더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			sum += ((int)input.charAt(i) - '0');
		}
		System.out.println(sum);
	}

}
