import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] dp = new long[57];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        dp[0] = 0; //2^0-1은 0개
        dp[1] = 1; //2^1-1은 1개
        for (int i=2;i<57;i++) dp[i] = dp[i-1]*2+(long)Math.pow(2,i-1);
        System.out.println(def(B)-def(A-1));
    }

    static long def(long num){

        if (num ==0) return 0;
        if (num ==1) return 1;

        long temp = num;
        int cnt = 0;

        while (temp>1){
            temp/=2;
            cnt++;
        }

        long dif = (long)Math.pow(2,cnt);

        return dp[cnt]+1+num-dif+def(num-dif);
    }

}