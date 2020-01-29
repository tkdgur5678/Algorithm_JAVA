import java.util.Scanner;

public class SWEA_1217_D3_4일차_거듭제곱 {

	public static int Power(int N, int M) {
		if(M==1) 
			return N;
		return N*Power(N,M-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T, N, M;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			int result = Power(N,M);
			System.out.println("#"+test_case+" "+result);
		}
	}

}
