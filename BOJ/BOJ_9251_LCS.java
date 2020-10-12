import java.io.*;
import java.util.*;
 
public class Main
{
    static int[][] dp = new int[1001][1001];
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String a = br.readLine();
        String b = br.readLine();
        for(int i=0; i<a.length(); i++)
        {
            for(int j=0; j<b.length(); j++)
            {
                if(a.charAt(i) == b.charAt(j))
                {
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else
                {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
