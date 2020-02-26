package test;

import java.util.Scanner;

public class BOJ_1120_¹®ÀÚ¿­ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= str2.length()-str1.length(); i++) {
			int count = 0;
			for (int j = 0; j < str1.length(); j++) {
				if(str1.charAt(j) != str2.charAt(j+i)) {
					count++;
				}
			}
			min = Math.min(min, count);
		}
		System.out.println(min);
	}

}
