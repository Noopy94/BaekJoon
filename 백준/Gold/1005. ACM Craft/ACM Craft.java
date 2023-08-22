import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1;tc<=T;tc++) {
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] time = new int[N+1];
			int[] cnt = new int[N+1];
			int[] result = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i=1;i<=N;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			List<Integer>[] list = new ArrayList[N+1]; 
			
			for (int i=1;i<=N;i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				cnt[b]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			Queue<Integer> Q = new LinkedList<>();
			
			for (int i=1;i<=N;i++) {
				if (cnt[i]==0) {
					Q.offer(i);
					result[i] = time[i];
				}
			}
			
			while (!Q.isEmpty()) {
				
				int temp = Q.poll();
				if (temp == W) break;
				
				for (int c : list[temp]) {
					result[c] = Math.max(result[c], result[temp]+time[c]);
					cnt[c]--;
					if (cnt[c]==0) Q.offer(c);
				}
			}
			
			
			sb.append(result[W]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}