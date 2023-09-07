import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int[] arr;
	static int[] sum;
	static int[][] dp;
	static List<Integer> result;
	
	public static void solve(int K) {
		
		for (int i=1;i<=K;i++) {
		for (int from=1;from+i<=K;from++) {
				int to = from +i;
				dp[from][to] = Integer.MAX_VALUE;
		for (int divide = from; divide<to; divide++) dp[from][to] = Math.min(dp[from][to], dp[from][divide]+dp[divide+1][to]+sum[to]-sum[from-1]);
		}
		}
		
		result.add(dp[1][K]);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		for (int tc=0;tc<T;tc++) {
			
			int K = Integer.parseInt(br.readLine());
			arr = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1;i<=K;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1]+arr[i];
			}
			
			solve(K);
		}
		
		for (int c: result) System.out.println(c);
	}
}