class Solution {
    
    static int cnt0 = 0;
    static int cnt1 = 0;
    
    private void def(int n, int startx, int starty, int[][] arr){
        
        boolean check = true;
        
        for (int i=startx;i<startx+n;i++){
            for (int j=starty;j<starty+n;j++){
                
                if (arr[startx][starty] != arr[i][j]) {
                    check = false;
                    break;
                } 
            }
        }
        
        if (check){
            if (arr[startx][starty]==0) cnt0++;
            else cnt1++;
            return;
        } else {
            def(n/2, startx, starty, arr);
            def(n/2, startx+n/2, starty, arr);
            def(n/2, startx, starty+n/2, arr);
            def(n/2, startx+n/2, starty+n/2, arr);
            return;
        }
        
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr[0].length;
        def(n,0,0,arr);
        answer[0] = cnt0;
        answer[1] = cnt1;
        
        return answer;
    }
}