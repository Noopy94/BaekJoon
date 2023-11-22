class Solution {
    public int[] solution(int n, long left, long right) {
        
        int dif = (int)(right-left+1);
        int[] answer = new int[dif];
        
        for (int i=0;i<dif;i++){
            
            long k= i+left;
            int x = (int)(k/n);
            int y = (int)(k%n);
            answer[i] = Math.max(x,y)+1;
            
        }
        
        return answer;
    }
}