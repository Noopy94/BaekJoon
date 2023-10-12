import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		boolean[] visited = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Queue<Integer> Q = new LinkedList<Integer>();
		int S = Integer.parseInt(br.readLine());
		Q.add(S);
		visited[S] = true;
		while (!Q.isEmpty()) {
			int temp = Q.poll();
			int A = temp - arr[temp];
			int B = temp + arr[temp];
			if (A>0&&!visited[A]) {
				Q.add(A);
				visited[A] = true;
			} 
			
			if (B<=N&&!visited[B]) {
				Q.add(B);
				visited[B] = true;
			}
			
		}
		
		int cnt = 0;
		for (int i=1;i<=N;i++) {
			if (visited[i]) cnt++; 
		}
		
		System.out.println(cnt);
		
	}

}