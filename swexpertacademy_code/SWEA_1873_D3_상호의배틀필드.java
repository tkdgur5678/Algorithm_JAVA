import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1873_D3_상호의배틀필드 {

	private static char[][] map;
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, -1, 1 };
	private static char[] dir = { '^', 'v', '<', '>' };
	private static int H, W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
			}
			// 탱크 위치와 방향 찾기
			int ti = -1, tj = -1;
			int td = -1;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					char c = map[i][j];
					for (int k = 0; k < dir.length; k++) {
						if(c == dir[k]) {
							ti = i;
							tj = j;
							td = k;
						}
					}
				}
			}
			// 동작 입력
			int N = sc.nextInt();
			char[] input = sc.next().toCharArray();
			for (int i = 0; i < N; i++) {
				char c = input[i];
				int ni = -1, nj = -1;
				if(c == 'S') {	//슈팅 동작일때
					int k = 1;
					while(true) {
						ni = ti+dy[td]*k;
						nj = tj+dx[td]*k;
						k++;
						if(!isIn(ni,nj) || map[ni][nj] == '#') {	//맵밖으로 나갔거나 강철벽을 만났을때 break
							break;
						}
						if(map[ni][nj] == '*') {	//벽을 만났다면 평지로 바꿔주고 break
							map[ni][nj] = '.';
							break;
						}
					}
					continue;
				}
				switch (c) {
				case 'U':
					td = 0;
					break;
				case 'D':
					td = 1;
					break;
				case 'L':
					td = 2;
					break;
				case 'R':
					td = 3;
					break;
				}
				map[ti][tj] = dir[td];	//탱크 방향을 옮겨줌
				ni = ti+dy[td];
				nj = tj+dx[td];
				if(isIn(ni,nj) && map[ni][nj] == '.') {	//맵 안이면서 평지일때
					map[ni][nj] = map[ti][tj];	//탱크 위치를 옮겨줌
					map[ti][tj] = '.';			//이전값을 평지로 바꿈
					ti = ni;
					tj = nj;							
				}
			}
			//출력
			System.out.print("#"+test_case+" ");
			for (char[] ca : map) {
				System.out.println(ca);
			}
		}
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < H && j < W;
	}
}
