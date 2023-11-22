class Solution {
    public int[] solution(int n, long left, long right) {
        
        int dif = (int)(right-left+1);
        int[] answer = new int[dif];
        
        for (int i=0;i<dif;i++){
            
            long k= i+left;
            long x = k/n;
            long y = k%n;
            answer[i] = (int)Math.max(x,y)+1;
            
        }
        
        return answer;
    }
}