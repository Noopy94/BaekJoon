import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static long P = 1000000007;
    static long[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        dp = new long[4_000_001];
        dp[0] = 1;
        for (int i=1;i<=4_000_000;i++) dp[i]=(dp[i-1]*i)%P;
        for (int i=0;i<TC;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            long numer = dp[N];
            long denom = dp[K] * dp[N-K] % P;
            sb.append(numer * pow(denom, P - 2) % P).append("\n");
        }

        System.out.println(sb);

    }
    static long pow(long base, long expo) {

        if (expo == 1) {
            return base % P;
        }

        long temp = pow(base, expo / 2);

        if (expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }

        return temp * temp % P;
    }

}