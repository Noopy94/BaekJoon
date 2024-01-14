import sun.security.krb5.internal.rcache.DflCache;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int index, cnt;

		public Node(int index, int cnt) {
			this.index = index;
			this.cnt = cnt;
		}
	}

	static List<Node>[] list;
	static boolean[] visited;

	static int endIndex;
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		max = 0;
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

		for (int i = 0; i < N-1; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}

		visited[1] = true;
		dfs(1, 0);

		visited = new boolean[N+1];
		visited[endIndex] = true;
		dfs(endIndex,0);
		System.out.println(max);

	}

	static void dfs(int index, int sum) {


		if (sum>max) {
			max = sum;
			endIndex = index;
		}

		for (Node temp : list[index]){
			if (!visited[temp.index]){
				visited[temp.index] = true;
				dfs(temp.index, sum+temp.cnt);
			}
		}
	}

}