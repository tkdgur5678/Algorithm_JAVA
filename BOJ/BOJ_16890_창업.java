import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_16890_â�� {
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
		// ������� ���� �տ� ������ �̸�
		int gl = 0, gr = (len + 1) / 2 - 1;
		// ť�귯���� ���� �ڿ� ������ �̸�
		int cl = (len + 1) / 2, cr = len - 1;
		// ���
		int rl = 0, rr = len - 1;
		while (turn < len) {
			if ((turn & 1) == 0) { // Gusaga
				// ������� ���� �ռ� �ܾ ť�귯���� ���� �޴ܾ�� �տ� �´ٸ�
				if (gu.get(gl) < cu.get(cr)) { // �Ǿ�ĭ�� ���ߵ�
					result.set(rl++, gu.get(gl++));
				} else { // ť�귯���� �ܾ ������� ���� �մܾ�� �� �տ����� �ڿ������� ä��
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
