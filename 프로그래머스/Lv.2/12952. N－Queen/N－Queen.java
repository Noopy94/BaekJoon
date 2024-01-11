class Solution {
    
    static int answer;
    static int[] arr;
    static int N;
    
    public int solution(int n) {
        answer = 0;
        arr = new int[n];
        N = n;
        def(0);
        return answer;
    }
    
    public void def(int index){
        
        if (index==N) {
            answer++;
            return;
        }
        
        for (int i=0;i<N;i++){
            arr[index] = i;
            
            if (possibility(index)) def(index+1);
            
        }
        
    }
    
    public boolean possibility(int index){
        
        for (int i=0;i<index;i++){
            if (arr[i]==arr[index]) return false;
            if (Math.abs(arr[index]-arr[i])==Math.abs(index-i)) return false;
        } 
        
        return true;
        
    }
    
    
}