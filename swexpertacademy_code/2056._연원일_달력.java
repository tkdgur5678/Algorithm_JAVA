import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, iMonth, iDay;
        T=sc.nextInt();
        String date, month, day, answer;
        int []month_arr = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            date = sc.next();
            month = date.substring(4,6);
            day = date.substring(6,8);
            iMonth = Integer.parseInt(month);
            iDay = Integer.parseInt(day);
            //월 비교
            if(iMonth>0 && iMonth<=12)
                //일 비교
                if(iDay>0 && iDay<=month_arr[iMonth-1])
                    answer = date.substring(0,4) + "/" + month + "/" + day;
                else
                    answer = "-1";
            else
                answer = "-1";
            System.out.println("#"+test_case+" "+answer);
        }
    }
}