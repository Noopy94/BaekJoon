class Solution {
    public int solution(int n) {
        
        int cnt = 2;
        
        while (true){
            if (n%cnt==1) {
                return cnt;
            } 
            cnt++;
        }
        
        
    }
}