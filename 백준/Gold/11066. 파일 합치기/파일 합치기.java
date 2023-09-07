import java.util.*;
import java.io.*;

public class Main {
    static int dp[][];
    static int novel[];
    static int sum[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            dp = new int[N + 1][N + 1];
            novel = new int[N + 1];
            sum = new int[N + 1];

            for (int i = 1; i <= N ; i++) {
                novel[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + novel[i];
            }

            dp_algorithm();
        }
    }

    public static void dp_algorithm() {
        for (int n = 1; n <= N; n++) {
            for (int i = 1; i + n <= N; i++) {
                int j = i + n;
                dp[i][j] = Integer.MAX_VALUE;

                for (int x = i; x < j; x++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][x] + dp[x+1][j] + (sum[j] - sum[i-1]));
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}