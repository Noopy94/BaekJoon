class Solution {
    public long solution(int n) {
        int[] dp = new int[2];
        dp[0] = 2;
        dp[1] = 1;
        if (n==1) return 1;
        if (n==2) return 2;
        int cnt =3;
        while (cnt<=n){
            dp[cnt%2]= (dp[0]+dp[1])%1234567;
            cnt++;
        }
        
        return dp[n%2]%1234567;
        
    }
}