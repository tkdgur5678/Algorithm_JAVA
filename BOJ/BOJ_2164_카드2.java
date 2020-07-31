import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2164_Ä«µå2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new LinkedList<>();
		for (int i = N; i >= 1; i--) {
			list.add(i);
		}
		while (list.size() > 1) {
			list.remove(list.size() - 1);
			list.add(0,list.get(list.size()-1));
			list.remove(list.size() - 1);
		}
		System.out.println(list.get(0));

	}

}
