import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_16890_창업 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Gusaga = br.readLine();
		String Cuvelover = br.readLine();

		int len = Gusaga.length();
		ArrayList<Character> gu = new ArrayList<>();
		ArrayList<Character> cu = new ArrayList<>();
		ArrayList<Character> result = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			gu.add(Gusaga.charAt(i));
			cu.add(Cuvelover.charAt(i));
			result.add(' ');
		}
		Collections.sort(gu);
		Collections.sort(cu);

		int turn = 0;
		// 구사과는 사전 앞에 나오는 이름
		int gl = 0, gr = (len + 1) / 2 - 1;
		// 큐브러버는 사전 뒤에 나오는 이름
		int cl = (len + 1) / 2, cr = len - 1;
		// 결과
		int rl = 0, rr = len - 1;
		while (turn < len) {
			if ((turn & 1) == 0) { // Gusaga
				// 구사과의 가장 앞선 단어가 큐브러버의 가장 뒷단어보다 앞에 온다면
				if (gu.get(gl) < cu.get(cr)) { // 맨앞칸에 놔야됨
					result.set(rl++, gu.get(gl++));
				} else { // 큐브러버의 단어가 구사과의 가장 앞단어보다 다 앞에오니 뒤에서부터 채움
					result.set(rr--, gu.get(gr--));
				}
			} else { // Cuvelover
				if (gu.get(gl) < cu.get(cr)) {
					result.set(rl++, cu.get(cr--));
				} else {
					result.set(rr--, cu.get(cl++));
				}
			}
			turn++;
		}
		for (Character c : result) {
			System.out.print(c);
		}
		System.out.println();
	}
}
