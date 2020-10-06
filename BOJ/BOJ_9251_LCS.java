import java.util.*;

public class BOJ_9251_LCS {
	static String a,b;
	
	static int dp[][];
	
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		a=sc.nextLine();
		b=sc.nextLine();
		
		dp = new int[b.length()+1][a.length()+1]; 
		
		for(int i=1;i<=b.length();i++) { 
			
			for(int j=1;j<=a.length();j++) { 
				
				if(b.charAt(i-1) != a.charAt(j-1)) { 
					
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]); 
				}else { 
					dp[i][j] = dp[i-1][j-1]+1;
				}
				
			}		
			
		}
		
		System.out.println(dp[b.length()][a.length()]);
	}
}
