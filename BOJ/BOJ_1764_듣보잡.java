import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class BOJ_1764_µË∫∏¿‚ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<String,Integer> hm = new HashMap<>();
		TreeMap<String,Integer> tm = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			hm.put(sc.next(), 0);
		}
		for (int i = 0; i < M; i++) {
			String str = sc.next();
			if(hm.get(str) != null) {
				tm.put(str,0);
			}
		}
		System.out.println(tm.size());
		for (String string : tm.keySet()) {
			System.out.println(string);
		}
	}

}
