import java.util.*;
import java.math.*;
public class Main {
	
	static int dp[] ;
	
	public static void BOJ_1699_제곱수(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new int[100001];
		dp[1] =1;
		
		for(int i=2;i<=n;i++) {	 
			dp[i]=i; 
			for(int j=1;j*j<=i;j++) { 
				dp[i] = Math.min(dp[i-(j*j)]+1,dp[i]); 
			}
		}
		
		System.out.println(dp[n]);
			
	}
	
}
