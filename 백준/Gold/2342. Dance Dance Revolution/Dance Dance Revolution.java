import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][][] dp = new int[5][5][2]; //왼발, 오른발, 숫자 표시
        int now = 1;
        int pre = 2;

        int B =  Integer.parseInt(st.nextToken());
        dp[B][0][1] = power(0,B);
        dp[0][B][1] = power(0,B);

        while (true) {
           int A =  Integer.parseInt(st.nextToken());
           if (A==0) break;
           now++;
           now%=2;
           pre++;
           pre%=2;
           for (int i=0;i<5;i++) for (int j=0;j<5;j++) dp[i][j][now]=0;

           for (int i=0;i<5;i++){
               for (int j=0;j<5;j++){
                   if (dp[i][j][pre]==0) continue;
                   if (dp[A][j][now]==0) {
                       dp[A][j][now] = dp[i][j][pre] + power(i,A);
                   } else {
                       dp[A][j][now] = Math.min(dp[A][j][now],dp[i][j][pre] + power(i,A));
                   }
                   if (dp[i][A][now]==0) {
                       dp[i][A][now] = dp[i][j][pre] + power(j,A);
                   } else {
                       dp[i][A][now] = Math.min(dp[i][A][now],dp[i][j][pre] + power(j,A));
                   }
               }
           }
        }

        int min = 1_000_000;
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if (dp[i][j][now]==0) continue;
                min = Math.min(min,dp[i][j][now]);
            }
        }

        System.out.println(min);

    }

    static int power(int a, int b) {

        if (a==0) return 2;
        else if (a==b) return 1;
        else if (Math.abs(a-b)==2) return 4;
        else return 3;

    }
}