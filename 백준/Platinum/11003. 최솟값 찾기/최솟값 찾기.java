import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int index, score;
		@Override
		public int compareTo(Node o) {
			return this.score-o.score; 
			// 오름차순으로 젤 작은게 먼저오게;
		}
		public Node(int index, int score) {this.index = index; this.score = score;}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		//입력 끝!
		
		LinkedList<Node> list = new LinkedList<Node>();
		for (int i=0;i<N;i++) {
			Node temp = new Node(i, arr[i]);
			while (!list.isEmpty()&& list.getLast().score>temp.score) list.removeLast();
			list.add(temp);
			while (!list.isEmpty()&&list.getFirst().index<i-L+1) list.removeFirst();
			sb.append(list.getFirst().score).append(" ");
		}
		System.out.println(sb);
	}

}