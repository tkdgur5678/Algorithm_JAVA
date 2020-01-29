import java.util.Scanner;

public class SWEA_5603_D3_건초더미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int []arr = new int[N];
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			int hay = sum/N;
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]<hay)
					sum += (hay-arr[i]);
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}

}
