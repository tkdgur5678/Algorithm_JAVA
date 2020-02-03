import java.util.Scanner;

public class SWEA_9317_D3_석찬이의받아쓰기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String result = sc.next();
			String SC = sc.next();
			int count = 0;
			for (int i = 0; i < SC.length(); i++) {
				if(SC.charAt(i)==result.charAt(i))
					count++;
			}
			System.out.println("#"+test_case+" "+count);
		}
	}

}
