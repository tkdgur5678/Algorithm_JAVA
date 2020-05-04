import java.util.Scanner;

public class BOJ_2153_돌떨구기 {
	public static char[][] a;
	public static putanja[] P;
	public static int R, S, N;

	static class putanja {
		int stupac[];
		int r;

		public putanja() {
			stupac = new int[30000];
		}
		
		void ubaci() {
			a[r - 1][stupac[r - 1]] = 'O';
		}

		void sredi() {
			while (true) {
				int s = stupac[r - 1];
				
				if (r > 1 && a[r - 1][s] != '.') {
					--r;
					continue;
				}
				
				if (r == R)
					break;
				if (a[r][s] == 'X')
					break;
				if (a[r][s] == '.') {
					stupac[r++] = s;
				} else {
					if (s > 0 && a[r][s - 1] == '.' && a[r - 1][s - 1] == '.') {
						stupac[r++] = s - 1;
					} else if (s + 1 < S && a[r][s + 1] == '.' && a[r - 1][s + 1] == '.') {
						stupac[r++] = s + 1;
					} else {
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		S = sc.nextInt();
		a = new char[30000][32];
		P = new putanja[30];
		for (int i = 0; i < R; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < S; j++) {
				a[i][j] = temp[j];
			}
		}
		for (int i = 0; i < S; i++) {
			P[i] = new putanja();
			P[i].stupac[0] = i;
			P[i].r = 1;
			P[i].sredi();
		}
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt() - 1;
			P[s].ubaci();
			for (int j = 0; j < S; j++) {
				P[j].sredi();
			}
		}
		for (int i = 0; i < R; i++) {
			for (int s = 0; s < S; s++) {
				System.out.print(a[i][s]);
			}
			System.out.println();
		}
	}

}
