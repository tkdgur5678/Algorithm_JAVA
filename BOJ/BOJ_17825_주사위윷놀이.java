import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_17825_주사위윷놀이 {
	
	static int[] order,temp;
	static int[][] map;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		order = new int[10];
		temp = new int[10];
		for (int i = 0; i < 10; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new int[5][];
		map[0] = new int[21];
		for (int i = 1; i <= 20; i++) {
			map[0][i]=i*2;
		}
		map[1] = new int[]{10,13,16,19,25,30,35,40};
		map[2] = new int[]{ 0,20,22,24,25,30,35,40};
		map[3] = new int[]{30,28,27,26,25,30,35,40};
		map[4] = new int[]{25,30,35,40};
		
		permutation(0);
		
		bw.write(String.valueOf(max));
		bw.flush();
		br.close();
		bw.close();
	}
	private static void permutation(int idx) {
		if(idx==10) {
			int[][] loc = new int[4][2];
			boolean[][] visited = new boolean[5][];
			visited[0] = new boolean[21];
			visited[1] = new boolean[8];
			visited[2] = new boolean[8];
			visited[3] = new boolean[8];
			visited[4] = new boolean[4];
			
			int sum = 0;
			int k = 0;
			L : while(k!=10) {
				
				int curMal = temp[k];
				if(loc[curMal][0] < 0) break L;
				visited[loc[curMal][0]][loc[curMal][1]] = false;
				
				loc[curMal][1] += order[k];
				// 범위 밖이라면 -1로 바꿔줘서 다음에 break;
				if(loc[curMal][0] == 0 && loc[curMal][1] > 20) {
					loc[curMal][0] = -1;
					k++;
					continue L;
				}
				else if(loc[curMal][0] == 1 && loc[curMal][1] > 7) {
					loc[curMal][0] = -1;
					k++;
					continue L;
				}
				else if(loc[curMal][0] == 2 && loc[curMal][1] > 7) {
					loc[curMal][0] = -1;
					k++;
					continue L;
				}
				else if(loc[curMal][0] == 3 && loc[curMal][1] > 7) {
					loc[curMal][0] = -1;
					k++;
					continue L;
				}
				else if(loc[curMal][0] == 4 && loc[curMal][1] > 3) {
					loc[curMal][0] = -1;
					k++;
					continue L;
				}
				
				// 0번 배열에 5, 10, 15번 인덱스일 때 이동
				if(loc[curMal][0] == 0 && loc[curMal][1] == 5) {
					loc[curMal][0] = 1;
					loc[curMal][1] = 0;
					if(visited[1][0]) break L;
					visited[1][0] = true;
					sum+=map[loc[curMal][0]][loc[curMal][1]];
					k++;
					continue L;
				}
				else if(loc[curMal][0] == 0 && loc[curMal][1] == 10) {
					loc[curMal][0] = 2;
					loc[curMal][1] = 1;
					if(visited[2][1]) break L;
					visited[2][1] = true;
					k++;
					sum+=map[loc[curMal][0]][loc[curMal][1]];
					continue L;
				}
				else if(loc[curMal][0] == 0 && loc[curMal][1] == 15) {
					loc[curMal][0] = 3;
					loc[curMal][1] = 0;
					if(visited[3][0]) break L;
					visited[3][0] = true;
					sum+=map[loc[curMal][0]][loc[curMal][1]];
					k++;
					continue L;
				}
				else if((loc[curMal][0]==1||loc[curMal][0]==2||loc[curMal][0]==3) && loc[curMal][1] > 3) {
					loc[curMal][0] = 4;
					loc[curMal][1] -= 4;
					if(visited[4][loc[curMal][1]]) break L;
					visited[4][loc[curMal][1]] = true;
					sum+=map[loc[curMal][0]][loc[curMal][1]];
					k++;
					continue L;
				}
				else if((loc[curMal][0]==0) && loc[curMal][1] == 20) {
					loc[curMal][0] = 4;
					loc[curMal][1] = 3;
					if(visited[4][3]) break L;
					visited[4][3] = true;
					sum+=map[loc[curMal][0]][loc[curMal][1]];
					k++;
					continue L;
				}
				
				if(visited[loc[curMal][0]][loc[curMal][1]])
					break L;
				
				visited[loc[curMal][0]][loc[curMal][1]] = true;
				sum+=map[loc[curMal][0]][loc[curMal][1]];
				k++;
			}
			if(max<sum)
				max=sum;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			temp[idx]=i;
			permutation(idx+1);
		}
	}

}
