import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int sum = 0, crops = 0, edge = 1;
            String input;
            for (int i = 0; i < N; i++) {
                input = sc.next();
                // input.substring(N/2-1-crops,N/2+crops);
                for (char v : input.substring(N / 2 - crops, N / 2 + 1 + crops).toCharArray()) {
                    sum += (v-'0');
                }
                crops = i < N / 2 ? crops + 1 : crops - 1;
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
 
}
