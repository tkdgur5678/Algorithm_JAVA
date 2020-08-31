import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_¡¡¥Ÿ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int result = 0;

		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = arr.length - 1;

			while (left < right) {
				if (left == i) {
					++left;
					continue;
				}
				if (right == i) {
					--right;
					continue;
				}
				int sum = arr[left] + arr[right];
				if (sum == arr[i]) {
					result++;
					break;
				} else if(sum > arr[i]) {
					--right;
				} else {
					++left;
				}
			}
		}
		System.out.println(result);
	}

}
