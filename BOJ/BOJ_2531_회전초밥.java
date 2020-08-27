import java.util.Scanner;

public class BOJ_2531_회전초밥 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 초밥 접시 수
		int d = sc.nextInt(); // 초밥 가짓 수
		int k = sc.nextInt(); // 연속해서 먹는 접시 수
		int c = sc.nextInt(); // 쿠폰 번호
		int[] dish = new int[N + k];
		int[] check = new int[d + 1];
		for (int i = 0; i < N; i++) {
			dish[i] = sc.nextInt();
		}
		for (int i = 0; i < k; i++) {
			dish[N + i] = dish[i];
		}
		int start = 0, end = k - 1, max = 0, pCount = 0;
		for (int i = 0; i < k; i++) {
			if (check[dish[i]] == 0)
				pCount++;
			check[dish[i]]++;
		}
		max = pCount;
		while (true) {
			if (max <= pCount) {
				if (check[c] == 0) {
					max = pCount + 1;
				} else {
					max = pCount;
				}
			}
			if (end == N + k - 1) {
				break;
			}

			check[dish[start]]--;
			if (check[dish[start++]] == 0)
				pCount--;
			if (check[dish[++end]] == 0) {
				pCount++;
			}
			check[dish[end]]++;
		}
		System.out.println(max);
	}

}
