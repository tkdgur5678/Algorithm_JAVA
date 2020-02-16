import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1629_곱셈 {
	static int A, B, C;
	static HashMap<Integer,Long> map = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		map.put(1, (long) (A%C));
		System.out.println(calculate(B));
	}
	
	public static long calculate(int count) {
		//base case
		Long temp = map.get(count);
		if(temp != null) {
			return temp;
		}
		temp = calculate(count/2)*calculate(count-count/2)%C;
		map.put(count, temp);
		return temp;
	}

}
