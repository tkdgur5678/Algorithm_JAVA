import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916_부분문자열 {
	private static int[] fail;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String P = br.readLine();

		fail = new int[P.length()];

		for (int i = 1, j = 0; i < P.length(); i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = fail[j - 1];
			}
			if (P.charAt(i) == P.charAt(j)) {
				fail[i] = ++j;
			}
		}

		for (int i = 0, j = 0; i < S.length(); i++) {
			while (j > 0 && S.charAt(i) != P.charAt(j)) {
				j = fail[j - 1];
			}
			if (S.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					System.out.println(1);
					return;
				} else {
					++j;
				}
			}
		}
		
		System.out.println(0);
	}
}
