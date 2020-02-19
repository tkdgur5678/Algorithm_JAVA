package algo_basic.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_8888_D3_시험 {
	public static class Person implements Comparable<Person> {
		int num;
		int score;
		int count;

		public Person(int num, int score, int count) {
			this.num = num;
			this.score = score;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Person [num=" + num + ", score=" + score + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			if (this.score == o.score) {
				if (this.count == o.count) {
					return Integer.compare(this.num, o.num);
				}
				return Integer.compare(this.count, o.count) * -1;
			}
			return Integer.compare(this.score, o.score) * -1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int Tc = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= Tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int[][] ques = new int[N][T];
			int[] value = new int[T];
			int[] score = new int[N];
			int[] count = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < T; j++) {
					ques[i][j] = Integer.parseInt(st.nextToken());
					if (ques[i][j] == 0) {
						value[j]++;
					} else {
						count[i]++;
					}
				}
			}
			// 점수 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < T; j++) {
					if (ques[i][j] == 1)
						score[i] += value[j];
				}
			}
			// 등수 체크
			ArrayList<Person> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(new Person(i + 1, score[i], count[i]));
			}
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).num == P) {
					System.out.println("#" + test_case + " " + list.get(i).score + " " + (i+1));
				}
			}
		}

	}

}
