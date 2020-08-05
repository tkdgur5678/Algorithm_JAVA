import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2998_8Áø¼ö {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		HashMap<String, String> hm = new HashMap<>();
		hm.put("000", "0");
		hm.put("001", "1");
		hm.put("010", "2");
		hm.put("011", "3");
		hm.put("100", "4");
		hm.put("101", "5");
		hm.put("110", "6");
		hm.put("111", "7");
		String result = "";
		while (input.length() >= 3) {
			String temp = input.substring(input.length() - 3, input.length());
			input = input.substring(0, input.length() - 3);
			result = hm.get(temp) + result;
		}
		if (input.length() > 0) {
			for (int i = 0; i <= 3 - input.length(); i++) {
				input = "0" + input;
			}
			result = hm.get(input) + result;
		}
		System.out.println(result);
	}

}
