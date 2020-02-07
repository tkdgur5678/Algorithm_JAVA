import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9232_D5_한길이의생일선물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] space = new int[N];
			int[] disk = new int[M];
			int max = Integer.MAX_VALUE;
			int len = 0;
			for (int j = 0; j < N; j++) {
				space[j] = sc.nextInt();
				if(max < space[j]) {
					space[j] = max;
				}
				max = space[j];
			}
			
			for (int j = 0; j < M; j++) {
				disk[j] = sc.nextInt();
			}
			System.out.println(Arrays.toString(space));
			System.out.println(upperBound(space,0,N-1,60));
			//System.out.println("#"+test_case+" "+(top+1));
		}
	}
	
	public static int upperBound(int arr[], int front, int rear, int key) {
		int mid;
		while(front<rear) {
			mid = (front + rear)/2;
			if(arr[mid]>key) front = mid + 1;
			else rear = mid;
		}
		return rear;
	}

}
