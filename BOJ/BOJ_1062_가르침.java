import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BOJ_1062_가르침 {

	static int N, K, max;
	static String[] word;
	static boolean[] alpha = new boolean[26];
	static ArrayList<Character> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt() - 5;

		if (K < 0) {
			System.out.println(0);
			return;
		}
		word = new String[N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			word[i] = str.substring(4, str.length() - 4);
		}

		setAlpha(new char[] { 'a', 'c', 'i', 't', 'n' });
		list = getList();

		if (list.size() <= K)
			max = N;
		else
			comb(0, 0);
		System.out.println(max);
	}

	static void comb(int start, int depth) {
		if (depth == K) {
			// 처리
			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				String str = word[i];
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					if(!alpha[c-'a']) {
						flag = false;
						break;
					}
				}
				if(flag) count++;
			}
			if(max<count) max = count;
			return;
		}

		for (int i = start; i < list.size(); i++) {
			char c = list.get(i);
			alpha[c - 'a'] = true;
			comb(i + 1, depth + 1);
			alpha[c - 'a'] = false;
		}
	}

	static ArrayList<Character> getList() {
		HashSet<Character> set = new HashSet<>();
		ArrayList<Character> ret = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < word[i].length(); j++) {
				char c = word[i].charAt(j);
				if (!alpha[c - 'a'])
					set.add(c);
			}
		}
		ret.addAll(set);
		return ret;
	}

	static void setAlpha(char[] arr) {
		for (char c : arr) {
			alpha[c - 'a'] = true;
		}
	}
}
