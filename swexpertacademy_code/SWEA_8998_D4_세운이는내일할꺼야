import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Pair implements Comparable<Pair>{
    int T;
    int D;
    public Pair(Integer t, Integer d) {
        T = t;
        D = d;
    }
    @Override
    public int compareTo(Pair o) {
        if(this.D>o.D)
            return -1;
        return 1;
    }
     
}
public class Solution {
     
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Pair> q  = new PriorityQueue<>();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            q.clear();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                q.offer(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            //알고리즘
            int deadline = q.peek().D;
            Pair p;
            while(!q.isEmpty()) {
                p = q.poll();
                if(deadline > p.D)
                    deadline = p.D - p.T;
                else
                    deadline = deadline - p.T;
            }
            System.out.println("#"+test_case+" "+deadline);
        }
    }
}
