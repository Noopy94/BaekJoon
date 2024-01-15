import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		int num;
		String s;

		public Node(int num, String s){
			this.num = num;
			this.s = s;
		}
	}

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];

			Queue<Node> Q = new LinkedList<>();
			Q.add(new Node(A,""));

			while(!Q.isEmpty()){
				Node temp = Q.poll();
				if (!visited[temp.num]) visited[temp.num] = true;
				else continue;

				if (temp.num==B) {
					sb.append(temp.s).append("\n");
					break;
				}
				int tempNum = temp.num;
				int d4 = tempNum%10;
				tempNum/=10;
				int d3 = tempNum%10;
				tempNum/=10;
				int d2 = tempNum%10;
				tempNum/=10;
				int d1 = tempNum%10;

				Q.add(new Node(temp.num*2%10000,temp.s+"D"));
				Q.add(new Node(temp.num == 0 ? 9999 : temp.num-1  ,temp.s+"S"));
				Q.add(new Node(d2*1000+d3*100+d4*10+d1,temp.s+"L"));
				Q.add(new Node(d4*1000+d1*100+d2*10+d3,temp.s+"R"));
			}

		}

		System.out.println(sb);

	}
}