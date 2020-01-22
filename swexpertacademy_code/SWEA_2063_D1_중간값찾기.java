package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2063_D1_중간값찾기 {

	public static int[] countingSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		// 최대값 찾기 및 카운팅 배열 만들기
		for (int i = 0; i < arr.length; i++) {
			max = Integer.max(max, arr[i]);
		}
		int[] count = new int[max+1];
		// 각 숫자별 빈도수는?
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		// 각 숫자별로 최대 등장 index - 앞에꺼 계속 더해주기
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		int[] temp = new int[arr.length];
		for (int i = arr.length-1; i >= 0; i--) {
			temp[--count[arr[i]]] = arr[i];
		}
		return temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		arr = countingSort(arr);
		System.out.println(arr[N/2]);
	}

}