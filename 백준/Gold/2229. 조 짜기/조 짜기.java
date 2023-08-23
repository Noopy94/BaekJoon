import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) arr[i]= Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        dp[0] = 0;
        for (int i=1;i<=N;i++){
           for (int j=0;j<i;j++){
               int cnt =0;
               int min =10000;
               int max =0;
               for (int k=j+1;k<=i;k++){
                   min = Math.min(min,arr[k]);
                   max = Math.max(max,arr[k]);
               }
               if (max==0) cnt = 0;
               else cnt = max-min;
               dp[i] = Math.max(dp[i], dp[j]+cnt);
           }
        }
        System.out.println(dp[N]);
    }

}