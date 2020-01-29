import java.util.Scanner;

public class SWEA_1215_D3_3일차_회문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 8;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int len = sc.nextInt();
			char[][] word = new char[N][N];

			for (int i = 0; i < N; i++) {
				word[i] = sc.next().toCharArray();
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 가로 확인
					if(j<N-len+1) {
						sum++;
						for (int k = 0; k < len / 2; k++) {
							if (word[i][j + k] != word[i][j + len - 1 - k]) { // 다르다면
								sum--;
								break;
							}
						}
					}
					// 세로 확인
					if(i<N-len+1) {
						sum++;
						for (int k = 0; k < len/2; k++) {
							if (word[i + k][j] != word[i + len - 1 - k][j]) { // 다르다면
								sum--;
								break;
							}
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}

}
