import java.util.Scanner;

public class BOJ_2839_¼³ÅÁ¹è´Ş {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;

		while (N % 5 != 0 && N >= 0) {
			N -= 3;
			result++;
		}
		System.out.println(N < 0 ? -1 : N / 5 + result);
	}

}
