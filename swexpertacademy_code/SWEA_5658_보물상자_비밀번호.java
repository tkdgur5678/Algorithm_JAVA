package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SWEA_5658_보물상자_비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String num = sc.next();
			num += num;
			int len = N / 4;
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < 4; j++) {
					int idx = i + j * len;
					set.add(num.substring(idx, idx + len));
				}
			}
			List<String> list = new ArrayList<>(set);
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						for (int i = 0; i < o1.length(); i++) {
							if (o1.charAt(i) != o2.charAt(i)) {
								return Integer.compare(o1.charAt(i), o2.charAt(i)) * -1;
							}
						}
					}
					return Integer.compare(o1.length(), o2.length()) * -1;
				}
			});
			String str = list.get(K - 1);
			int result = 0;
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i);
				c = (c >= 65) ? c - 55 : c - 48;
				result += Math.pow(16, str.length() - i - 1) * c;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
