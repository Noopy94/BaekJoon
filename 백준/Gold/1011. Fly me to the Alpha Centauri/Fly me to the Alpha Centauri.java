import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dp = new long[100000];
		
		for (int tc=0;tc<T;tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int A = Y-X; 
			
			int N=0;
			
			while (A>teleport(N)) {
				N++;
			}
			
			sb.append(N+"\n");

			
		}
		
		System.out.println(sb);
		
		
	}
	
	static long teleport(int N){
		
		if (N==0) return dp[0]=0; 
		
		if (dp[N]!=0) return dp[N];
		
		else {
			if (N%2==0) return dp[N]= ((long)N*N+2*N)/4l;
			
			else return dp[N]= (N+1)*(long)(N+1)/4l;
		}
	}

}