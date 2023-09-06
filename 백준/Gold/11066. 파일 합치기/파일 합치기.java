import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=0;tc<T;tc++) {
			
			int K = Integer.parseInt(br.readLine());
			int[] arr = new int[K+1];
			int[] sum = new int[K+1];
			int[][] dp = new int[K+1][K+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1;i<=K;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1]+arr[i];
			}
			
			for (int i=1;i<=K;i++) {
				for (int from=1;from+i<=K;from++) {
					int to = from +i;
					dp[from][to] = Integer.MAX_VALUE;
					for (int divide = from; divide<to; divide++) dp[from][to] = Math.min(dp[from][to], dp[from][divide]+dp[divide+1][to]+sum[to]-sum[from-1]);
				}
				
			}
			sb.append(dp[1][K]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}