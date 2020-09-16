import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {

	static ArrayList<VNode> list;
	static int[] par = new int[100010];
	static int r = 0, N, M;

	static int find(int x) {
		if (par[x] == x)
			return x;
		return par[x] = find(par[x]);
	}

	static void merge(int a, int b, int v) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		par[a] = b;
		r += v;
		N--;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			par[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new VNode(v, new Node(a, b)));
		}
		Collections.sort(list);
		for (VNode node : list) {
			if (N == 2)
				break;
			int a = node.n.a;
			int b = node.n.b;
			int v = node.v;
			merge(a, b, v);
		}
		System.out.println(r);
	}

	static class VNode implements Comparable<VNode> {
		int v;
		Node n;

		public VNode(int v, Node n) {
			this.v = v;
			this.n = n;
		}

		@Override
		public int compareTo(VNode o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.v, o.v);
		}
	}

	static class Node {
		int a;
		int b;

		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
