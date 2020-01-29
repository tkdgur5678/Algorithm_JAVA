import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_D3_진기의최고급붕어빵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, N, M, K, input;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			//입력
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			int[] people = new int[11112];
			for (int i = 0; i < N; i++) {
				input = sc.nextInt();
				people[input]++;
			}
			//처리 알고리즘
			int t = 0, bread = 0;
			while(true) {
				if(t>0 && t%M==0) {		//빵만들기
					bread+=K;
				}
				if(people[t]>0) {	//지금시간에 사람이 있으면
					bread-=people[t];
				}
				if(bread<0) {	//빵이 부족한데 사람이 왔으면
					System.out.println("#"+test_case+" Impossible");
					break;
				}
				t++;
				if(t>=11111) {
					System.out.println("#"+test_case+" Possible");
					break;
				}
			}
		}

	}

}
