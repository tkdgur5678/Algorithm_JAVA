import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512_¿¹»ê {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		Arrays.sort(arr);
		int budget = Integer.parseInt(br.readLine());
		if (sum <= budget) {
			System.out.println(arr[N - 1]);
		} else {
			System.out.println(findMaxBudget(arr, budget));
		}
	}

	static int findMaxBudget(int arr[], int budget) {
		int mid;
		int left = 0;
		int right = arr[arr.length - 1];

		while (right > left) {
			mid = (right + left) / 2;

			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) {
					sum += mid;
				} else {
					sum += arr[i];
				}
			}
			if (budget < sum) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return left;
	}
}
