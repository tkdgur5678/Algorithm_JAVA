package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12852_1로만들기2 {
	static int X, result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		bfs();
	}
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(X);
		q.add(new Node(X,list));
		q.add(new Node(-1,new ArrayList<>()));
		boolean[] visited = new boolean[X+1];
		visited[X] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.num == -1) {
				result++;
				q.add(n);
				continue;
			}
			if(n.num == 1) {
				System.out.println(result);
				for (int b : n.list) {
					System.out.print(b+" ");
				}
				return;
			}
			if(n.num%3 == 0 && !visited[n.num/3]) {
				visited[n.num/3] = true;
				ArrayList<Integer> temp = (ArrayList<Integer>) n.list.clone();
				temp.add(n.num/3);
				q.add(new Node(n.num/3,temp));
			}
			if(n.num%2 == 0 && !visited[n.num/2]) {
				visited[n.num/2] = true;
				ArrayList<Integer> temp = (ArrayList<Integer>) n.list.clone();
				temp.add(n.num/2);
				q.add(new Node(n.num/2,temp));
			}
			if(!visited[n.num-1]) {
				visited[n.num-1] = true;
				ArrayList<Integer> temp = (ArrayList<Integer>) n.list.clone();
				temp.add(n.num-1);
				q.add(new Node(n.num-1,temp));
			}
		}
	}
	static class Node{
		int num;
		ArrayList<Integer> list;
		public Node(int num, ArrayList<Integer> list) {
			this.num = num;
			this.list = list;
		}
	}
}
