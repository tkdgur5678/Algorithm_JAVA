package test;

import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA_1240_D3_1일차_단순2진암호코드 {
 
    public static int checkCode(String num) {
        switch (num) {
        case "0001101":
            return 0;
        case "0011001":
            return 1;
        case "0010011":
            return 2;
        case "0111101":
            return 3;
        case "0100011":
            return 4;
        case "0110001":
            return 5;
        case "0101111":
            return 6;
        case "0111011":
            return 7;
        case "0110111":
            return 8;
        case "0001011":
            return 9;
        default:
            return -1;
        }
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T, N, M;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            String[] input = new String[N];
            // char[][] arr = new char[N][M];
            for (int i = 0; i < input.length; i++) {
                input[i] = sc.next();
            }
            boolean flag = false;
            for (int i = 0; i < input.length; i++) {
                String subStr ="";
                int sum = 0;
                if(input[i].contains("1")) {
                    for (int j = input[i].length()-1; j >= 0; j--) {
                        if(input[i].charAt(j) == '1' && j-55>=0) {
                            subStr = input[i].substring(j-55, j+1);
                            break;
                        }
                    }
                }
                else {
                    continue;
                }
                for (int j = 0; j < subStr.length(); j+=7) {
                    int num = checkCode(subStr.substring(j,j+7));
                    result += num;
                    if (j % 2 == 0)
                        num *= 3;
                    sum += num;
                }
                if(sum%10 != 0) {
                    result = 0;
                    break;
                }
                else {
                    break;
                }
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
 
}
