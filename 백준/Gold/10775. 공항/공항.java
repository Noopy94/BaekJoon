import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        dp = new int[G + 1];
        for (int i = 0; i <= G; i++) dp[i] = i; // makeset
        for (int i = 0; i < P; i++) {
            int A = Integer.parseInt(br.readLine());
            int temp = find(A);
            if (temp != 0) {
                cnt++;
                dp[temp]--;
            } else break;
        }

        System.out.println(cnt);

    }

    static int find(int num) {
        if (dp[num] != num) {
            dp[num] = find(dp[num]); 
            return dp[num];
        } else return num;
    }
}