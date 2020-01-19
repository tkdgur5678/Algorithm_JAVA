import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] arr = new int[T];
        for(int test_case = 1; test_case <= T; test_case++)
        {
            arr[test_case-1] = sc.nextInt();
        }
        //배열 정렬
        Arrays.sort(arr);
        System.out.println(arr[T/2]);
    }
}