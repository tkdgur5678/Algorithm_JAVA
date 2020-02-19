package algo_basic.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static int[][] power;
	static int N, result;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		power = new int[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (i < j) {
					power[i][j] += Integer.parseInt(st.nextToken());
				} else {
					power[j][i] += Integer.parseInt(st.nextToken());
				}
			}
		}
		result = Integer.MAX_VALUE;
		combination(0, 0, new int[N / 2]);
		for (int i = 0; i < list.size()/2; i++) {
			result = Math.min(Math.abs(checkPower(0, list.get(i), 0, new int[2])-checkPower(0,list.get(list.size()-1-i),0, new int[2])),result);
		}
		System.out.println(result);
	}

	public static int checkPower(int depth, int[] comb, int start, int[] arr) {
		if (depth == 2) {
			// 처리
			return power[arr[0]][arr[1]];
		}
		int sum = 0;
		for (int i = start; i < comb.length; i++) {
			arr[depth] = comb[i];
			sum += checkPower(depth + 1, comb, i + 1, arr);
		}
		return sum;
	}

	public static void combination(int depth, int start, int[] arr) {
		if (depth == N / 2) {
			// 처리
			//System.out.println("list: " +Arrays.toString(arr));
			list.add(arr.clone());
			return;
		}
		for (int i = start; i < N; i++) {
			arr[depth] = i;
			combination(depth + 1, i + 1, arr);
		}
	}
}
