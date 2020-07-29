import java.util.Scanner;

public class BOJ_5218_¾ËÆÄºª°Å¸® {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String str1 = sc.next();
			String str2 = sc.next();
			System.out.print("Distances: ");
			for (int j = 0; j < str1.length(); j++) {
				int temp = (str2.charAt(j)-str1.charAt(j));
				System.out.print((temp>=0? temp : temp+ 26)  +" ");
			}
			System.out.println();
		}
	}

}
