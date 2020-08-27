import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {

	static int result = Integer.MAX_VALUE;
	static int[] num = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			Integer retNum = binarySearch(arr[i] * -1, arr, i);
			if(retNum == null) {
				continue;
			}
			// 기존 결과와 비교
			int temp = Math.abs(arr[i] + retNum);
			if(temp < result) {
				result = temp;
				if(arr[i] < retNum) {
					num[0] = arr[i];
					num[1] = retNum;
				} else {
					num[1] = arr[i];
					num[0] = retNum;
				}
			}
			if(result == 0) {
				break;
			}
		}
		System.out.println(num[0] + " " + num[1]);
	}

	public static Integer binarySearch(int iKey, int arr[], int index) {
		int mid;
		int left = 0;
		int right = arr.length - 1;

		while (right >= left) {
			mid = (right + left) / 2;

			if (iKey == arr[mid] && mid != index) {
				return iKey;
			}
			if (iKey < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		Integer right_val = null;
		Integer left_val = null;
		if(right>=0 && right != index) {
			right_val = arr[right];
		}
		if(left<arr.length && left != index) {
			left_val = arr[left];
		}
		// 좌 우 둘다 값이 있다면 비교
		if(right_val != null && left_val != null) {
			int tempR = Math.abs(iKey - right_val);
			int tempL = Math.abs(iKey - left_val);
			return tempR < tempL ? right_val : left_val;
		}
		// 둘다 값이 없다면 null return
		else if(right_val == null && left_val == null) {
			return null;
		}
		else if(right_val == null && left_val != null) {
			return left_val;
		}
		else {
			return right_val;
		}
	}

}
